/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Conexion.Conexion;
import Modelo.Encargado;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.DropMode.INSERT;
/**
 *
 * @author jorge diaz
 */
public class AdmiDAO {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public AdmiDAO(){
        con = null;
        st = null;
        rs=null;
    }
    
    public Encargado consultar(int id,int contra){
        Encargado admi = null;
        String script = "SELECT * FROM public.\"Encargado\"\n" +
       "WHERE id_encargado="+id+" and contra="+contra;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(script);
            //obtener 
            if(rs.next()){
                admi = new Encargado();
                admi.setId_encargado(rs.getInt("id_encargado"));
                admi.setArea(rs.getString("area"));
                admi.setCargo(rs.getString("cargo"));
                admi.setCedula(rs.getInt("cedula"));
                admi.setContraseña(rs.getInt("contra"));
                admi.setNombre(rs.getString("nombre"));
             
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return admi;
    }
}
