package Logica.servidor;

import Interfaz.ServidorVentana;
import Logica.Exell;
import Logica.Persona;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

/**
 * Servidor de chat. Acepta conexiones de clientes, crea un hilo para
 * atenderlos, y espera la siguiente conexion.
 *
 * @author Chuidiang
 *
 */
public class Servidor implements Runnable{

    ArrayList listaEmpleados = new ArrayList();
    ObjectInputStream objeto;
    DataInputStream dataInput;
        DataOutputStream saliente;
        boolean sucess = false;

    private void registrarPersonas() {
        Persona admn = new Persona("Admin", "admin@tec.ac.cr", "12345", null, true);
        Persona rojo = new Persona("Fernando", "fernando@tec.ac.cr", "12345", "Rojo", true);
        Persona verde = new Persona("Luis", "luis@tec.ac.cr", "12345", null, true);
        Persona amarillo = new Persona("Junior", "junior@tec.ac.cr", "12345", null, true);
        listaEmpleados.add(admn);
        listaEmpleados.add((Persona) verde);
        listaEmpleados.add((Persona) rojo);
        listaEmpleados.add((Persona) amarillo);

    }
    /**
     * Lista en la que se guaradara toda la conversacion
     */
    private DefaultListModel charla = new DefaultListModel();

    /**
     * Instancia esta clase.
     *
     * @param args
     */
    

    /**
     * Se mete en un bucle infinito para ateder clientes, lanzando un hilo para
     * cada uno de ellos.
     */
    public Servidor() {
        registrarPersonas();
        
        
        
            
        }
    public static void main(String[] args) {
       
        Servidor server=new Servidor();
        
    }
    
    public ArrayList getListaEmpleados(){
        return listaEmpleados;
    }
        
        
        
        
        
        

        

    
    public void run() {
        try {
            ServerSocket socketServidor = new ServerSocket(5557);
            while (true) {
                Socket cliente = socketServidor.accept();
                dataInput = new DataInputStream(cliente.getInputStream());
                saliente = new DataOutputStream(cliente.getOutputStream());
                String login = dataInput.readUTF();
                String nombre="";
                String tipo="";

                for (int i = 1; i < listaEmpleados.size(); i++) {

                    Persona temp = (Persona) listaEmpleados.get(i);
                    if (login.equals(temp.correo + " " + temp.contraseña)) {
                        sucess = true;
                        nombre=temp.getNombre();
                        tipo=temp.getCategoria();

                    }

                }
                
                if (sucess) {

                    saliente.writeInt(0);
                    
                    System.out.println("Correcto");
                    saliente.writeUTF(nombre);
                    saliente.writeUTF(tipo);
                    Runnable nuevoCliente = new HiloDeCliente_1(charla, cliente);
                    Thread hilo = new Thread(nuevoCliente);
                    hilo.start();
                    
                  
                    login = "";
                    

                    sucess = false;
                } else {
                    System.out.println("Incorrecto");
                    saliente.writeInt(-1);
                }
                    
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    }

