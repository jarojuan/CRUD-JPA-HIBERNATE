package com.jaro.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.jaro.dao.ClienteDAO;
import com.jaro.model.Cliente;

//El ManagedBean recibira todas las peticiones desde el navegador (vista)
//RequestScoped indica que el bean tendrá un ambito de peticion

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private Cliente cliente = new Cliente();
	private Date fechaActual= new Date();
	
	public List<Cliente> obtenerClientes(){
		return clienteDAO.mostrarClientes();
	}
	
	public String nuevo() {
		//La coleccion Map será una sesión que estará abierta durante toda la ejecucion de la aplicacion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//Se pasa el objeto cliente con el nombre "cliente" (así lo recibirá la vista nuevoCliente)
		sessionMap.put("cliente", cliente);
		return "/faces/nuevoCliente.xhtml";
	}
	
	public String guardar(Cliente cliente) {
		//Guarda la fecha de registro
		cliente.setFechaRegistro(new java.sql.Date(fechaActual.getTime()));
		//Llama al metodo CRUD guardar
		clienteDAO.guardar(cliente);
		return "/faces/index.xhtml";
	}
	
	public String editar(Long id) {
		cliente = clienteDAO.buscarCliente(id);
		System.out.println(cliente);
		//La coleccion Map será una sesión que estará abierta durante toda la ejecucion de la aplicacion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//Se pasa el objeto cliente con el nombre "cliente" (así lo recibirá la vista editar)
		sessionMap.put("cliente", cliente);
		//En JSF (Con los xhtml) se redirecciona de forma más sencilla que en JSP
		//Se pone /faces ya que en el web.xml, está indicado que se llamará asi a todas las páginas
		return "/faces/editar.xhtml";
	}
	
	public String actualizar(Cliente cliente) {
		//Guarda la fecha de actualizacion
		cliente.setFechaActualización(new java.sql.Date(fechaActual.getTime()));
		//Se llama al metodo CRUD editar
		clienteDAO.editar(cliente);
		return "/faces/index.xhtml";
	}
	
	public String eliminar(Long id) {
		clienteDAO.eliminar(id);
		System.out.println("Cliente eliminado");
		return "/faces/index.xhtml";
	}
	
}
