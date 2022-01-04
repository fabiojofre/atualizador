/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumer;

import java.io.IOException;
import java.net.http.HttpTimeoutException;

import javax.swing.JOptionPane;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Fabio
 */
public class ConsumidorAPI {

	public static String cnpj;
	public static  String ambiente;
	public static  int idLoja;
	public static  String url;
	public static  String token;
	public static String usuario;
	
	
   
    private static ConsumidorAPI instance;
    private CloseableHttpClient clientHttp;

    private ConsumidorAPI() {
        this.clientHttp = HttpClients.createDefault();
    }

    public static ConsumidorAPI getInstance() {
        if (instance == null) {
            instance = new ConsumidorAPI();
        }
        return instance;
    }

   
	public String doRequest(String ean) throws HttpTimeoutException {
        String responseBody = null;
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
           // MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("cnpj", cnpj)
                    .addFormDataPart("usuario", usuario)
                    .addFormDataPart("ean", ean)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .method("POST", body)
                    .addHeader("token", token)
                    .addHeader("ambiente", ambiente)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();

            Response response = client.newCall(request).execute();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(response.body().string());
            responseBody = gson.toJson(je);
            System.out.println(responseBody);
            
           
        } catch (IOException ex)  {
            JOptionPane.showMessageDialog(null, "Sem conexão com a fonte de dados!\n"+ex);
        }
        return responseBody;
    }

}
