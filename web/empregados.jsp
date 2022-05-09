<%-- 
    Document   : clientes
    Created on : 9 de mai. de 2022, 16:29:03
    Author     : Fatec
--%>

<%@page import="model.Customers"%>
<%@page import="model.Employees"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Exception requestEx = null;
    ArrayList<Employees> list = new ArrayList<>();
    try {
        list = Employees.getList();
    } catch(Exception e) {
        requestEx = e;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(requestEx!=null){%>
            <h3 style="color: red"><%=requestEx.getMessage()%></h3>
        <%}%>
        <table border="1">
            <%for(Employees a:list){%>
                <tr>
                    <td><%= a.getId()%></td>
                    <td><%= a.getFirstName()%></td>
                    <td><%= a.getLastName()%></td>
                </tr>
            <%}%>
        </table>
    </body>
</html>
