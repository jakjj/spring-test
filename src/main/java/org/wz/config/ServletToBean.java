package org.wz.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletToBean extends HttpServlet {

    String targetBean;

    Servlet proxy;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proxy.service(req, resp);
    }

    @Override
    public void init() throws ServletException {
        targetBean = this.getInitParameter("name");
        getServletProxy();
        proxy.init(getServletConfig());
    }

    private void getServletProxy(){
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        proxy = (Servlet)webApplicationContext.getBean(targetBean);
    }
}
