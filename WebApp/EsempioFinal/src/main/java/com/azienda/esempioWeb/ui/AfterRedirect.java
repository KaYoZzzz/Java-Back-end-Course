package com.azienda.esempioWeb.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/after")
public class AfterRedirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String nome = req.getParameter("nome");
			System.out.println(nome);
			req.getRequestDispatcher("HTML/rispostaRedirect.html").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			req.getRequestDispatcher("HTML/errore.html").forward(req, resp);
		}
	}
}
