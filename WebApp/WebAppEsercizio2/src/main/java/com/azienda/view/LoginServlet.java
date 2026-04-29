package com.azienda.view;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String usr = req.getParameter("username");
			String pwd = req.getParameter("password");
			if ("Pippo".equalsIgnoreCase(usr) && "Pluto".equals(pwd)) {
				req.getSession().setAttribute("loggato", "SI");
				req.getRequestDispatcher("html/privata/homePrivata.html").forward(req, resp);
			} else {
				req.getRequestDispatcher("html/pubblica/loginErrato.html").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
