package com.jaro.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.jaro.dao.ClienteDAO;
import com.jaro.model.Cliente;

//El ManagedBean recibira todas las peticiones desde el navegador (vista)
//RequestScoped indica que el bean tendrá un ambito de peticion

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	ClienteDAO clienteDAO = new ClienteDAO();
	Cliente cliente = new Cliente();
	
	public List<Cliente> obtenerClientes(){
		return clienteDAO.mostrarClientes();
	}
	
	public void editar(Long id) {
		cliente = clienteDAO.buscarCliente(id);
		System.out.println(cliente);
	}
	
}
