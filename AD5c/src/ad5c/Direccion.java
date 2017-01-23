package ad5c;

public class Direccion {
	String calle;
	String poblacion;
	int CP;
	int id;
	Empresa empresa;
	public Direccion(String calle,String poblacion,int CP){
		this.calle=calle;
		this.poblacion=poblacion;
		this.CP=CP;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCP() {
		return CP;
	}
	public void setCP(int cP) {
		CP = cP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
