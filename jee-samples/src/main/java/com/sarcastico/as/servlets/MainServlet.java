package com.sarcastico.as.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sarcastico.as.impl.Service;

/**
 * <p>
 * A simple servlet taking advantage of features added in 3.0.
 * </p>
 *
 * <p>
 * The servlet is registered and mapped to /servlet using the {@linkplain WebServlet
 * @HttpServlet}. The {@link DefaultService} is injected by CDI.
 * </p>
 *
 * @author Pete Muir
 *
 */

@WebServlet("/servlet")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";

    static String PAGE_FOOTER = "</body></html>";

    @Inject
    Service svc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(PAGE_HEADER);
        writer.println("<h1>" + svc.createMessage(this.getClass().getSimpleName() + " invoked") + "</h1>");
        writer.println(PAGE_FOOTER);
        writer.close();
    }

}
