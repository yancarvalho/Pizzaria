package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TipoProduto;

public class TesteDB {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PIZZARIA");
		EntityManager em = emf.createEntityManager();

		TipoProduto tp = new TipoProduto();
		tp.setId(2);
		tp.setDescricao("Descrição lala");

		em.getTransaction().begin();
		em.persist(tp);
		em.getTransaction().commit();
		em.close();

		emf.close();
	}

}
