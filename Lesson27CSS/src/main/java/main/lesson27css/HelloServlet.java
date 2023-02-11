package main.lesson27css;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//Создать страницу добавления студентов в базу данных.
//т.е на jsp странице должна быть форма(form) с полями для ввода и вы смогли их заполнить, нажать кнопку добавить и данные добавились в базу данных.
//Также обязательно подключить стили css к нашим всем страницам(login, students, home, add_student), добавляем гугл ширфтры и визуальности нашим формам по своему усмотрению.
//Логика будет такая с login формы мы попадаем на страницу home где можно сделать 2 сылки (посмотреть всех студентов и добавить студента, также на каждой странице должна быть сылка вернуться на страницу home).
//Также добавить нужные сервлеты, фильтры и листнеры из предыдущих домашек.
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}