package ad5c;


import java.sql.Date;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

public class Program {
	
	public static void main(String[] args) {
		
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		//PER A INSERTAR
		
		session.beginTransaction();
		
		Empresa e=new Empresa();
		e.setCIF("E12345678");
		e.setNombre("Apple");
		//e.setDireccion("Calle Carlos Ferris");
		e.setEmpleados(45);
		e.addPedido(new Pedido(new Date(System.currentTimeMillis() ) ) );
		e.addPedido(new Pedido(new Date(System.currentTimeMillis() ) ) );
		session.save(e);
			
		
		session.getTransaction().commit();
		//
		
		//PER A AGAFAR/CONSULTAR
		session.beginTransaction();
		
		Empresa em=session.get(Empresa.class, 1);
		System.out.println("Hem recuperat de Empresa: "+em.getNombre()+" "+em.getCif()+" "+em.getEmpleados());
		
		
		for(Pedido pedido : em.pedidos ){
			System.out.println("Pedido: "+pedido.getEmpresa()+" "+pedido.getFecha());
		}
		
		System.out.println("Direccion: "+em.getDireccion().getCalle()+" "+em.getDireccion().getCP()+" "+em.getDireccion().getPoblacion());
		
		session.getTransaction().commit();
		//
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
