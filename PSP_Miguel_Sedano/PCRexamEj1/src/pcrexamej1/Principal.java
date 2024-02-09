/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcrexamej1;

import java.util.concurrent.*;

/**
 *
 * @author DAM219
 */
public class Principal {
    public static void main(String[] args) {
        ServidorTCP servidor;
        servidor = new ServidorTCP();
        new Thread(servidor).start();
        
        for (int i = 1; i <= 6; i++) 
        {
            ClienteTCP cliente;
            cliente = new ClienteTCP(i);
            new Thread(cliente).start();

                    
        }
     }
}
