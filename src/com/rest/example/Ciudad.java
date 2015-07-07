package com.rest.example;

import javax.ws.rs.Path;

//import com.rest.beans.MyJaxBean;

@Path("/ciudad")
public class Ciudad {

	/*@POST @Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(final MyJaxBean input) { 
		System.out.println("createDataInJSON");
		
		System.out.println("nombre: " + input.param1);
		System.out.println("altitud: " + input.param2);
        String result = "Hola Mundo " + input.param1;

        return Response.status(201).entity(result).build(); 
    }
	*/
	
	
	/*
	public Response insertar(@PathParam("nombre") String nombre, 
			@PathParam("altitud") int altitud ) {
		System.out.println("metodo insertar ciudad");
		
		System.out.println("nombre: " + nombre);
		System.out.println("altitud: " + altitud);
		
		try {
			
			CiudadDAO dao = new CiudadDAO();
			
			dao.insertarCiudad(nombre, altitud);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return Response.status(200).entity("TRUE").build();
	}*/
	
}
