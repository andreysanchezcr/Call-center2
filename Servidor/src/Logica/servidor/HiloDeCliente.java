package Logica.servidor;




import Logica.Persona;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Hilo encargado de atender a un cliente.
 * @author Chuidiang
 */
public class HiloDeCliente implements Runnable, ListDataListener
{
    /** Lista en la que se guarda toda la charla */
    private DefaultListModel charla;

    /** Socket al que est� conectado el cliente */
    private Socket socket;
    private boolean registrarse=true;
    

    /** Para lectura de datos en el socket */
    private DataInputStream dataInput;

    /** Para escritura de datos en el socket */
    private DataOutputStream dataOutput;
    ArrayList lista = new ArrayList();
    ObjectOutputStream dataObject; 
    ArrayList listaEmpleados = new ArrayList();

    private Servidor servidor;
    public HiloDeCliente(DefaultListModel charla, Socket socket, ArrayList lista,Servidor servidor) throws IOException
    {
        
    	
    	this.servidor=servidor;
        this.charla = charla;
        this.socket = socket;
        this.lista=lista;
        try
        {
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
            dataObject = new ObjectOutputStream(socket.getOutputStream());
            charla.addListDataListener(this);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
        	dataObject.writeObject(lista);
        }catch(Exception e){
        	System.out.println("Error al enviar la lista");
        	
        }
        
    }
    private void registrarPersonas(){
        Persona admn = new Persona("Admin","admin@tec.ac.cr","12345",null,true);
        Persona rojo = new Persona("Fernando","fernando@tec.ac.cr","12345",null,true);
        Persona verde = new Persona("Luis","luis@tec.ac.cr","12345",null,true);
        Persona amarillo = new Persona("Junior","junior@tec.ac.cr","12345",null,true);
        listaEmpleados.add(admn);
        listaEmpleados.add((Persona)verde);
        listaEmpleados.add((Persona)rojo);
        listaEmpleados.add((Persona)amarillo);
        
        
    }


    public void run()
    {
        try
        {
            while (true)
            {
                
                
                
                
                    
                
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void intervalAdded(ListDataEvent e)
    {
        String texto = (String) charla.getElementAt(e.getIndex0());
        try
        {
            //dataOutput.writeUTF(texto);
        	dataOutput.writeInt(Integer.parseInt(texto));
        } catch (Exception excepcion)
        {
            excepcion.printStackTrace();
        }
    }


	@Override
	public void contentsChanged(ListDataEvent arg0) {
		
		
	}


	@Override
	public void intervalRemoved(ListDataEvent arg0) {
		
		
	}


}
