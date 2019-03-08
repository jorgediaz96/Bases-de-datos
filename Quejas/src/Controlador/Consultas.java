/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.AdmiDAO;
import Controlador.DAO.UsuarioDAO;
import Modelo.Encargado;
import Modelo.Usuario;

/**
 *
 * @author jorge diaz
 */
public class Consultas {
    public Usuario consultarUsuario(int id, int contra){
        UsuarioDAO con = new UsuarioDAO();
        return con.consultar(id, contra);
    }
    
    public Encargado consultarAdmi(int id, int contra){
        AdmiDAO ad = new AdmiDAO();
        return ad.consultar(id, contra);
    }
    
}
