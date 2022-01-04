/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumer;

import java.net.http.HttpTimeoutException;

import utilitarios.ManipulaProperties;

/**
 *
 * @author Fabio
 */
public class ExecutorChamadas {
	
    
    public static void main(String args[]) throws HttpTimeoutException{
    	ManipulaProperties mp = new ManipulaProperties();
    	mp.lerProperties();
        ConsumidorAPI consumidor = ConsumidorAPI.getInstance();
        consumidor.doRequest("7896404603359");
    }
    
}
