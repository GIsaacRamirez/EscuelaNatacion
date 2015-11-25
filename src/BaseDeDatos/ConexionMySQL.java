/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ConexionMySQL {
 
    public static Connection Conexion;
    String user="root";
    //String pass="Rigo1994";
    String pass="";
    public void MySQLConnection() {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost/escuelanatacion", user, pass);
            //System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void closeConnection() 
    {
        try {
            Conexion.close();
            //System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}