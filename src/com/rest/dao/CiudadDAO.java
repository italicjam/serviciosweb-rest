package com.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;

import com.rest.beans.Ciudad;
import com.rest.util.Conexion;
import com.rest.util.ToJSON;

public class CiudadDAO {

	public JSONArray  listaCiudades() {
		
		Conexion conexion=new Conexion();
		Connection con=conexion.getConnection();
		Statement st = null;
		ResultSet rs = null;
		ToJSON converter = new ToJSON();
		JSONArray json = new JSONArray();
		//List<Ciudad> listaCiudad = new ArrayList<Ciudad>();
		
		String sql = "select id, nombre, altitud, estado from ciudad where estado = 'A'";
		
		try {
			st = con.createStatement();
			
			rs = st.executeQuery(sql);
			
			json = converter.toJSONArray(rs);
			st.close(); //close connection
		
		} catch ( Exception ex ) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
			return json;
		}
		
		return json;
	}
	
	public List<Ciudad> listaCiudadDestino(String idCiudadOrigen) {
		
		System.out.println("listaCiudadDestino");
		
		Conexion conexion=new Conexion();
		Connection con=conexion.getConnection();
		Statement st = null;
		ResultSet rs = null;
		List<Ciudad> listaCiudad = new ArrayList<Ciudad>();
		
		String sql = "select od.idciudadorigen, od.idciudaddestino," +
				" c.nombre, d.nombre, od.duracionhoras from origenxdestino od " +
				" inner join ciudad c " +
				" on od.idciudadorigen = c.id " +
				" inner join ciudad d " +
				" on od.idciudaddestino = d.id " +
				" where idciudadorigen = " + idCiudadOrigen;
		
		try {
			st = con.createStatement();
			
			rs = st.executeQuery(sql);
			
			while ( rs.next() ) {
				//Capturamos los valores de la BD
				String id = rs.getString(2);
				String nombre = rs.getString(4);
				
				//Instanciando el objeto
				Ciudad obj = new Ciudad();
				obj.setId(id);
				obj.setNombre(nombre);
				
				//Agregamos a la lista
				listaCiudad.add(obj);
				
			}
		
		} catch ( Exception ex ) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		return listaCiudad;
		
	}
	
	public boolean insertarCiudad(String  nombre, int altitud) {
		
		System.out.println("insertarCiudad");
		
		Conexion conexion=new Conexion();
		Connection con=conexion.getConnection();
		Statement st = null;
		boolean retorno = true;
		
		String sql = "insert into ciudad (nombre, altitud, estado) values ('" + nombre + "', " + altitud + ", 'A');";
		
		try {
			st = con.createStatement();
			
			retorno = st.execute(sql);
			
			System.out.println("retorno: " + retorno);
			
		} catch ( Exception ex ) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
			retorno = false;
		}
		
		return retorno;
	}
	
}
