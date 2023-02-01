package main;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// 1. Создать страницу логина с формой ввода имени пользователя и пароля.
// 2. Создать сервлет для обработки формы логина и определения пользователя
// (можно использовать предустановленные значения имени и пароля, в БД нет необходимости).
//пункты 1 и 2 уже реализованы, можно взять за основу в моем репозитории!
// 3. Создать защищенную страницу, попасть на которую можно только после логина.
// 4. Все запросы к защищенной странице должны приводить к перенаправлению на страницу логина,
// если пользователь еще не залогинен, а если залогинен – должны всегда быть успешными.
@WebServlet("/second-servlet")
public class MySecondServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Java Developer!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setAttribute("textA", "Hello");
        request.setAttribute("textB", "Yauhen");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/secondServlet.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }
}