package com.jaro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.jaro.model.Cliente;

//El ManagedBean recibira todas las peticiones desde el navegador (vista)
//RequestScoped indica que el bean tendrá un ambito de peticion

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	public List<Cliente> obtenerClientes(){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		//Clientes de prueba
		Cliente c1 = new Cliente();
		c1.setId(1L);
		c1.setNombres("Pedro");
		c1.setApellidos("Fernandez");
		c1.setDireccion("Calle de Prueba");
		
		Cliente c2 = new Cliente();
		c2.setId(1L);
		c2.setNombres("Pedro");
		c2.setApellidos("Fernandez");
		c2.setDireccion("Calle de Prueba");
		
		listaClientes.add(c1);
		listaClientes.add(c2);
		
		return listaClientes;
	}
	
}
