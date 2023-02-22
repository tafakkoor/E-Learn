package com.tafakkoor.englishlearningplatform.dao;

import com.tafakkoor.englishlearningplatform.domains.UsersTestsHistory;

public class UserTestHistoryDao extends BaseDAO<UsersTestsHistory, Integer> {
    public static UserTestHistoryDao getInstance() {
        return new UserTestHistoryDao();
    }
}
