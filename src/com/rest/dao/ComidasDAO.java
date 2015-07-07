package com.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.codehaus.jettison.json.JSONArray;

import com.rest.util.Conexion;
import com.rest.util.ToJSON;

public class ComidasDAO {

	public JSONArray  listaComidasPorCategoria(String idCategoria) {
		
		Conexion conexion=new Conexion();
		Connection con=conexion.getConnection();
		Statement st = null;
		ResultSet rs = null;
		ToJSON converter = new ToJSON();
		JSONArray json = new JSONArray();
		
		String sql = "select id, nombre, descripcion, precio, imagen from producto where id_categoria_comida = " + idCategoria;
		
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
	
}
