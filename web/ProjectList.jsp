<%@ page import="com.synisys.training.servlets.EditServlet" %>
<%@ page import="com.synisys.training.entities.Entity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project List</title>
    <link rel='stylesheet' type='text/css' href='./css/main.css'>
    <link rel='stylesheet' type='text/css' href='./css/style.css'>
</head>
<body class='body-style'>
<div class='main-container'>
    <div class='content'>
        <div class='field-area fontSize11'><span class='field-title'>Projects List</span></div>

        <jsp:useBean id="holderBean" class="com.synisys.training.beans.DataBean"/>

        <table>
            <tr>
                <th class='table-header th-style1'></th>
                <th class='table-header th-style'><span>Projects</span></th>
            </tr>
            <c:forEach var="project" items="${holderBean.projects}">
                <tr id="${project.id}">
                    <td class='td-style'><a href="/DeleteServlet?<%=Entity.ID_KEY%>=${project.id}" class='ico-del1' title="Delete">X</a>
                    </td>
                    <td class='td-style'><a href="/EditServlet?<%=EditServlet.TYPE_KEY%>=<%=EditServlet.EDIT_TYPE%>&<%=Entity.ID_KEY%>=${project.id}" class='link-style'><c:out
                            value="${project.title}"/></a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
            <a href="/EditServlet?<%=EditServlet.TYPE_KEY%>=<%=EditServlet.ADD_TYPE%>">
            <button class='button-style1'>Add</button>
        </a>

    </div>
</div>
</body>
</html>
