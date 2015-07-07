package com.rest.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.rest.dao.CiudadDAO;


@Path("/hello")
public class Hello {

	
	@GET
	@Path("/{param}")
	@Produces(MediaType.TEXT_HTML)
	public Response getMsg(@PathParam("param") String msg ) {
		System.out.println("Primer servicio rest");
		String output = "<h2>Primer servicio rest : " + msg + "</h2>";
		return Response.status(200).entity(output).build();
	}
	
	
	@GET
	@Path("prueba/{param1}")
	@Produces(MediaType.TEXT_XML)
	public Response prueba(@PathParam("param1") String msg ) {
		System.out.println("metodo prueba");
		System.out.println("msg: " + msg);
		String output = "<prueba> : " + msg + "</prueba>";
		return Response.status(200).entity(output).build();
	}
	
	
	
	@GET
	@Path("ciudades/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCiudades() throws Exception {

		String returnString = null;
		Response rb = null;
		JSONArray json = new JSONArray();

		try {

			CiudadDAO dao = new CiudadDAO();

			json = dao.listaCiudades();
			returnString = json.toString();

			rb = Response.ok(returnString).build();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rb;
	}


	
	
	
}