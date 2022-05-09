<%-- 
    Document   : index
    Created on : 9 de mai. de 2022, 14:43:10
    Author     : Fatec
--%>

<%@page import="model.Employees"%>
<%@page import="model.Customers"%>
<%@page import="model.Artist"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Exception requestEx = null;
    int count = 0;
    int count1 = 0;
    try {
        count = Customers.getCount();
        count1 = Employees.getCount();
    } catch(Exception e) {
        requestEx = e;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - JDBC | Customers & Employees</title>
    </head>
    <body>
        <h1>JDBC</h1>
        <h2><a href="clientes.jsp">Lista de clientes (<%=count %> registros)</a></h2>
        <h2><a href="./empregados.jsp">Lista de empregados (<%=count1 %> registros)</a></h2>
        
    </body>
</html>