package com.azienda.WebAppEsercizio1.view;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/acquisisci")
public class AcquisisciServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String latitudine = req.getParameter("latitudine");
			String longitudine = req.getParameter("longitudine");

			if (latitudine == null || longitudine == null) {
				throw new Exception();
			}
			System.out.println(latitudine);
			System.out.println(longitudine);

			req.getRequestDispatcher("HTML/risposta.html").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.getRequestDispatcher("HTML/errore.html").forward(req, resp);

		}
	}
}
