package com.azienda.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if ("admin".equals(username) && "admin".equals(password)) {
				req.setAttribute("chiaveUsername", username);
				req.getRequestDispatcher("jsp/privata.jsp").forward(req, resp);
			} else {
				req.setAttribute("CHIAVE_CREDENZIALI_ERRATE", "Username o password errate");
				req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			req.setAttribute("CHIAVE_ERRORE", "Errore imprevisto!");
			req.getRequestDispatcher("jsp/errore.jsp").forward(req, resp);
		}
	}
}
