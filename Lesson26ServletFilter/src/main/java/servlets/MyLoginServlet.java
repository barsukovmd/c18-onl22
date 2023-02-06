package servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;

@WebServlet(name = "MyLoginServlet", value = "/login")
public class MyLoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        session.setAttribute("password", password);
        String path = request.getContextPath() + "/home";
        response.sendRedirect(path);
        System.out.println(login + " " + password);
        response.setContentType("text/html");
        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            response.getWriter().write("Success Log!!");
        } else {
            response.getWriter().println("Password is not correct");
        }
    }
}