<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootCSS" ></spring:url>
    <spring:url value="/resources/css/templatemo-style.css" var="templatmo"/>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/select_mark.js"></script>
    <script src="/resources/js/select_region_city.js"></script>
    <script src="/resources/js/fill_title.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${bootCSS}"/>
    <link rel="stylesheet" href="${templatmo}"/>

</head>
<body>
<%@ include file="../jspf/header.jspf"%>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="loginmodal-container">
            <h1>Login to Your Account</h1><br>
            <form>
                <input type="text" name="user" placeholder="Username">
                <input type="password" name="pass" placeholder="Password">
                <input type="submit" name="login" class="login loginmodal-submit" value="Login">
            </form>

            <div class="login-help">
                <a href="#">Register</a> - <a href="#">Forgot Password</a>
            </div>
        </div>
    </div>
</div>
<center>
    <div>

        <form:form method="POST" modelAttribute="carImage" action="/insertImages" enctype="multipart/form-data">


            <form:input path="carId" name="carId"/>
            <form:input path="Files" type="file" name="carImage"/>
            <form:button  type="submit"/>
        </form:form>
    </div>
</center>
</body>
</html>

