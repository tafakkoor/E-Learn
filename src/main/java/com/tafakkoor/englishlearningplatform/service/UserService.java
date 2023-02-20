package com.tafakkoor.englishlearningplatform.service;

import com.tafakkoor.englishlearningplatform.dao.UserDAO;
import com.tafakkoor.englishlearningplatform.domains.Users;
import com.tafakkoor.englishlearningplatform.utils.AES;
import com.tafakkoor.englishlearningplatform.utils.Encrypt;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserService {
    public static final int minutes = 60;
    public static final int hours = 3600;
    public static final int oneDay = 86400;
    public static Cookie createCookie(String value) {
        Cookie cookie = new Cookie("remember_me", value);
        cookie.setPath("/");
        cookie.setMaxAge(oneDay);
        return cookie;
    }
    public static void register(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users newUser = Users.builder()
                .email(email)
                .username(username)
                .password(Encrypt.hashPassword(password))
                .build();

        UserDAO.getInstance().save(newUser);
        response.sendRedirect("/login");
    }
    public static boolean isCorrectPassword(String password, String hashedPassword) {
        return Encrypt.checkPassword(password, hashedPassword);
    }
    public static boolean isCorrectPass(String userId, String password){
        return isCorrectPassword(password, UserDAO.getInstance().findById(Long.parseLong(userId)).getPassword());
    }
}