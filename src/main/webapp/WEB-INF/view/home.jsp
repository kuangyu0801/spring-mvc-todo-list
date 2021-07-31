<%--
  Created by IntelliJ IDEA.
  User: Kuang-Yu
  Date: 2021/7/31
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%-- using jstl tag --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.demo.util.Mappings" %>
<html>
<head>
    <title>Todo List Application</title>
</head>
<body>
    <div align="center">
        <c:url var="itemslink" value="${Mappings.ITEMS}"></c:url>
        <h2><a href="${itemslink}">Show Todo Items</a></h2>
    </div>
</body>
</html>
