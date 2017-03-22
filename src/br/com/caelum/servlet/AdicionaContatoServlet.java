package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import model.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/*	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataInformada = request.getParameter("dataNascimento");
		java.util.Date d1 = null;

		// fazendo a conversão da data
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// Para converter de String para Date:
			d1 = sdf.parse(dataInformada);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return; // para a execução do método
		}

		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(d2);

		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.salvar(contato);

		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>"); */
		
	/*	PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Service");
		out.println("</body>");
		out.println("</html>");

	} */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

			PrintWriter out = response.getWriter();

			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String email = request.getParameter("email");
			String dataInformada = request.getParameter("dataNascimento");
			java.util.Date d1 = null;

			// fazendo a conversão da data
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				// Para converter de String para Date:
				d1 = sdf.parse(dataInformada);
			} catch (ParseException e) {
				out.println("Erro de conversão da data");
				return; // para a execução do método
			}

			java.sql.Date d2 = new java.sql.Date(d1.getTime());
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setEmail(email);
			contato.setDataNascimento(d2);

			// salva o contato
			ContatoDao dao = new ContatoDao();
			dao.salvar(contato);

			RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
			rd.forward(request,response);
	}

}
