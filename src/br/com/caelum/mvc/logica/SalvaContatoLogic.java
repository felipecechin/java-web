package br.com.caelum.mvc.logica;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import model.Contato;

public class SalvaContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PrintWriter out = res.getWriter();

		Long id = null;
		// valida se é nulo
		if (req.getParameter("id") != null) {
			id = Long.parseLong(req.getParameter("id"));
		}
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataInformada = req.getParameter("dataNascimento");
		java.util.Date d1 = null;

		// fazendo a conversão da data
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// Para converter de String para Date:
			d1 = sdf.parse(dataInformada);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return null; // para a execução do método
		}

		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		Contato contato = new Contato();
		if (id != null) {
			contato.setId(id);
		}
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(d2);

		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.salvar(contato);

		return "/WEB-INF/jsp/contato-salvo.jsp";
	}
	

}
