package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Contato;

public class ContatoDao {
	EntityManagerFactory emf;
	EntityManager em;	
	
	
	public ContatoDao() {
		emf = Persistence.createEntityManagerFactory("banco");
		em = emf.createEntityManager();
	}
	
	public Contato obterPorId(Long id) {
		em.getTransaction().begin();
		Contato contato = em.find(Contato.class,id);
		em.getTransaction().commit();
		emf.close();
		return contato;
	}
	
	public void salvar(Contato cont) {
		em.getTransaction().begin();
		em.merge(cont);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Contato cont){
		em.getTransaction().begin();
		Object c=em.merge(cont);
		em.remove(c);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contato> getLista() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select contato from Contato contato");
		List<Contato> contatos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return contatos;
	}
 }
