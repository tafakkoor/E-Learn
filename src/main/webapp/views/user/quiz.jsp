<%--
  Created by IntelliJ IDEA.
  User: manguberdi
  Date: 17/02/23
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500&display=swap');

    * {
        box-sizing: border-box;
    }

    body {
        background-color: #b8c6db;
        background-image: linear-gradient(315deg, #b8c6db 0%, #f5f7f7 100%);
        font-family: 'Poppins', sans-serif;
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        overflow: hidden;
        margin: 0;
    }

    .quiz-container {
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px 2px rgba(100, 100, 100, 0.1);
        width: 600px;
        overflow: hidden;
    }

    .quiz-header {
        padding: 4rem;
    }

    h2 {
        padding: 1rem;
        text-align: center;
        margin: 0;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    ul li {
        font-size: 1.2rem;
        margin: 1rem 0;
    }

    ul li label {
        cursor: pointer;
    }

    button {
        background-color: #03cae4;
        color: #fff;
        border: none;
        display: block;
        width: 100%;
        cursor: pointer;
        font-size: 1.1rem;
        font-family: inherit;
        padding: 1.3rem;
    }

    button:hover {
        background-color: #04adc4;
    }

    button:focus {
        outline: none;
        background-color: #44b927;
    }
</style>
<body>
<div class="quiz-container" id="quiz">
    <div class="quiz-header">
        <h2 id="question"><input type="hidden" id="questionId"  value=""> Question Text</h2>
        <ul>
            <li>
                <input type="radio" name="answer" id="a" class="answer">
                <label for="a" id="a_text">Answer</label>
            </li>
            <li>
                <input type="radio" name="answer" id="b" class="answer">
                <label for="b" id="b_text">Answer</label>
            </li>
            <li>
                <input type="radio" name="answer" id="c" class="answer">
                <label for="c" id="c_text">Answer</label>
            </li>
            <li>
                <input type="radio" name="answer" id="d" class="answer">
                <label for="d" id="d_text">Answer</label>
            </li>
        </ul>
    </div>
    <button id="submit">Submit</button>
</div>
<input type="hidden" name="answer" id="userAnswer" value="">

<script>
    const answerEls = document.querySelectorAll('.answer')
    let score = 0
    deselectAnswers()
    function deselectAnswers() {
        answerEls.forEach(answerEl => answerEl.checked = false)
    }
    function getSelected() {
        let answer
        answerEls.forEach(answerEl => {
            if (answerEl.checked) {
                answer = answerEl.id
            }
        })
        const questionId = document.getElementById("questionId")
        document.getElementById("userAnswer").value = answer + "," + questionId.value
        deselectAnswers()
    }
</script>
</body>
</html>