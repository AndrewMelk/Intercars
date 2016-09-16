<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Being Java Guys | Spring DI Hello World</title>
    <style>
        body {
            font-size: 20px;
            color: teal;
            font-family: Calibri;
        }

        td {
            font-size: 15px;
            color: black;
            width: 100px;
            height: 22px;
            text-align: left;
        }

        .heading {
            font-size: 18px;
            color: white;
            font: bold;
            background-color: orange;
            border: thick;
        }
    </style>
</head>
<body>
<center>
    <br /> <br /> <br /> <b>Being Java Guys | Registration Form </b> <br />
    <br />
    <div>
        <form:form method="post" action="/loginUser" modelAttribute="user">
            <table>
                <tr>
                    <td>Vehicle Type :</td>
                    <form:input path="userEmail" required="required"/>
                </tr>
                <tr>
                    <td>Body Type :</td>
                    <form:password path="userPass" required="required"/>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>

                <tr>

                    <td colspan="2"><a href="getList">Click Here to See User List</a></td>
                </tr>
            </table>
        </form:form>
    </div>
</center>
</body>
</html>

