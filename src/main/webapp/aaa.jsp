<%--
  Created by IntelliJ IDEA.
  User: sans
  Date: 2020/8/12
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js"></script>
</head>
<body>

<button id="button" >发送</button>

<script>
    
    $("#button").click(function () {
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/product/test",
            //contentType:"application/json;charset=utf-8",
            data:{"name":"123","price":123.1},
            success:function(data){
                alert(data);
                alert(data.name);
                alert(data.price);
            }
        })
    });
    
</script>

</body>
</html>
