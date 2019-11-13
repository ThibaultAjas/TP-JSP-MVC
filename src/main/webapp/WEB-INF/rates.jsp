<%-- 
    Document   : rates
    Created on : 5 nov. 2019, 13:24:17
    Author     : Dalfrak
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Saisie d'un taux de remise</title>
        <link href="css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <h1>Edition des taux de remise</h1>
        <form action="MyServiette" name="addRate" method='post'>
            <table>
                <tr><td>Code : </td><td><input name="code" size="1" maxlength="1" pattern="[A-Z]{1}+" title="Une lettre en MAJUSCULES" /></td></tr>
                <tr><td>Taux : </td><td><input name="taux" type="number" step="0.01" min="0.0" max="99.99" size="5" /></td></tr>
            </table>
            <input type="submit" name="action" value="ADD" />
        </form>

        <h4></h4>

        <table id="table">
            <tr id="thead">
                <td>Code</td>
                <td>Taux</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${rates}" var="rate">
                <tr>
                    <form name="form${rate.code}" action="MyServiette" method="post">
                        <td><input type="text" name="code" value="${rate.code}" readonly /></td>
                        <td><input name="taux" type="number" step="0.01" min="0.0" max="99.99" size="5" value="${rate.rate}" /></td>
                        <td><input type="submit" name="action" value="DELETE" /><input type="submit" name="action" value="UPDATE" /></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </body>        
</html>