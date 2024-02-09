/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcrexamej2cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author DAM219
 */

public class PCRexamEj2Cliente 
{

    public static void main(String[] args) 
    {
        final String MENSAJE = "Hola servidor, soy Miguel Sedano.";
        final String SERVIDOR_IP = "localhost";
        final int PUERTO = 7999;

        try 
        {
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccionServidor = InetAddress.getByName(SERVIDOR_IP);
            byte[] buffer = new byte[33];
            buffer = MENSAJE.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO);

            socket.send(packet);

            System.out.println("Mensaje enviado al servidor: " + MENSAJE);

            socket.close();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
