<%@ page import="com.synisys.training.filters.LoginFilter" %>
<%@ page import="com.synisys.training.servlets.EditServlet" %>
<%@ page import="com.synisys.training.entities.Entity" %>
<%@ page import="com.synisys.training.entities.Project" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="ProjectBean" class="com.synisys.training.beans.ProjectBean"/>
<jsp:useBean id="Data" class="com.synisys.training.beans.DataBean"/>
<html>
<head>
    <title>Project Add/Edit Form</title>
    <link rel='stylesheet' type='text/css' href='./css/main.css'>
    <link rel='stylesheet' type='text/css' href='./css/style.css'>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).on("click", "#close", function () {
            $.post("EditServlet", {
                "<%=EditServlet.OPERATION_TYPE_KEY%>": "<%=EditServlet.CLOSE_OPERATION_TYPE%>"
            }).done(
                function () {
                    window.location.replace("/ProjectList.jsp?" + "<%=LoginFilter.USERNAME_FIELD_NAME + "=" + LoginFilter.USERNAME+"&"+LoginFilter.PASSWORD_FIELD_NAME + "=" + LoginFilter.PASSWORD %>");
                }
            );
        });

        $(document).on("click", "#save", function () {
            obj = {
                "<%=EditServlet.OPERATION_TYPE_KEY%>": "<%=EditServlet.SAVE_OPERATION_TYPE%>",
                "<%=Entity.ID_KEY%>": ${ProjectBean.project.id},
                "<%=Project.TITLE_KEY%>": $("#title").val(),
                "<%=Project.TOTAL_AMOUNT_KEY%>": $("#totalAmount").val(),
                "<%=Project.DESCRIPTION_KEY%>": $("#description").val(),
                "<%=Project.CURRENCY_KEY%>": $("select#currency").val(),
                "<%=Project.SUB_SECTOR_KEY%>": $("select#subsector").val()
            };
            $.post("EditServlet", obj);
            window.location.replace("/ProjectList.jsp?" + "<%=LoginFilter.USERNAME_FIELD_NAME + "=" + LoginFilter.USERNAME+"&"+LoginFilter.PASSWORD_FIELD_NAME + "=" + LoginFilter.PASSWORD %>");
        });

        $(document).on("change", "#sector", function () {
            $.post("EditServlet", {
                "<%=EditServlet.OPERATION_TYPE_KEY%>": "<%=EditServlet.GET_SUB_SECTORS_OPERATION_TYPE%>",
                "<%=Project.SECTOR_KEY%>": $("select#sector").val()
            }, function (data) {
                data = data.split(",.,");
                $("#subsector").text("");
                for (var i = 0; i < data.length; i++) {
                    obj = JSON.parse(data[i]);
                    $("#subsector").append("<option value=" + obj.id + ">" + obj.name + "</option>");
                }
            });
        });
    </script>
</head>
<body class='body-style'>
<div class='main-container'>

    <h1 class='section-title fontSize18 floatLeft'>Project Add/Edit Form</h1>
    <div class="clear"></div>
    <div class='content'>

        <div class='field-area fontSize11'><span class='field-title-num'>1</span> <span class='field-title'>Project Title</span>
        </div>
        <input id="title" class='input-style input-style1 input-req-style' type='text'
               value="${ProjectBean.project.title}"/>

        <div class='field-area fontSize11'><span class='field-title-num'>2</span> <span
                class='field-title'>Description</span></div>
        <textarea id="description"
                  class='input-style input-style1 input-req-style'>${ProjectBean.project.description}</textarea>

        <div class='field-area fontSize11'><span class='field-title-num'>3</span> <span
                class='field-title'>Total Amount</span></div>
        <input id="totalAmount" class='input-style2 input-req-style' type='text'
               value="${ProjectBean.project.totalAmount}"/>
        <select class='input-style input-req-style' id="currency">
            <c:forEach var="currency" items="${Data.currencies}">
                <option ${currency.id == ProjectBean.project.currencyId ? 'selected':''} value="${currency.id}"><c:out
                        value="${currency.name}"/></option>
            </c:forEach>
        </select>


        <div class='field-area fontSize11'><span class='field-title-num'>4</span> <span class='field-title'>Project Sectors</span>
        </div>
        <select class='input-style select-style input-req-style' id="sector">
            <c:forEach var="sector" items="${Data.sectors}">
                <option ${sector.id == ProjectBean.sectorId ? 'selected':''} value="${sector.id}"><c:out
                        value="${sector.name}"/></option>
            </c:forEach>
        </select>

        <select class='input-style select-style input-req-style' id="subsector">
            <c:forEach var="subsector" items="${Data.subSectors}">
                <c:if test="${subsector.sectorId==ProjectBean.sectorId}">
                    <option ${subsector.id == ProjectBean.project.subSectorId ? 'selected':''} value="${subsector.id}">
                        <c:out
                                value="${subsector.name}"/></option>
                </c:if>
            </c:forEach>
        </select>

        <div class='floatRight'>
            <button id="save" class='button-style1'>Save and Close</button>
            <button id="close" class='button-style1'>Cancel</button>
        </div>
    </div>
</div>
</body>
</html>
