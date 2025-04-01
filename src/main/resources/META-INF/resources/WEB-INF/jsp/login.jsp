<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href = "webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel = "stylesheet"></link>
    <style>
        body {
            background-color: #f7f7f7;
        }
        .login-container {
            max-width: 400px;
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #ddd;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            margin-bottom: 30px;
        }
        .form-group label {
            font-weight: bold;
        }
        .error-message {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form action="/login" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username" value="${username}" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        
        <c:if test="${not empty error}">
            <div class="error-message">
                <p>${error}</p>
            </div>
        </c:if>

        <button type="submit" class="btn btn-primary btn-block">Login</button>
    </form>
</div>

<script src = "webjars/bootstrap/5.1.3/js/bootstrap.min.js" ></script>
<script src = "webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>