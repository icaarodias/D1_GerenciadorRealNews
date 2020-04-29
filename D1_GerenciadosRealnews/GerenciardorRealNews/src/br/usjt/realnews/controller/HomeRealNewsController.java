package br.usjt.realnews.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.realnews.model.Noticia;
import br.usjt.realnews.service.NoticiaService;


@WebServlet("/homeRealNews.do")
public class HomeRealNewsController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	 private final NoticiaService noticiaService = new NoticiaService();
	 //private final ComentarioService comentarioService = new ComentarioService();     
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		List<Noticia> noticias = noticiaService.listarNoticias();
		PrintWriter saida = response.getWriter();
		response.getWriter().println("<a href='listaNoticias.do'>Home Admin</a>");
		
		
		saida.println("<h1>Gerenciados Real News</h1>");
		saida.println("<h2>Noticias:</h2>");
		if (noticias.isEmpty()) {
			saida.println("<p>N�o H� Noticias</p>");
		} else {
			for (Noticia noticia : noticias) {
				saida.println("<p><b>Titulo: </b><a href='noticiaPage.do?id=" + noticia.getId() + "'>" + noticia.getTitulo() + "</a></p>");
				saida.println("<p><b>Descri��o: </b>" + noticia.getDescricao() + "</p>");
				saida.println("<p><b>Texto: </b>" + noticia.getTexto() + "</p>");
				saida.println("<hr>");
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	}
	

}
