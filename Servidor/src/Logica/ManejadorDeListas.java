/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Tickets;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public abstract class ManejadorDeListas {


    public static ArrayList<Tickets> ListaDePendientes = new ArrayList();
    
    
    
    
    public static ArrayList<Tickets> getListaDePendientes() {
        return ListaDePendientes;
    }

    public static void setListaDePendientes(ArrayList<Tickets> ListaDePendientes) {
        ManejadorDeListas.ListaDePendientes = ListaDePendientes;
    }
}
