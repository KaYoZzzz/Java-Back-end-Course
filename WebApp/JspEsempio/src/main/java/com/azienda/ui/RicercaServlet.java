package com.azienda.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.azienda.model.Prodotto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ricerca")
public class RicercaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String nome = req.getParameter("nomeProdotto");
			String prezzo = req.getParameter("prezzo");
			try {
				Float pr = Float.parseFloat(prezzo);
				List<Prodotto> prodotti = Arrays.asList(new Prodotto("Scarpa", 55f), new Prodotto("Giacca", 76f),
						new Prodotto("Jeans", 50f));
				req.setAttribute("risultatiRicerca", prodotti);
				req.getRequestDispatcher("jsp/risultatiRicerca.jsp").forward(req, resp);
			} catch (Exception e) {
				req.setAttribute("ChiaveErrore", "inserire un numero per il prezzo");
				req.getRequestDispatcher("jsp/ricerca.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			req.setAttribute("CHIAVE_ERRORE", "Errore imprevisto!");
			req.getRequestDispatcher("jsp/errore.jsp").forward(req, resp);
		}
	}
}
