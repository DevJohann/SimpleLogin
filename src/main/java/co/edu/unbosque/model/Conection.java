/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unbosque.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conection {
    
    private Connection connection = null;
    
    public Connection connectToDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdatabase", "root", "toor");
            //JOptionPane.showMessageDialog(null, "Conectado a la base de datos");
            System.out.println("Conectado a la base de datos");
            
            //Traer datos de la base de datos (Ejemplo)
            /*
            Statement Statement = connection.createStatement();
            ResultSet rs = Statement.executeQuery("SELECT * FROM myfirstdatabase.people");
            while(rs.next()){
                String name = rs.getString("first_name");
                System.out.println(name);
            }
            */
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "No se logró hacer la conexión a la base de datos");
            System.out.println("Error conectando a la base de datos");
            e.printStackTrace();
        }
        return connection;
    }
}
