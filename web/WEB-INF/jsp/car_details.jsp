<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <spring:url value="/resources/css/car_details/bootstrap.min.css" var="bootCSS" ></spring:url>
    <spring:url value="/resources/css/car_details/car_detalis.css" var="templatmo"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${bootCSS}"/>
    <link rel="stylesheet" href="${templatmo}"/>
    <!--
    Puzzle Template
    http://www.templatemo.com/tm-477-puzzle
    -->
    <title>InterCars</title>
</head>

<body>
<%@ include file="../jspf/header.jspf"%>


<div class="container">
    <section class="col-md-12 content" id="home">
        <%--<c:forEach var="car" items="${carList}">--%>
            <div class="col-lg-6 col-md-6 content-item">
                <img src="resources/images/1.jpg" alt="Image" class="tm-image">
            </div>

            <div class="col-lg-6 col-md-6 content-item content-item-1 background">

                <h2 class="main-title text-center dark-blue-text">${map.car.mark} ${map.car.model}</h2>
                <p>${map.car.engineValue}</p>
                <p>${map.car.consumption}</p>
                <button type="button" class="btn btn-big dark-blue-bordered-btn"><a href="edit?id=${car.id}">Edit</a></button>
                <button type="button" class="btn btn-big dark-blue-btn"><a href="delete?id=${car.id}">Delete</a></button>
            </div>
        <%--</c:forEach>--%>
    </section>



    <footer class="col-md-12 content" id="externals">
        <div class="col-lg-6 col-md-6 last">
            <img src="images/5.png" alt="Image" class="tm-image">
        </div>
        <div class="col-lg-6 col-md-6 background last about-text-container">
            <h2 class="section-title">About This Website</h2>
            <p class="about-text">Puzzle Template is brought to you by templatemo. Sed imperdiet quis ipsum a vulputate. Suspendisse sit amet nibh mi. In quis sapien a metus interdum hendrerit.</p>
        </div>
    </footer>

</div>

<div class="text-center footer">
    <div class="container">
        Copyright @ 2084 Company Name

        | Design: <a href="http://www.templatemo.com/tm-477-puzzle" target="_parent" title="Puzzle Template">Puzzle</a>
    </div>
</div>

<a href="/add_car">add car</a>

</body>
</html>

