package com.jaro.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	//Nombre con el que se llama a persistence.xml
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory==null) {
			//Conecta con la bd usando los datos del persistence.xml
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;				
	}
	
	//Desconectar de la bd
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
		}		
	}
	
}
