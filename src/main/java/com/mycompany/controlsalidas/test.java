/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlsalidas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {
    public static void main(String[] args) {
        // Crear un nuevo usuario
        Defensor usuario = new Defensor("Juan Perez");
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        System.out.println("conectado: "+session.isConnected());
        
        try {
            //Guardar
            session.save(usuario);

            // Leer un usuario
            Defensor usuarioLeido = session.get(Defensor.class, usuario.getId());
            System.out.println("Nombre: " + usuarioLeido.getNombre());

            
            // Eliminar un usuario
            //session.delete(usuarioLeido);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sf.close();
        }

         
    }
}

