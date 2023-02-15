package com.jaro.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jaro.model.Cliente;
import com.jaro.model.JPAUtil;


//El DAO contiene los métodos CRUD

public class ClienteDAO {
	
	//El objeto EntityManager permite crear los CRUD mediante Hibernate
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Cliente c = new Cliente();
	
	//Guardar nuevo cliente
	public void guardar(Cliente cliente) {
		//Inicia la transaccion
		entity.getTransaction().begin();
		//Persiste el objeto en la bd (Mapea los datos hacia sus campos correspondientes segun las anotaciones de Cliente.java)
		entity.persist(cliente);
		//Guarda los datos en la bd y cierra la transaccion
		entity.getTransaction().commit();
		//Cierra la conexio con la bd
		JPAUtil.shutdown();
	}
	
	//Editar clientes
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		//Edita el cliente que coincida con el id del cliente pasado
		entity.merge(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	//Eliminar un cliente
	public void eliminar(Long id) {
		//El método find encuentra un registro de la bd que coincida con el parametro pasado
		c = entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		//El método remove elimina de la bd el objeto pasado
		entity.remove(c);
		entity.getTransaction().commit();
	}
	
	//Obtener un solo cliente
	public Cliente buscarCliente(Long id) {
		//El método find encuentra un registro de la bd que coincida con el parametro pasado
		c = entity.find(Cliente.class, id);
		//JPAUtil.shutdown();
		return c;
	}
	
	//Obtener todos los clientes
	public List<Cliente> mostrarClientes(){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		//JQL (Es como el SQL que usa Hibernate)
		//La query se hace contra el Modelo (Entity Cliente.java)
		//Query query = entity.createQuery("SELECT cli FROM Cliente cli");
		Query query = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = query.getResultList();
		return listaClientes;
	}
	
}
