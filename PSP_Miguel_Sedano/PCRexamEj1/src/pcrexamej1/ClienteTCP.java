/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pcrexamej1;

/**
 *
 * @author DAM219
 */
import java.io.*;
import java.net.*;

public class ClienteTCP extends Thread 
{
    private final int identificador;

    public ClienteTCP(int identificador) 
    {
        this.identificador = identificador;
    }

    @Override
    public void run() 
    {
        try {
            Socket socket = new Socket("localhost", 12345);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hola, soy el cliente " + identificador);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            EstadoServidor estado = (EstadoServidor) inputStream.readObject();
            
            if (estado.isCompleto()) 
            {
                System.out.println("Cliente " + identificador + ": Respuesta servidor -> Servidor completo. Cerrando conexión");
            } else 
            {
                System.out.println("Cliente " + identificador + ": Conectado");
                for (int i = 0; i < 5; i++) 
                {
                    Thread.sleep(500);
                    System.out.println("Cliente " + identificador + ": Conectado");
                }
                System.out.println("Cliente " + identificador + ": Trabajo terminado. Cerrando conexión");
            }
            
            inputStream.close();
            writer.close();
            socket.close();
            
        } catch (IOException | ClassNotFoundException | InterruptedException e) 
        {    
            e.printStackTrace();
        }
    }
}
