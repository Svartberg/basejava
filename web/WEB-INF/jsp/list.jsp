<%@ page import="java.util.List" %>
<%@ page import="com.urise.webapp.model.Resume" %>
<%@ page import="com.urise.webapp.model.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Список всех резюме</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <br/>
    <div style="border: 1px; background-color: aquamarine; width: 150px; padding: 5px; margin: 3px;">
        <a href="resume?action=add">Add Resume</a>
    </div>
    <br>
    <table id="t01" border="1" cellpadding="8" cellspacing="0" style="margin: auto">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume" type="com.urise.webapp.model.Resume"/>
            <tr>
                <td><a href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a></td>
                <td><%=ContactType.MAIL.toHtml(resume.getContact(ContactType.MAIL))%></td>
                <td><a href="resume?uuid=${resume.uuid}&action=delete">Delete</a></td>
                <td><a href="resume?uuid=${resume.uuid}&action=edit">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
