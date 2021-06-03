package ufps.edu.co.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import ufps.edu.co.model.TipoDocumento;

public class TipoDocumentoDao {
	@PersistenceUnit(name = "SistemaVotacion")
	
	
	public void insertarTipoDocuemto(TipoDocumento t){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		emf.close();
	}
	
	public void eliminarTipoDocumento(Integer id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(TipoDocumento.class, id));
		manager.getTransaction().commit();
		emf.close();
	}
	
	public TipoDocumento buscarTipoDocumento(Integer id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		TipoDocumento t = manager.find(TipoDocumento.class, id);
		manager.getTransaction().commit();
		emf.close();
		return t;
	}
	
	public List<TipoDocumento> buscarTodosTipoDocumento(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		List<TipoDocumento> t;
		manager.getTransaction().begin();
		t = manager.createQuery("from tipodocumento", TipoDocumento.class).getResultList();
		manager.getTransaction().commit();
		emf.close();
		return t;
	}
	
	public void actualizarTipoDocumento(TipoDocumento t){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
		emf.close();
	}
}
