package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import model.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Long id = Long.parseLong(req.getParameter("id"));

		Contato contato = new ContatoDao().obterPorId(id);
		req.setAttribute("contato", contato);

		return "/WEB-INF/jsp/edita-contato.jsp";

	}

}
