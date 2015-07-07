package com.rest.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.rest.dao.ComidasDAO;

@Path("/comidas")
public class Comidas {

	@GET
	@Path("platosxcategoria/{cat}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getPlatosXCategoria( @PathParam("cat") String categoria ) throws Exception {

		System.out.println("getPlatosXCategoria: " + "param: " + categoria);
		
		String returnString = null;
		Response rb = null;
		JSONArray json = new JSONArray();

		try {

			ComidasDAO dao = new ComidasDAO();

			json = dao.listaComidasPorCategoria(categoria);
			returnString = json.toString();
			System.out.println("returnString: " + returnString);

			rb = Response.ok(returnString).build();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rb;
	}
	
}
