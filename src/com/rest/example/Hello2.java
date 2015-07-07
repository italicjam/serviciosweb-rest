package com.rest.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import com.rest.dao.CiudadDAO;

@Path("/hello2")
public class Hello2 {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sayPlainTextHello(String inputJsonObj) throws Exception {
		System.out.println("input: " + inputJsonObj);

		JSONObject obj = new JSONObject(inputJsonObj);

		System.out.println("nombre: " + obj.getString("nombre"));
		System.out.println("altitud: " + obj.getString("altitud"));
		String input = (String) inputJsonObj;
		String output = "The input you sent is :" + input;
		output = "true";
		JSONObject outputJsonObj = new JSONObject();
		outputJsonObj.put("output", output);

		CiudadDAO dao = new CiudadDAO();
		dao.insertarCiudad(obj.getString("nombre"), Integer.parseInt(obj.getString("altitud")));
		
		String returnString = outputJsonObj.toString();
		return Response.ok(returnString).build();
	}
}