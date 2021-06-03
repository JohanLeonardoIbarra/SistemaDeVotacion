package ufps.edu.co.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import ufps.edu.co.model.Estamento;

public class EstamentoDao {
	@PersistenceUnit(name = "SistemaVotacion")
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
	EntityManager manager = emf.createEntityManager();
	
	public void close(){
		emf.close();
	}
	
	public void insertarEstamento(Estamento t){
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}
	
	public void eliminarEstamento(Integer id){
		manager.getTransaction().begin();
		manager.remove(manager.find(Estamento.class, id));
		manager.getTransaction().commit();
	}
	
	public Estamento buscarEstamento(Integer id){
		manager.getTransaction().begin();
		Estamento t = manager.find(Estamento.class, id);
		manager.getTransaction().commit();
		return t;
	}
	
	public List<Estamento> buscarTodosEstamento(){
		List<Estamento> t;
		manager.getTransaction().begin();
		t = manager.createQuery("from estamento", Estamento.class).getResultList();
		manager.getTransaction().commit();
		return t;
	}
	
	public void actualizarEstamento(Estamento t){
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
	}
}
