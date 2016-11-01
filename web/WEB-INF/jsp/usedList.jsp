<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootCSS" ></spring:url>
    <spring:url value="/resources/css/dropdown.js" var="dropdownJS" ></spring:url>
    <spring:url value="/resources/css/templatemo-style.css" var="templatmo"/>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/select_mark.js"></script>
    <script src="/resources/js/car_list.js"></script>
    <script src="/resources/js/jquery.cookie.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${bootCSS}"/>
    <link rel="stylesheet" href="${templatmo}"/>
    <script src="<c:url value="/resources/js/dropdown.js" />"></script>
    <script type="text/javascript">

    </script>

    <script>
        $(document).ready(function(){
            $(".slide.left").click(function(){
                $("#default_div").toggle(1000);
            });
        });
    </script>


    <title>InterCars</title>
</head>

<body>
<div class="fixed-header">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">InterCars</a>
        </div>
        <nav class="main-menu">
            <ul>
                <li><a href="#home">Б/у Авто</a></li>
                <li><a href="#services">Новые Авто</a></li>
                <li><a href="#clients">Новости</a></li>
                <li><a class="external" href="https://www.facebook.com/templatemo" target="_blank">External</a></li>
                <li><a href="#contact">Контакты</a></li>
            </ul>
        </nav>
    </div>
</div>

<%--<%@ include file="../jspf/sidebar.jspf"%>--%>


<div class="container">
    <section class="col-md-12 content" id="home">
        <%--<c:forEach var="car" items="${carList}">--%>
            <%--<div class="col-lg-6 col-md-6 content-item">--%>
                <%--<img src="resources/images/1.jpg" alt="Image" class="tm-image">--%>
            <%--</div>--%>

            <%--<div class="col-lg-6 col-md-6 content-item content-item-1 background">--%>

                <%--<a href="show_details?id=${car.id}"><h2 class="main-title text-center dark-blue-text">${car.mark} ${car.model}</h2></a>--%>
                <%--<h1 id="price">$ ${car.carPrice}</h1>--%>
                <%--<p>Объем двигателя: ${car.engineValue}</p>--%>
                <%--<p>Расход Топлива: ${car.consumption}</p>--%>
                <%--<p>Пробег: ${car.mileage}</p>--%>
                <%--<p id="description">${car.description}</p>--%>

                <%--<button type="button" class="btn btn-big dark-blue-bordered-btn"><a href="edit?id=${car.id}">Edit</a></button>--%>
                <%--<button type="button" class="btn btn-big dark-blue-btn"><a href="delete?id=${car.id}">Delete</a></button>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>

        /*----------------------------------------------------------------------*/

        <div class="col-lg-6 col-md-6 content-item content-item-1 background">
            <%--<h2 class="main-title text-center dark-blue-text">${car.mark} ${car.model}</h2>--%>
        </div>

    </section>




    <%--<footer class="col-md-12 content" id="externals">--%>
        <%--<div class="col-lg-6 col-md-6 last">--%>
            <%--<img src="images/5.png" alt="Image" class="tm-image">--%>
        <%--</div>--%>
        <%--<div class="col-lg-6 col-md-6 background last about-text-container">--%>
            <%--<h2 class="section-title">About This Website</h2>--%>
            <%--<p class="about-text">Puzzle Template is brought to you by templatemo. Sed imperdiet quis ipsum a vulputate. Suspendisse sit amet nibh mi. In quis sapien a metus interdum hendrerit.</p>--%>
        <%--</div>--%>
    <%--</footer>--%>

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

