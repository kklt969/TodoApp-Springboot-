<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Make sure to use a font that supports emojis */
        body {
            font-family: system-ui, sans-serif, "Segoe UI Emoji", "Noto Color Emoji", "Apple Color Emoji";
        }
        /* If you want only the table cells to show emojis with proper font */
        td {
            font-family: system-ui, sans-serif, "Segoe UI Emoji", "Noto Color Emoji", "Apple Color Emoji";
        }
    </style>
    <title>Todo List</title>
</head>

<body>

<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
    <a class="navbar-brand m-1" >Todo App by Ko Ko</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="/list-todo">Todos</a></li>
        </ul>
    </div>
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
    </ul>
</nav>


<!-- Search and Filter Form -->
<div class = "container">
    <form  method = "get" class = "d-flex mb-3">

        <input type="text" name = "keyword" class = "form-control me-2" placeholder = "Search todos..." value = "${param.keyword}">

        <select name = "status" class = "form-select me-2">

            <option value="">All</option>
            <option value = "completed"  <c:if test = "${param.status == 'completed'}">selected</c:if>>Completed</option>
            <option value  = "pending" <c:if test="${param.status == 'pending'}">selected</c:if>>Pending</option>

        </select>


        <button type = "submit" class="btn btn-primary">Search & Filter</button>
 </form>

</div>

<table class = "table">

    <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done</th>

        </tr>

    </thead>

    <tbody>
        <c:forEach items = "${todos}" var = "todo">  <!-- use JSTL , todos is a collection(list), var todo is a variable, foreach loops each todos and assign it to todo -->
        <tr>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>

                <c:choose>

                    <c:when test = "${todo.done}">
                        ✅ <a href="toggle-done?id=${todo.id}" class="btn btn-sm btn-outline-success">Mark as Undone</a>
                    </c:when>

                    <c:otherwise>

                        ❌ <a href= "toggle-done?id=${todo.id}" class = "btn btn-sm btn-outline-secondary">Mark as Done</a>

                    </c:otherwise>



                </c:choose>




            </td>
            <td><a href="update-todo?id=${todo.id}" class = "btn btn-warning">Update Todo</a></td>
            <td><a href ="delete-todo?id=${todo.id}" class = "btn btn-warning">Delete Todo</a></td>
        </tr>

        </c:forEach>


    </tbody>



</table>

<a href="add-todo" class = "btn btn-success">Add a Todo</a>



</body>



<script src = "webjars/bootstrap/5.1.3/js/bootstrap.min.js" ></script>
<script src = "webjars/jquery/3.6.0/jquery.min.js"></script>
</html>