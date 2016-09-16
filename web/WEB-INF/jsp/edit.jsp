<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
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
            text-align: center;
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
    <br /> <br /> <br /> <b>Edit Car Details </b><br /> <br />
    <div>
        <form:form method="post" action="/update" modelAttribute="car">
            <table>
                <tr>
                    <td>Mark :</td>
                    <td><form:input path="mark"
                                    value="${map.car.mark}" />
                    </td>
                </tr>
                <tr>
                    <td>Model :</td>
                    <td><form:input path="model" value="${map.car.model}" />
                    </td>
                </tr>
                <tr>
                    <td>Engine Value :</td>
                    <td><form:input path="engineValue" value="${map.car.engineValue}" />
                    </td>
                </tr>
                <tr>
                    <td>Consumption :</td>
                    <td><form:input path="consumption" value="${map.car.consumption}" />
                    </td>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
            <form:hidden path="id" value="${map.car.id}" />

        </form:form>
    </div>
</center>
</body>
</html>