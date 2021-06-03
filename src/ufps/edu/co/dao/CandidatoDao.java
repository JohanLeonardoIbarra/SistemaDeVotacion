package ufps.edu.co.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import ufps.edu.co.model.Candidato;

public class CandidatoDao {
	@PersistenceUnit(name = "SistemaVotacion")
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVotacion");
	EntityManager manager = emf.createEntityManager();
	
	public void close(){
		emf.close();
	}
	
	public void insertarCandidato(Candidato t){
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}
	
	public void eliminarCandidato(Integer id){
		manager.getTransaction().begin();
		manager.remove(manager.find(Candidato.class, id));
		manager.getTransaction().commit();
	}
	
	public Candidato buscarCandidato(Integer id){
		manager.getTransaction().begin();
		Candidato t = manager.find(Candidato.class, id);
		manager.getTransaction().commit();
		return t;
	}
	
	public List<Candidato> buscarCandidatos(){
		List<Candidato> t;
		manager.getTransaction().begin();
		t = manager.createQuery("from candidato", Candidato.class).getResultList();
		manager.getTransaction().commit();
		return t;
	}
	
	public void actualizarCandidato(Candidato t){
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Candidato> buscarCandidatosPorEleccion(Integer id){
		List<Candidato> candidatos;
		manager.getTransaction().begin();
		candidatos = manager.createNativeQuery("Select * from candidato where eleccion = ?",Candidato.class).setParameter(1, id).getResultList();
		manager.getTransaction().commit();
		return candidatos;
	}
}
