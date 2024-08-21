/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlsalidas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.xml.sax.SAXParseException;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        try {
            File props = new File("C://salidas-hibernate/hibernate.cfg.xml");
            if (!props.exists()){
                try {
                    props.createNewFile();
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (Throwable ex) {
            // Manejar la excepción inicial
            System.err.println("La creación de la SessionFactory falló." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
    
    public static String generateConfigContent(String url, String username, String password) {
        return "<?xml version='1.0' encoding='utf-8'?>\n" +
                "<!DOCTYPE hibernate-configuration PUBLIC\n" +
                "        \"-//Hibernate/Hibernate Configuration DTD 3.0//EN\"\n" +
                "        \"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd\">\n" +
                "<hibernate-configuration>\n" +
                "    <session-factory>\n" +
                "        <property name=\"hibernate.connection.driver_class\">com.mysql.jdbc.Driver</property>\n" +
                "        <property name=\"hibernate.connection.url\">" + url + "</property>\n" +
                "        <property name=\"hibernate.connection.username\">" + username + "</property>\n" +
                "        <property name=\"hibernate.connection.password\">" + password + "</property>\n" +
                "        <property name=\"hibernate.dialect\">org.hibernate.dialect.MySQLDialect</property>\n" +
                "        <property name=\"hibernate.hbm2ddl.auto\">update</property>\n" +
                "        <property name=\"hibernate.format_sql\">true</property>" +
                "        <mapping class=\"com.mycompany.controlsalidas.Salida\"/>\n" +
                "        <mapping class=\"com.mycompany.controlsalidas.Defensor\"/>\n" +
                "        <mapping class=\"com.mycompany.controlsalidas.Pass\"/>" +
                "    </session-factory>\n" +
                "</hibernate-configuration>";
    }
    
    public static void writeFile(String path, String content) throws IOException {
        try (FileWriter writer = new FileWriter(new File(path))) {
            writer.write(content);
        }
    }
    
    public static void newConnection(){
        File props = new File("C://salidas-hibernate/hibernate.cfg.xml");
        sessionFactory = new Configuration().configure(props).buildSessionFactory();
    }
    
}

