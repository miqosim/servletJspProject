<%@ page import="com.synisys.training.filters.LoginFilter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel='stylesheet' type='text/css' href='./css/main.css'>
    <link rel='stylesheet' type='text/css' href='./css/style.css'>
</head>
<body class='body-style'>
<div class='main-container'>
    <div class='content'>
        <form action="ProjectList.jsp" method="post">
            <div class='field-area fontSize11'><span class='field-title-num'>1</span> <span
                    class='field-title'>Login</span>
            </div>
            <input id="username_id" class='input-style input-style1 input-req-style'
                   name="<%=LoginFilter.USERNAME_FIELD_NAME%>" type="text"/>
            <div class='field-area fontSize11'><span class='field-title-num'>2</span> <span
                    class='field-title'>Password</span>
            </div>
            <input id="password_input_id" class='input-style input-style1 input-req-style' type="password"
                   name="<%= LoginFilter.PASSWORD_FIELD_NAME%>"/>
            <input type="submit" value="Log in" id="form_button" class='button-style1'/>
        </form>
    </div>
</div>
</body>
</html>
