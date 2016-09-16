<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 05.09.16
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/select_mark.js"></script>

    <spring:url value="/resources/css/dropdown.css" var="bootCSS" ></spring:url>
    <link rel="stylesheet" href="${bootCSS}"/>

</head>
<script>



</script>
</head>
<body>

<div class="select">
    <select id="first-choice">
        <option selected value="base">Please Select Mark</option>
        <c:forEach var="carMarksTop" items="${carMarksList}">
            <option value="${carMarksTop.carMark}">${carMarksTop.carMark}</option>
        </c:forEach>
    </select>
</div>

<div class="select">
    <select id="second-choice">

    </select>
</div>

</body>
</html>
