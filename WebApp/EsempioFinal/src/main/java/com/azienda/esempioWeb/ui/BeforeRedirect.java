package com.azienda.esempioWeb.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/before")
@SuppressWarnings("serial")
public class BeforeRedirect extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// due req diverse che non hanno memoria dei dati
			String nome = req.getParameter("nome");
			System.out.println(nome);
			resp.sendRedirect(req.getContextPath() + "/after?nome=mario");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.getRequestDispatcher("HTTP/errore.html").forward(req, resp);
		}
	}
}
