<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 04.10.16
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(
                function () {
                    $.getJSON('usedByMarkModel', {
                        mark : 'Audi',
                        model : '100',
                        ajax : 'true'

                    },function (data) {

                        var html = '';
                        var len = data.length;

                        for ( var i = 0; i < len; i++){
                            html += '<h1>' + 'mark' + data[i].mark + '</h1>';


                        }

                        $('#test').html(html)

                    })

                }
        )
    </script>
</head>
<body>
    <div id="test"></div>
</body>
</html>
