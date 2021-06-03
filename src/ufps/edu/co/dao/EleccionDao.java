package ufps.edu.co.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import ufps.edu.co.model.Eleccion;

public class EleccionDao {
	@PersistenceUnit(name = "SistemaVotacion")
	
	public void insertarEleccion(Eleccion e){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(e);
		manager.getTransaction().commit();
		emf.close();
	}
	
	public Eleccion buscarEleccion(Integer id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Eleccion e = manager.find(Eleccion.class, id);
		manager.getTransaction().commit();
		emf.close();
		return e;
	}
	
	public List<Eleccion> buscarTodasLasElecciones(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		List <Eleccion> lista;
		manager.getTransaction().begin();
		lista = manager.createQuery("from eleccion", Eleccion.class).getResultList(); 
		manager.getTransaction().commit();
		emf.close();
		return lista;
	}
	
	public void eliminarEleccion(Integer id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Eleccion.class, id));
		manager.getTransaction().commit();;
		emf.close();
	}
	
	public void actualizarEleccion(Eleccion e){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(e);
		manager.getTransaction().commit();
		emf.close();
	}
}
