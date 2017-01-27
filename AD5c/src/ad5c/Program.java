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
		e.setCif("12345678");
		e.setNombre("Apple");
		e.setEmpleados(45);
		e.addPedido(new Pedido(new Date(System.currentTimeMillis() ) ) );
		e.addPedido(new Pedido(new Date(System.currentTimeMillis() ) ) );
		session.save(e);
			
		
		session.getTransaction().commit();
		//
		
		
		//PER A AGAFAR/CONSULTAR
		session.beginTransaction();
		
		Empresa em=session.get(Empresa.class, "123456781");
		if(em!=null)
		System.out.println("Hem recuperat de Empresa: "+em.getNombre());//+" "+em.getCif()+" "+em.getEmpleados());
		else
			System.out.println("Es null");
		
		/*
		for(Pedido pedido : em.pedidos ){
			System.out.println("Pedido: "+pedido.getEmpresa().cif+" "+pedido.getFecha());
		}
		
		
		System.out.println("Direccion: "+em.getDireccion().getCalle()+" "+em.getDireccion().getCP()+" "+em.getDireccion().getPoblacion());
		*/
		session.getTransaction().commit();
		//
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
