package org.wz.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.wz.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

    @Autowired
    UserService userService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter write = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        write.write("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                    "<title>testServletProxy</title>\n" +
                "</head>\n" +
                "<body>\n" +
                    "<p>this is message "+userService.getUserService()+"</p>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
