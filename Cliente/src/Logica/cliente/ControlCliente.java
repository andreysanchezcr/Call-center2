package Logica.cliente;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class ControlCliente implements ActionListener, Runnable
{
    /** Para lectura de datos del socket */
    private DataInputStream dataInput;

    /** Para escritura de datos en el socket */
    private DataOutputStream dataOutput;
    private boolean registrarse=true;

    /** Panel con los controles para el usuario */
    private PanelCliente panel;
    ArrayList lista= new ArrayList();
    /**
     * Contruye una instancia de esta clase, lanzando un hilo para atender al
     * socket.
     * @param socket El socket
     * @param panel El panel del usuario
     */
    public ControlCliente(Socket socket, PanelCliente panel,ArrayList lista)
    {

    	this.lista=lista;
        this.panel = panel;
        try
        {
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
            panel.addActionListener(this);
            Thread hilo = new Thread(this);
            hilo.start();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void actionPerformed(ActionEvent evento)
    {
        try
        {
            dataOutput.writeInt(Integer.parseInt(panel.getTexto()));
        } catch (Exception excepcion)
        {
            excepcion.printStackTrace();
        }
    }


    public void run()
    {
        try
        {
            while (true)
            {
               // String texto = dataInput.readUTF();
            	
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
