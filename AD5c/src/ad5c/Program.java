package ad5c;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
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
		
		Empresa em=session.get(Empresa.class, "12345678");
		
		System.out.println("Hem recuperat de Empresa: "+em.getNombre());//+" "+em.getCif()+" "+em.getEmpleados());
		
		
		
		for(Pedido pedido : em.pedidos ){
			System.out.println("Pedido: "+pedido.getEmpresa().cif+" "+pedido.getFecha());
		}
		
		
		System.out.println("Direccion: "+em.getDireccion().getCalle()+" "+em.getDireccion().getCP()+" "+em.getDireccion().getPoblacion());
		
		session.getTransaction().commit();
		
		
		//CONSULTAS 5d
		session.beginTransaction();
		//empresa por cif dado
		Query q = session.createQuery("from Empresa where CIF='12345678'");
		
		List<Empresa> empresas = q.list();

		for (Empresa emp : empresas) {
			System.out.println(emp.getNombre());
		}
		
		//pedidos por cif de empresa
		q = session.createQuery("from Pedido where ID_EMPRESA='12345678'");
		
		List<Pedido> pedidos = q.list();

		for (Pedido ped : pedidos) {
			System.out.println("Fecha de pedido "+ped.getId()+": "+ped.getFecha());
		}
		
		//empresas que empiecen por string dado
		q = session.createQuery("from Empresa where NOMBRE LIKE 'Ap%'");
		
		empresas = q.list();

		for (Empresa emp : empresas) {
			System.out.println(emp.getNombre());
		}
		
		session.getTransaction().commit();
		
		//
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
