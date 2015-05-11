package Logica.cliente;




import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Cliente
{
    private Socket socket;

    private PanelCliente panel;


   // public static void main(String[] args)
   // {
   //     new Cliente("fernando@tec.ac.cr","12345");
   // }

  
    public Cliente(String correo, String contrasena)
    {
        try
        {
        	
            creaYVisualizaVentana();
            socket = new Socket("localhost", 4847);
            DataOutputStream flujoSaliente = new DataOutputStream(socket.getOutputStream());
            DataInputStream flujoEntrante = new DataInputStream(socket.getInputStream());
            flujoSaliente.writeUTF(correo+" "+contrasena);
            
            int indicador=flujoEntrante.readInt();
            System.out.println(indicador);
            if(indicador==0){
                System.out.println("EXito");
            }else{
                System.out.println("Fallo");
            }
            
            //socket.wait(10);
            
            ObjectInputStream objeto_entrante= new ObjectInputStream(socket.getInputStream());
            ArrayList lista = (ArrayList) objeto_entrante.readObject();
            ControlCliente control = new ControlCliente(socket, panel,lista);
            socket.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    

    /**
     * Crea una ventana, le mete dentro el panel para el cliente y la visualiza
     */
    private void creaYVisualizaVentana()
    {
        JFrame v = new JFrame();
        panel = new PanelCliente(v.getContentPane());
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
