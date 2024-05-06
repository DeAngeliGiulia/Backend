package com.example.backend4f;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "errore", value = "/errore")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init(){
    }


    @Override
    public void destroy() {
    }


    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getHeader("User-Agent"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("gino") && password.equals("pasquale")){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h1>Ciao</h1></body></html>");

        } else {
           HttpSession session = request.getSession(true);
           String message = "Login sbagliato";

           session.setAttribute("error", message);
           response.sendRedirect("/errore");
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {



    }

}