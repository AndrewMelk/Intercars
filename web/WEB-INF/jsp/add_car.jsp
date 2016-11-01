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
        <form:form method="post" action="/insert" modelAttribute="car" enctype="multipart/form-data">
            <table>
                <tr>
                <td>
                <tr>
                    <td>Title :</td>
                    <td><form:label id="user" path="username" required="required">Andrew</form:label></td>
                </tr>
                <tr>
                    <td>Title :</td>
                    <td><form:input id="title" path="title" required="required"></form:input></td>
                </tr>

                <tr>
                    <td>Vehicle Type :</td>
                    <td><form:select path="vehicleType">
                        <form:options items="${vehicleType}" />
                    </form:select></td>
                </tr>
                <tr>
                    <td>Body Type :</td>
                    <td><form:select path="bodyType">
                        <form:options items="${bodyType}" />
                    </form:select></td>
                </tr>

                <tr>
                    <td>Region :</td>
                    <td><select id="region">
                        <option selected value="All">Mark</option>
                        <c:forEach var="regionList" items="${regionList}">
                            <option value="${regionList.id}">${regionList.name}</option>
                        </c:forEach>
                            <%--<option disabled>----------</option>--%>
                            <%--<c:forEach var="carMarksTop" items="${carMarksList}">--%>
                            <%--<option value="${carMarksTop.carMark}">${carMarksTop.carMark}</option>--%>
                            <%--</c:forEach>--%>
                    </select></td>
                </tr>

                <tr>
                    <td>City :</td>
                    <td><form:select id="city" path="city">
                        <option selected value="NULL">City</option>
                    </form:select></td>
                </tr>

                <tr>
                    <td>Mark :</td>
                    <td><div class="select">
                        <form:select id="first-choice" path="mark">
                            <option selected value="All">Mark</option>
                            <c:forEach var="carMarksTop" items="${carMarksList}">
                                <option value="${carMarksTop.carMark}">${carMarksTop.carMark}</option>
                            </c:forEach>
                            <%--<option disabled>----------</option>--%>
                            <%--<c:forEach var="carMarksTop" items="${carMarksList}">--%>
                            <%--<option value="${carMarksTop.carMark}">${carMarksTop.carMark}</option>--%>
                            <%--</c:forEach>--%>
                        </form:select>




                        </td>
                </tr>
                <tr>
                    <td>Model :</td>
                    <td>
                        <form:select id="second-choice" path="model">
                            <option selected value="NULL">Model</option>
                        </form:select></td>
                </tr>
                <tr>
                    <td>Car price ($) :</td>
                    <td><form:input path="carPrice" required="required"/></td>
                </tr>
                <tr>
                    <td>Mileage :</td>
                    <td><form:input path="mileage" required="required"/></td>
                </tr>
                <tr>
                    <td>Car year :</td>
                    <td><form:select path="carYear">
                        <form:options items="${carYears}" />
                    </form:select></td>
                </tr>
                <tr>
                    <td>Gear type :</td>
                    <td><form:select path="transmissionType">
                        <form:options items="${transmissionTypes}" />
                    </form:select></td>
                </tr>
                <tr>
                    <td>Type of drive :</td>
                    <td><form:select path="typeOfDrive">
                        <form:options items="${typeOfDrive}" />
                    </form:select></td>
                </tr>
                <tr>
                    <td>Engine Value :</td>
                    <td><form:input path="engineValue"/></td>
                </tr>
                <tr>
                    <td>Consumption :</td>
                    <td><form:input path="consumption"/></td>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit" value="Save" /></td>
                </tr>
                <tr>

                    <td colspan="2"><a href="getList">Click Here to See User List</a></td>
                </tr>
                </td>
                <td>
                    <%--<form method="POST" action="uploadMultipleFile" enctype="multipart/form-data">--%>
                        File1 to upload: <input type="file" name="file">

                        Name1: <input type="text" name="name">


                        File2 to upload: <input type="file" name="file">

                        Name2: <input type="text" name="name">


                        <input type="submit" value="Upload"> Press here to upload the file!

                </td>
                </tr>

            </table>
        </form:form>
    </div>
</center>
</body>
</html>

