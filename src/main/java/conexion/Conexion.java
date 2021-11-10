/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Conexion {
    //Conexion con sql server

    public static Connection getConexion() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=MiniMarket;"
                + "IntegratedSecurity=true";
        
        try{
            Connection con = DriverManager.getConnection(connectionUrl);
            System.out.println("Conexion exitosa");
            return con;
        }catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
    }

}
