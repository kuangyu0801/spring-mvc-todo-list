<%--
  Created by IntelliJ IDEA.
  User: Kuang-Yu
  Date: 2021/7/31
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%-- using jstl tag --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.demo.util.Mappings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Items</title>
</head>
<body>
    <div align="center">
        <%-- model attribute should match --%>
        <table>
            <tr>
                <td><label>ID</label></td>
                <%-- don't let user specify the id, TodoData will auto generate it--%>
                <td>
                    <c:out value="${todoItem.id}"/>
                </td>
            </tr>
            <tr>
                <td><label>Title</label></td>
                <td>
                    <c:out value="${todoItem.title}"/>
                </td>
            </tr>
            <tr>
                <td><label>Deadline</label></td>
                <td>
                    <c:out value="${todoItem.deadline}"/>
                </td>
            </tr>
            <tr>
                <td><label>Details</label></td>
                <td>
                    <c:out value="${todoItem.details}"/>
                </td>
            </tr>
        </table>
        <c:url var="itemslink" value="${Mappings.ITEMS}"></c:url>
        <a href="${itemslink}">Show Todo Items</a>
    </div>
</body>
</html>