package com.example.LoginAndLogout.controller;

import com.example.LoginAndLogout.model.User;
import com.example.LoginAndLogout.util.JConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        User user = new User();

        Statement st = JConnect.getStatement();
        try {
            ResultSet rs = st.executeQuery("select * from user where username='" + username + "'");
            if (rs.next()) {
                user.setUsername(rs.getString("username"));

                Cookie loginCookie = new Cookie("id", user.getUsername());
                loginCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);
                response.sendRedirect("profile.jsp");

            } else {
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("msg", "Email doesn't exists create an account");
//                rd.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}