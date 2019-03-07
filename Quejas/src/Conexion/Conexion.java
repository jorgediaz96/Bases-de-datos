/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jorge diaz
 */
public class Conexion {
    static Connection conn;
        public static Connection getConexion() throws ClassNotFoundException {

            String driver = "org.postgresql.Driver"; 
            String connectString = "jdbc:postgresql://localhost:5432/QuejasYReclamos"; 
            String user = "postgres";
            String password = "1030jorge670566"; 

            try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(connectString, user, password);
              
                    return conn;
                    }
                    //Si se produce una Excepcion y no nos podemos conectar, muestra el sgte. mensaje.
            catch(SQLException e) {
                    System.out.println("Se ha producido un error en la conexion a la base de datos Ejemplo! ");
                    return null;
                }

    
            }
    public static void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexion");
        }
    }
}
