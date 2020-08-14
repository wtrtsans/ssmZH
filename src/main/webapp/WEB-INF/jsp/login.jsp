<%--
  Created by IntelliJ IDEA.
  User: sans
  Date: 2020/8/12
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/dologin" method="post">
        账户：<input name="name" type="text"/><br>
        密码：<input name="password" type="password"/><br>
        <button>登录</button>
    </form>
</body>
</html>
