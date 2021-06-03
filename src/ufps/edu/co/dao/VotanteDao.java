package ufps.edu.co.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import ufps.edu.co.model.Votante;

public class VotanteDao {
	@PersistenceUnit(name = "SistemaVotacion")
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
	EntityManager manager = emf.createEntityManager();
	
	public void close(){
		emf.close();
	}
	
	public void insertarVotante(Votante t){
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}
	
	public void eliminarVotante(Integer id){
		manager.getTransaction().begin();
		manager.remove(manager.find(Votante.class, id));
		manager.getTransaction().commit();
	}
	
	public Votante buscarVotante(Integer id){
		manager.getTransaction().begin();
		Votante t = manager.find(Votante.class, id);
		manager.getTransaction().commit();
		return t;
	}
	
	public List<Votante> buscarVotante(){
		List<Votante> t;
		manager.getTransaction().begin();
		t = manager.createQuery("from votante", Votante.class).getResultList();
		manager.getTransaction().commit();
		return t;
	}
	
	public void actualizarVotante(Votante t){
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
	}
}
