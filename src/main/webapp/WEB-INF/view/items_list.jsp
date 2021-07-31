<%--
  Created by IntelliJ IDEA.
  User: Kuang-Yu
  Date: 2021/7/31
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%-- using jstl tag --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.demo.util.Mappings" %>

<html>
<head>
    <title>Todo Items</title>
</head>
<body>
    <div align="center">
    <c:url var="addUrl" value="${Mappings.ADD_ITEM}"></c:url>
        <a href="${addUrl}">New Item</a>
        <table border="1" cellpadding="5">
            <caption><h2>Todo Items</h2></caption>
            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="item" items="${todoData.items}">
                <c:url var="editUrl" value="${Mappings.ADD_ITEM}">
                    <c:param name="id" value="${item.id}"></c:param>
                </c:url>
                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
                    <%-- setting parameter for delete item --%>
                    <c:param name="id" value="${item.id}"></c:param>
                </c:url>

                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${editUrl}">Edit</a></td>
                    <%-- add delete buttom that redirect to Delete page --%>
                    <td><a href="${deleteUrl}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
