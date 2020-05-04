package main.java.liceosorolla;

public class Partido {

	private int id;
	private String local;
	private int golesLocal;
	private String visitante;
	private int golesVisitante;
	
	public Partido(String local,int golesLocal,String visitante,int golesVisitante) {

		this.local = local;
		this.golesLocal = golesLocal;
		this.visitante = visitante;
		this.golesVisitante = golesVisitante;
	}
	
	public Partido(int id,String local,int golesLocal,String visitante,int golesVisitante) {
		this.id = id;
		this.local = local;
		this.golesLocal = golesLocal;
		this.visitante = visitante;
		this.golesVisitante = golesVisitante;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public String getVisitante() {
		return visitante;
	}
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
	public int getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	
	public String agregarPartidoBBDD() {
		return "insert into partidos (local,golesLocal,visitante,golesVisitante) values('" 
				+ this.local + "'," + this.golesLocal + ",'" + this.visitante + "'," 
				+ this.golesVisitante + ")";
	}
	
	public String modificarPartidoBBDD() {
		return "update partidos set local='" + this.local + "', golesLocal=" + this.golesLocal 
				+ ", visitante='" + this.visitante + "', golesVisitante=" + this.golesVisitante
				+ " where idpartidos=" + this.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this.id == ((Partido) o).id) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "El partido " + this.id + " " + this.local + " " + this.golesLocal + "-" 
				+ this.golesVisitante + " " + this.visitante;
	}
}
