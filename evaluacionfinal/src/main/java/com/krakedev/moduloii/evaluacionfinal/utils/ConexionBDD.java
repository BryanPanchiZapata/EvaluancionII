package com.krakedev.moduloii.evaluacionfinal.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;


public class ConexionBDD {
	public static Connection obtenerConexion() throws InventarioException{
		Context ctx = null;
		DataSource ds = null;
		Connection con = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConBDD");
			con = ds.getConnection();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			throw new InventarioException("Error de conexion");

		} 
		
		return con;
	}
}
