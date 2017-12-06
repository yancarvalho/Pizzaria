package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.TipoProduto;

public class TipoProdutoDAO implements ITipoProdutoDAO{
	
	private EntityManagerFactory emf;
	
	public TipoProdutoDAO() {
		emf = Persistence.createEntityManagerFactory("PIZZARIA");
	}

	@Override
	public void adicionar(TipoProduto tp) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(tp);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<TipoProduto> pesquisar() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<TipoProduto> qry = em.createQuery("SELECT * FROM TIPOPRODUTO", TipoProduto.class);
		List<TipoProduto> lista = qry.getResultList();
		em.close();		
		return lista;
	}

}
