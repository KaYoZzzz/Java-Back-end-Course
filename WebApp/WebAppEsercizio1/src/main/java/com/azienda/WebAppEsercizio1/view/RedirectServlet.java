package com.azienda.WebAppEsercizio1.view;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String latitudine = "43535455";
			String longitudine = "32424663";
			resp.sendRedirect(
					req.getContextPath() + "/acquisisci?latitudine=" + latitudine + "&longitudine=" + longitudine);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.getRequestDispatcher("HTTP/errore.html").forward(req, resp);
		}
	}
}
