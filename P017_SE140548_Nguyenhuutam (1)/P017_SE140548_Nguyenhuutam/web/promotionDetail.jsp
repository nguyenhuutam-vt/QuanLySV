<%-- 
    Document   : promotionDetail
    Created on : Jun 6, 2021, 9:11:25 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Promotion Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
      
        <style>
            #btnSave{
                width: 70px;
                height: 50px;
                position: absolute;
                left: 50%;
                margin-left: -50px;   
                display: inline;
            }
            a{
                text-decoration: none;
                color: white;
            }
            a:hover{
                color: black;
            }
        </style>
    </head>
    <body>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Promotion ID</th>
                    <th>User</th>
                    <th>Rank</th>
                    <th>Date In</th>
                    <th>Delete User</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="proDetail" items="${sessionScope.listDetail}">
                <form action="deletePromotion">
                    <tr>
                        <td>         
                            <c:set var="ProID" value="${proDetail.proID}"></c:set>
                            ${proDetail.proID}
                            <input type="hidden" name="txtProID" value="${proDetail.proID}" />
                        </td>
                        <td>
                            ${proDetail.user.userName}
                            <input type="hidden" name="txtUserID" value="${proDetail.user.userID}" />
                        </td>
                        <td>
                            ${proDetail.user.rank}                       
                        </td>
                        <td>
                            ${proDetail.dateJoin}
                            <input type="hidden" name="txtDate" value="${proDetail.dateJoin}" />
                        </td>
                        <td>
                            <button type="submit" class="btn btn-danger">delete</button>
                        </td>
                    </tr>                   
                </form>
            </c:forEach>             
        </tbody>
    </table>

    <div id="btnSave">
        <button type="button" class="btn btn-primary" >
            <a href="navigation?btAction=Promotion">Back</a>
        </button>
        <button type="button" class="btn btn-primary" >
            <a href="saveChange?txtProID=${ProID}">Save</a>
        </button>
    </div>

    
</body>
</html>
