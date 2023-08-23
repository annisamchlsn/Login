<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.User"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login Process</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Contoh data pengguna statis (harus diganti dengan logika otentikasi yang sesuai)
        User user = new User("username", "password");
        
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
            // Otentikasi berhasil, simpan pengguna dalam sesi
            session.setAttribute("loggedInUser", user);
            response.sendRedirect("users");
        } else {
            out.println("Gagal masuk. Silakan coba lagi.");
        }
    %>
</body>
</html>
