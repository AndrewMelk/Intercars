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
    <%--<script src="/resources/js/cookie_search.js"></script>--%>
    <script src="/resources/js/select_mark.js"></script>
    <script src="/resources/js/jquery.cookie.js"></script>
    <%--<script src="/resources/js/car_list_new.js"></script>--%>
    <script src="/resources/js/jquery.leanModal.min.js"></script>


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
            $(".slide.left.default").click(function(){
                $("#default_div").toggle(1000);
            });
        });
    </script>



    <title>InterCars</title>
</head>

<body>



<%--<%@ include file="../jspf/header.jspf"%>--%>



<%--<%@ include file="../jspf/sidebar.jspf"%>--%>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Start Bootstrap</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container" id="cars-container">

    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Page Heading


    <!-- /.row -->
<%--modal--%>
    <!-- Trigger/Open The Modal -->
    <button id="myBtn">Open Modal</button>

    <!-- The Modal -->
    <div style="overflow:scroll; height:400px;" id="myModal" class="modal">

        <!-- Modal content -->
        <div class="modal-content">
            <div class="modal-header">
                <span class="close">×</span>
                <h2>Modal Header</h2>
            </div>
            <div class="modal-body">

                <%@ include file="../jspf/search_row.jspf"%>

            </div>
            <div class="modal-footer">
                <h3>Modal Footer</h3>
            </div>
        </div>

    </div>

    <script>
        // Get the modal
        var modal = document.getElementById('myModal');

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal
        btn.onclick = function() {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
    <%--modal--%>
            </h1>
        </div>
    </div>
    <!-- Projects Row -->
    <div class="row" id="items">
        <c:forEach var="car" items="${carList}">
            <div class="col-md-4 portfolio-item">
                <a href="">
                    <img class="img-responsive" src="${car.generalImage}" alt="">
                </a>
                <h3>
                    <a href="#"> ${car.mark}  ${car.model}</a>
                </h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
            </div>
        </c:forEach>
        <%--<div class="col-md-4 portfolio-item">--%>
        <%--<a href="#">--%>
        <%--<img class="img-responsive" src="http://placehold.it/700x400" alt="">--%>
        <%--</a>--%>
        <%--<h3>--%>
        <%--<a href="#">Project Name</a>--%>
        <%--</h3>--%>
        <%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>--%>
        <%--</div>--%>
        <%--<div class="col-md-4 portfolio-item">--%>
        <%--<a href="#">--%>
        <%--<img class="img-responsive" src="http://placehold.it/700x400" alt="">--%>
        <%--</a>--%>
        <%--<h3>--%>
        <%--<a href="#">Project Name</a>--%>
        <%--</h3>--%>
        <%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<!-- /.row -->--%>
    </div>
    <!-- /.container -->
    <!-- jQuery -->
    <<!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap/bootstrap.min.js"></script>

    <div class="text-center footer">

    </div>

    <a href="/add_car">add carzzzz</a>

</body>
</html>

