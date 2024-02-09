/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcrexamej2servidor;

/**
 *
 * @author DAM219
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PCRexamEj2Servidor 
{
    public static void main(String[] args) 
    {
        final int PUERTO = 7999;

        try 
        {
            DatagramSocket socket = new DatagramSocket(PUERTO);

            byte[] buffer = new byte[33];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) 
            {
                socket.receive(packet);
                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido del cliente: " + mensaje);
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}