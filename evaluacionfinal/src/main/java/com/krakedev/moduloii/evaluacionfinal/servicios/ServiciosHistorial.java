package com.krakedev.moduloii.evaluacionfinal.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.persistencias.HistorialBDD;

@Path("funciones")
public class ServiciosHistorial {
	@Path("probarInsertarGrupo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarGrupo(Grupo grupo) {
		HistorialBDD hi = new HistorialBDD();
		try {
			hi.insertarGrupo(grupo);
			return Response.ok().build();
		}catch (InventarioException e){
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path ("insertarRegistroMovimientoEntrada")	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response insertarregistroMovimientoEntrada (RegistroMovimiento registroMovimiento) {
		System.out.println(">>>>>>" + registroMovimiento);
		HistorialBDD hi = new HistorialBDD();
		try {
			hi.insertarMovimientodeEntrada(registroMovimiento);
			return Response.ok().build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path ("insertarRegistroMovimientoSalida")	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response insertarRegistroMovimientoSalida (RegistroMovimiento registroMovimiento) {
		System.out.println(">>>>>>" + registroMovimiento);
		HistorialBDD hi = new HistorialBDD();
		try {
			hi.insertarMovimientodeSalida(registroMovimiento);
			return Response.ok().build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
