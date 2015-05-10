package Logica.servidor;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;

/**
 * Servidor de chat.
 * Acepta conexiones de clientes, crea un hilo para atenderlos, y espera la
 * siguiente conexion.
 * @author Chuidiang
 *
 */
public class Servidor
{
	ArrayList lista = new ArrayList();
    /** Lista en la que se guaradara toda la conversacion */
    private DefaultListModel charla = new DefaultListModel();
    boolean finalizar=false;
    ServerSocket socketServidor;
    /**
     * Instancia esta clase.
     * @param args
     */
    public static void main(String[] args)
    {
        new Servidor();
    }

    /**
     * Se mete en un bucle infinito para ateder clientes, lanzando un hilo
     * para cada uno de ellos.
     */
    public Servidor(){
    	lista.add("CERO");
    	lista.add("uno");
    	lista.add("dos");
    	lista.add("tres");
    	lista.add("cuatro");
    	lista.add("CINCO");
        try
        {
            socketServidor = new ServerSocket(4546);
            while (true){
            	
                Socket cliente = socketServidor.accept();
                Runnable nuevoCliente = new HiloDeCliente(charla, cliente,lista,this);
                Thread hilo = new Thread(nuevoCliente);
                hilo.start();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void cerrarConexion(){
            try {
                socketServidor.close();
                System.out.println("Cerrando conexion . . .");
            } catch (IOException ex) {
                System.out.println("El servidor ya ha sido cerrado");
            }
    }
}
