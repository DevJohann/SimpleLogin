/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.edu.unbosque.model;
import co.edu.unbosque.model.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConnectionDTO {

    public ConnectionDTO() {
          
    }
    
    public boolean checkUserPsswd(String username, String psswd){
        Conection objectConnection = new Conection();
        try{
            Connection c = objectConnection.connectToDB();
            Statement stm = c.createStatement(); //No porque tiene valores dinámicos
            ResultSet rs = stm.executeQuery("SELECT * FROM people");
            while(rs.next()){
                if(rs.getString("first_name").equals(username)&& rs.getString("psswd").equals(psswd)){
                    return true;
                }
            }
      
            /* //Para valores dinámicos (No trae un Result Set)
            String query = "SELECT * FROM people WHERE first_name = ?";
            CallableStatement CS = objectConnection.connectToDB().prepareCall(query);
            CS.setString(1, username);
            CS.execute();
            */
        }catch(SQLException e){
            System.out.println("Error al conectar a la base de datos");
        }
        return false;
    }
    
    public void addUser(String lastName, String firstName, String password){
        
        Conection objectConnection = new Conection();
        try{
            //Connection c = objectConnection.connectToDB();
            String query = "INSERT INTO people (last_name, first_name, psswd) VALUES (?, ?, ?)";
            CallableStatement cs = objectConnection.connectToDB().prepareCall(query);
            cs.setString(1, lastName);
            cs.setString(2, firstName);
            cs.setString(3, password);
            cs.execute();
            JOptionPane.showMessageDialog(null, "Registrado exitosamente");
        }catch(SQLException ex){
            System.out.println("Error al conectarse a la base de datos");
        }
    }
}
