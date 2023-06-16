package org.Rakesh;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  {
        String stringUrl = "https://api.zippopotam.us/us/33162";
        URL url;
        try {
           url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection connection ;
        int responseCode;
        try {
            connection =  (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(responseCode==200){
            try {
                BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String ReadLine = null;
                while((ReadLine = bf.readLine())!=null){
                    sb.append(ReadLine);
                }
               bf.close();
                JSONObject object = new JSONObject(sb.toString());
                System.out.println("country-> "+object.get("country"));
                System.out.println("places-> "+object.get("places"));
                System.out.println("country abbreviation -> "+object.get("country abbreviation"));
                System.out.println("post code-> "+object.get("post code"));


            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }else{
            System.out.println("invalid String");
        }



    }
}