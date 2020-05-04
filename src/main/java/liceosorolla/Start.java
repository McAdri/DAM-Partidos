package main.java.liceosorolla;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion=1;
		String equipo;
		do
		{
			opcion = menu();
			switch (opcion) {
			case 1: 
				generarPartido();
				
			break;
			case 2:
				modificarPartido();
			break;
			case 3:
				borrarPartido();
			break;
			case 4:
				listarPartidos("SELECT * FROM partidos");
			break;
			case 5:
				equipo = pedirTexto("Introduce el equipo local a filtrar");
				listarPartidos("SELECT * FROM partidos where local like '" + equipo +"'");
			break;
			case 6:
				equipo = pedirTexto("Introduce el equipo visitante a filtrar");
				listarPartidos("SELECT * FROM partidos where visitante like '" + equipo +"'");
			break;
			case 7:
				int num = pedirNumero("Introduce cuantos goles minimo marco el local");
				listarPartidos("SELECT * FROM partidos where golesLocal>='" + num +"'");
			break;
			}
		}
		while(opcion!=0);
	}

	
	public static int menu() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Elige la opcion:");
		System.out.println("1. Añadir partido");
		System.out.println("2. Modificar partido");
		System.out.println("3. Borra partido");
		System.out.println("4. Listar partidos");
		System.out.println("5. listar equipo local");
		System.out.println("6. listar visitante");
		
		return teclado.nextInt();
	}
	
	public static void generarPartido() {
		String local,visitante;
		int golesLocal, golesVisitante;
		local = pedirTexto("Introduce el nombre del equipo local");
		golesLocal = pedirNumero("Introduce el numero de goles del equipo local");
		visitante = pedirTexto("Introduce el nombre del equipo visitante");
		golesVisitante = pedirNumero("Introduce el numero de goles del equipo visitante");
		
		Partido partido = new Partido(local,golesLocal,visitante,golesVisitante);
		Conexion conexion = new Conexion();
		conexion.ejecutarQuery(partido.agregarPartidoBBDD());
	}
	
	public static void modificarPartido() {
		String local,visitante;
		int golesLocal, golesVisitante,id;
		id = pedirNumero("Introduce el numero id del partido");
		local = pedirTexto("Introduce el nombre del equipo local");
		golesLocal = pedirNumero("Introduce el numero de goles del equipo local");
		visitante = pedirTexto("Introduce el nombre del equipo visitante");
		golesVisitante = pedirNumero("Introduce el numero de goles del equipo visitante");
		
		Partido partido = new Partido(id,local,golesLocal,visitante,golesVisitante);
		Conexion conexion = new Conexion();
		conexion.ejecutarQuery(partido.modificarPartidoBBDD());
	}
	
	public static void borrarPartido() {
		int id = pedirNumero("Introduce el id del partido que quieres borrar");
		Conexion conexion = new Conexion();
		conexion.ejecutarQuery("delete from partidos where idpartidos="+id);
	}
	
	public static void listarPartidos(String query) {
		Conexion conexion = new Conexion();
		ArrayList<Partido> partidos = conexion.cargarPartidos(query);
		for(int i=0;i<partidos.size();i++) {
			System.out.println(partidos.get(i).toString());
		}
	}
	
	public static int pedirNumero(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(texto);
		return teclado.nextInt();
	}

	public static String pedirTexto(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(texto);
		return teclado.nextLine();
	}
}
