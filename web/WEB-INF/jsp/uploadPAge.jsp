<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 06.09.16
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Spring MVC file upload example</h2>

<form method="POST" action="/upload"
      enctype="multipart/form-data">


    Please select a file to upload : <input type="file" name="file" />
    <input type="submit" value="upload" />

</form>
</body>
</html>
