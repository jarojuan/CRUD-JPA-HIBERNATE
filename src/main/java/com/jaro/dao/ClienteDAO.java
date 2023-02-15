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
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar nuevo cliente
	private void guardar(Cliente cliente) {
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
	
	//Obtener un solo cliente
	public Cliente buscarCliente(Long id) {
		Cliente cliente = new Cliente();
		//El método find encuentra un registro de la bd que coincida con el parametro pasado
		cliente = entity.find(Cliente.class, id);
		//JPAUtil.shutdown();
		return cliente;
	}
	
	//Obtener todos los clientes
	public List<Cliente> mostrarClientes(){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		//JQL (Es como el SQL que usa Hibernate)
		//La query se hace contra el Modelo (Entity Cliente.java)
		//Query query = entity.createQuery("SELECT * FROM Cliente c");
		Query query = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = query.getResultList();
		return listaClientes;
	}
	
}
