package org.celebration.demo;

import java.io.*;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.celebration.demo.entity.User;
import org.celebration.demo.service.user.UserServiceLocal;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        List<User> users = userServiceLocal.findAll();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<ul>");
        users.forEach(user->{
            out.println("<li>"+user.getName()+"</li>");
        });
        out.println("</ul>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}