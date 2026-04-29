package com.azienda.esempioWeb.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login") // è un url relativo rispetto alla mia webapp, assoluto sarebbe
						// localhost:8080/Esempio/login
public class LoginServlet extends HttpServlet {
	// intercepts get requests
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			// controllare prima sulla stringa e poi sulla variabile è un trucco per evitare
			// nullpointer in caso in cui la variabile username sia null
			if ("admin".equals(username) && "admin".equals(password)) {
				// System.out.println("admin login");
				req.getRequestDispatcher("HTML/loginOk.html").forward(req, resp);
			} else {
				req.getRequestDispatcher("HTML/loginKo.html").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.getRequestDispatcher("HTML/error.html").forward(req, resp);
		}
	}

	// intercepts post requests
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// reindirizzo le post sulla get (solo a scopo d'esempio)
			doGet(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
