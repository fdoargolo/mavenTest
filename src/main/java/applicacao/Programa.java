package applicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;


public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "Carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "genio da Silva", "genio@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();	
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
			
		System.out.println("Added!");
		
		Pessoa p = em.find(Pessoa.class, 1);
		System.out.println(p);
		p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();	
		em.remove(p);
		em.getTransaction().commit();

		System.out.println("Deleted!");
		
		em.close();
		emf.close();
	}

}
