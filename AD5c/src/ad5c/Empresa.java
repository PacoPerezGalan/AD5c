package ad5c;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	String cif;
	String nombre;
	int empleados;
	List<Pedido> pedidos;
	Direccion direccion;
	
	public Empresa(){
		direccion=new Direccion("Hernandez","Albal",45433);
		//setDireccion(new Direccion("Hernandez Lazaro","Albal",46470));
		this.direccion.setEmpresa(this);
		this.pedidos=new ArrayList<Pedido>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public int getEmpleados() {
		return empleados;
	}
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedido(Pedido p){
		p.setEmpresa(this);
		pedidos.add(p);
	}
	
	
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
		this.direccion.setEmpresa(this);
	}
	
	
}
