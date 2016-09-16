<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 05.09.16
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    ${carModelsList}
<c:forEach var="model" items="${carModelsList}">
    ${model.modelName}
</c:forEach>
</head>
<body>

</body>
</html>
