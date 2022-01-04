/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumer;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import utilitarios.ManipulaProperties;


/**
 *
 * @author fabio
 */
public class Teste {
    public static void main(String args[]){
    	
             try {   
     OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
    //MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				  .addFormDataPart("cnpj","04524935000128")
				  .addFormDataPart("usuario","OperadorXx")
				  .addFormDataPart("ean","7896404603359")
				  .build();
   Request request = new Request.Builder()
				  .url("http://metaassessoria2.ddns.net:23145")
				  .method("POST", body)
				  .addHeader("token", "0202-0222-2202")
				  .addHeader("ambiente", "H")
			  .addHeader("Content-Type", "application/x-www-form-urlencoded")
				  .build();
 
            Response response = client.newCall(request).execute();
           
                  
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                  
                  
JsonParser jp = new JsonParser();
JsonElement je = jp.parse(response.body().string());
String prettyJsonString = gson.toJson(je);
System.out.println(prettyJsonString);

        } catch (IOException ex) {
           Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
       }
//    	ManipulaProperties mp = new ManipulaProperties();
//    	
//			try {
//				System.out.println(mp.getProp().getProperty("cts.token"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
    }
}
