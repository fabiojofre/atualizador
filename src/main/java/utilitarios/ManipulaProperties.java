package utilitarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import consumer.ConsumidorAPI;

public class ManipulaProperties {

	//ler arquivos do prooperties
    public Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("C:\\vr\\vr.properties");
        props.load(file);
        return props;
    }
    
    //teste da lida dos propertie

    public void lerProperties(){
    	
        Properties prop;
        
		try {
			prop = getProp();
			
			 	ConsumidorAPI.ambiente =  prop.getProperty("cts.ambiente");
		        ConsumidorAPI.cnpj =  prop.getProperty("cts.cnpj");
		        ConsumidorAPI.idLoja = Integer.parseInt(prop.getProperty("cts.idLoja"));
		        ConsumidorAPI.url =  prop.getProperty("cts.url");
		        ConsumidorAPI.token =  prop.getProperty("cts.token");
		        ConsumidorAPI.usuario =  prop.getProperty("cts.usuario");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
        
    }
}
