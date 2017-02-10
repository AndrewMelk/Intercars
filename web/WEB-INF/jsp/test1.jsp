<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 01.02.17
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script src="/resources/js/jquery.cookie.js"></script>
    <script src="/resources/js/cookie_search.js"></script>
    <%--<script type="application/javascript">--%>
        <%--var saveclass = null;--%>

        <%--function saveTheme(cookieValue)--%>
        <%--{--%>
            <%--var sel = document.getElementById('ThemeSelect');--%>

            <%--saveclass = saveclass ? saveclass : document.body.className;--%>
            <%--document.body.className = saveclass + ' ' + sel.value;--%>

            <%--setCookie('theme', cookieValue, 365);--%>
        <%--}--%>

        <%--function setCookie(cookieName, cookieValue, nDays) {--%>
            <%--var today = new Date();--%>
            <%--var expire = new Date();--%>

            <%--if (nDays==null || nDays==0)--%>
                <%--nDays=1;--%>

            <%--expire.setTime(today.getTime() + 3600000*24*nDays);--%>
            <%--document.cookie = cookieName+"="+escape(cookieValue) + ";expires="+expire.toGMTString();--%>
        <%--}--%>
    <%--</script>--%>

</head>
<body>
<div>
<ul class="links">
<li>
    <select id="first-choice" >
        <option selected value="All">Mark</option>

        <option value="val1">1</option>
        <option value="val2">2</option>
        <option value="val3">3</option>
        <option value="val4">4</option>


    </select>

</li>
<li>
    <select id="second-choice" >
        <option selected value="1">1</option>
    </select>
</li>
    </ul>
</div>
</body>
</html>
