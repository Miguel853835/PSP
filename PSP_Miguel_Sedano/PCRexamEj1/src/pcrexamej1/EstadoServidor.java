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
import java.io.Serializable;

public class EstadoServidor implements Serializable {
    private boolean completo;

    public EstadoServidor(boolean completo) 
    {
        this.completo = completo;
    }
    public boolean isCompleto() 
    {
        return completo;
    }
}

