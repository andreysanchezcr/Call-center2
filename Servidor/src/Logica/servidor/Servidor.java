package Logica.servidor;

import Logica.Persona;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;

/**
 * Servidor de chat. Acepta conexiones de clientes, crea un hilo para
 * atenderlos, y espera la siguiente conexion.
 *
 * @author Chuidiang
 *
 */
public class Servidor {

    ArrayList lista = new ArrayList();
    ArrayList listaEmpleados = new ArrayList();
    /**
     * Lista en la que se guaradara toda la conversacion
     */
    private DefaultListModel charla = new DefaultListModel();
    boolean finalizar = false;
    ServerSocket socketServidor;

    /**
     * Instancia esta clase.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Servidor();
    }

    private void registrarPersonas() {
        Persona admn = new Persona("Admin", "admin@tec.ac.cr", "12345", null, true);
        Persona rojo = new Persona("Fernando", "fernando@tec.ac.cr", "12345", null, true);
        Persona verde = new Persona("Luis", "luis@tec.ac.cr", "12345", null, true);
        Persona amarillo = new Persona("Junior", "junior@tec.ac.cr", "12345", null, true);
        listaEmpleados.add(admn);
        listaEmpleados.add((Persona) verde);
        listaEmpleados.add((Persona) rojo);
        listaEmpleados.add((Persona) amarillo);

    }

    /**
     * Se mete en un bucle infinito para ateder clientes, lanzando un hilo para
     * cada uno de ellos.
     */
    public Servidor() {
        lista.add("CERO");
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");
        lista.add("cuatro");
        lista.add("CINCO");
        this.registrarPersonas();
        try {
            socketServidor = new ServerSocket(4847);
            DataInputStream dataInput;
            DataOutputStream saliente;
            boolean sucess = false;
            while (true) {

                Socket cliente = socketServidor.accept();
                dataInput = new DataInputStream(cliente.getInputStream());
                saliente = new DataOutputStream(cliente.getOutputStream());
                String login = dataInput.readUTF();
                Runnable nuevoCliente = new HiloDeCliente(charla, cliente, lista, this);
                        Thread hilo = new Thread(nuevoCliente);
                        
                        hilo.start();
                for (int i = 1; i < listaEmpleados.size(); i++) {

                    Persona temp = (Persona) listaEmpleados.get(i);
                    if (login.equals(temp.correo + " " + temp.contraseña)) {
                        sucess = true;
                        

                    }
                    //socketServidor.wait();

                }
                
                if (sucess) {
                    saliente.writeInt(0);
                        
                        System.out.println("Correcto");
                        login = "";

                        

                    
                    sucess = false;
                } else {
                    System.out.println("Incorrecto");
                    saliente.writeInt(-1);
                }

                //socketServidor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            socketServidor.close();
            System.out.println("Cerrando conexion . . .");
        } catch (IOException ex) {
            System.out.println("El servidor ya ha sido cerrado");
        }
    }
}
