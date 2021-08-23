<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
       
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="login-form">
            <form action="login" method="post">
              
                <h2 class="text-center">Member Login</h2>   
                <div class="form-group">
                    <input type="text" class="form-control" name="txtUserName" placeholder="Username" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="txtPassword" placeholder="Password" required="required">
                </div>        
                <div class="form-group">
                    <input type="submit" value="Sign in" class="btn btn-primary btn-lg btn-block" name="btAction"/>
                </div>
            </form>
        </div>
        <script>
            <c:if test="${requestScope.LoginFailed != null}">
                swal("ERROR!", "Account is not found!", "warning");
            </c:if>
        </script>
    </body>
</html>

<