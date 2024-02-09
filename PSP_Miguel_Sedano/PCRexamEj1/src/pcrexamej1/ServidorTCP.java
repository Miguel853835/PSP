/*
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

public class ServidorTCP extends Thread 
{
    private ServerSocket serverSocket;
    private final int MAX_CONEXIONES = 3;
    private int numConexiones = 0;

    public ServidorTCP() 
    {
        try 
        {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run() 
    {
        while (true) 
        {
            try 
            {
                Socket socket = serverSocket.accept();
                if (numConexiones < MAX_CONEXIONES) 
                {
                    numConexiones++;
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println(reader.readLine());
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(new EstadoServidor(false)); 
                    outputStream.close();
                    socket.close();
                } else 
                {
                    System.out.println("Servidor completo");
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(new EstadoServidor(true));
                    outputStream.close();
                    socket.close();
                }
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
