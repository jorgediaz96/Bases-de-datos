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
public class UsuarioDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public UsuarioDAO(){
        con = null;
        st = null;
        rs=null;
    }
    
    public void insertarUsuario(int id,String nombre,String correo, int celular,String direccion,int cedula,int contraseña) throws ClassNotFoundException, SQLException {
        
        try{
            String script ="INSERT INTO public.\"Usuario\"(\n" +
"	id_usuario, nombre_user, correo, telefono, direccion, cedula, \"contraseña\")\n" +
"	VALUES ("+id+", '"+nombre+"', '"+correo+"', "+celular+", '"+direccion+"', "+cedula+", "+contraseña+")";
            con = Conexion.getConexion();
            st = con.createStatement();    
            st.executeUpdate(script);
            st.close();
            Conexion.cerrarConexion();
           
           
        }catch(Exception e){
            System.out.println("no se pudo realizar la insercion");
        }
        
    }
    public Usuario consultar(int id,int contra){
        Usuario user = null;
        String script = "SELECT * FROM public.\"Usuario\"\n" +
"WHERE id_usuario = "+id+" and contraseña ="+contra;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(script);
            if(rs.next()){
                user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre_usuario(rs.getString("nombre_user"));
                user.setCedula(rs.getInt("cedula"));
                user.setContraseña(rs.getInt("contraseña"));
                user.setCorreo(rs.getString("correo"));
                user.setTelefono(rs.getInt("telefono"));

            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return user;
    }
    
    

   
}
