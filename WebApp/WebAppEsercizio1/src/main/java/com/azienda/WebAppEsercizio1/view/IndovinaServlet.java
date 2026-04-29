package com.azienda.WebAppEsercizio1.view;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/indovina")
public class IndovinaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String parametro = req.getParameter("numeroIn");

			if (parametro != null) {
				int numeroIn = Integer.parseInt(parametro);
				int numeroVincente = new Random().nextInt(10);

				System.out.println("Numero vincente: " + numeroVincente);
				if (numeroIn == numeroVincente) {
					req.getRequestDispatcher("/HTML/vittoria.html").forward(req, resp); // 3. Forward
				} else {
					req.getRequestDispatcher("/HTML/sconfitta.html").forward(req, resp); // 3. Forward
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
