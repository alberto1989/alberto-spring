/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberto.spring;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alberto
 */

public class DAOMensaje {
    public  SessionFactory sessionFactory;
    public  Session session;
    public  Transaction transaction;
    public DAOMensaje(){
     sessionFactory=HibernateUtilidades.getSessionFactory();
     session=sessionFactory.openSession();
     transaction=session.beginTransaction();
    }
    private void cerrarTodo(){
        transaction.commit();
        session.close();
    }
    /*
  1.   GUARDAR
    */
    public void guardar(Mensaje reservacion)throws Exception{
        session.save(reservacion);
        cerrarTodo();
    }
/*
    2. BUSCAR TODOS
    */
    ArrayList<Mensaje> buscarTodos() throws Exception{
  ArrayList<Mensaje> mensaje=  (ArrayList<Mensaje>) session.createCriteria(Mensaje.class).list();
  cerrarTodo();
  
    return mensaje;
    }
    /*
   3.  BUSCAR POR ID
    */
    public Mensaje buscarPorId(Integer id) throws Exception{
 
      Mensaje m=(Mensaje) session.createCriteria(Mensaje.class).add(Restrictions.idEq(id)).uniqueResult();
  cerrarTodo();
  
       ///  c=(Cliente) session.createCriteria(Cliente.class).add(Restrictions.idEq(c.getIdCliente())).uniqueResult();
         
    return m;
    }
    /*
    4. ACTUALIZAR
    */
    public void actualizar(Mensaje c)throws Exception{
        

       
         session.update(c);
         cerrarTodo();
        
    }
    /*
    5. BORRAR
    */
     public void   borrar(Integer id)throws Exception{
        
       Mensaje m=new Mensaje();
        m.setId(id); 
         session.delete(m);
         cerrarTodo();
         
    }
    
    
    
}   