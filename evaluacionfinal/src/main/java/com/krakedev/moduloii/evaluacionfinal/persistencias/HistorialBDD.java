package com.krakedev.moduloii.evaluacionfinal.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class HistorialBDD {
	public void insertarGrupo(Grupo grupo) throws InventarioException{
		Connection con=null;
		try {
			con=ConexionBDD.obtenerConexion();
			PreparedStatement ps=con.prepareStatement("insert into grupos(id,nombre) values(?,?)");
			ps.setString(1, grupo.getIdGrupo());
			ps.setString(2, grupo.getNombre());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InventarioException("Error al insertar el grupo. Detalle: "+e.getMessage());
		} catch (InventarioException e) {
			throw e;
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertarMovimientodeEntrada (RegistroMovimiento registroMovimiento) throws InventarioException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into registro_movimientos (id_articulo, cantidad, fecha_movimiento ) values (?, ?, ?)");
			ps.setString(1, registroMovimiento.getIdArticulo());
			if (registroMovimiento.getCantidad() >0 ) {
				ps.setInt(2, registroMovimiento.getCantidad());
			}
			ps.setDate(3, new java.sql.Date(registroMovimiento.getFechaMovimiento().getTime()));
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new InventarioException("Error al insertar el movimiento. Detalle" + e.getMessage());
		} catch (InventarioException e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new InventarioException("Error con la base de datos");
				}

			}
		}
	}
	public void insertarMovimientodeSalida (RegistroMovimiento registroMovimiento) throws InventarioException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into registro_movimientos (id_articulo, cantidad, fecha_movimiento ) values (?, ?, ?)");
			ps.setString(1, registroMovimiento.getIdArticulo());
			if (registroMovimiento.getCantidad() < 0 ) {
				ps.setInt(2, registroMovimiento.getCantidad());
				
			}
			ps.setDate(3, new java.sql.Date(registroMovimiento.getFechaMovimiento().getTime()));
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new InventarioException("Error al insertar el movimiento. Detalle" + e.getMessage());
		} catch (InventarioException e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new InventarioException("Error con la base de datos");
				}

			}
		}
	}
}
