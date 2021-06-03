package ufps.edu.co.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import ufps.edu.co.model.Voto;

public class VotoDao {
	@PersistenceUnit(name = "SistemaVotacion")
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
	EntityManager manager = emf.createEntityManager();
	
	public void close(){
		emf.close();
	}
	
	public void insertarVoto(Voto t){
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}
	
	public void eliminarVoto(Integer id){
		manager.getTransaction().begin();
		manager.remove(manager.find(Voto.class, id));
		manager.getTransaction().commit();
	}
	
	public Voto buscarVoto(Integer id){
		manager.getTransaction().begin();
		Voto t = manager.find(Voto.class, id);
		manager.getTransaction().commit();
		return t;
	}
	
	public List<Voto> buscarVoto(){
		List<Voto> t;
		manager.getTransaction().begin();
		t = manager.createQuery("from voto", Voto.class).getResultList();
		manager.getTransaction().commit();
		return t;
	}
	
	public void actualizarVoto(Voto t){
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
	}
}
