<%--
  Created by IntelliJ IDEA.
  User: bibek
  Date: 4/28/21
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.sql.*,com.example.LoginAndLogout.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
</head>
<body>
<div class="box">
    <h1 style="text-align:center; color:#8B008B;">User Logged In</h1>
    <div class="sub">
        <%
            String id=null;
            String username=null;


            Cookie[] cookies=request.getCookies();
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("id")){
                    id=cookie.getValue();
                }
            }
            if(id!=null){
                Statement st=JConnect.getStatement();
                ResultSet rs=st.executeQuery("select * from user where username='"+id+"'");
                if(rs.next()){
                    username=rs.getString("username");

                }
            }else{
                response.sendRedirect("login.jsp");
            }
        %>
        <h5><%=username%></h5>
        <a href="logout">LOGOUT</a>
    </div>
</div>
</body>
</html>