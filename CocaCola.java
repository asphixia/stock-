package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CocaCola {
    public static void stockCocaCola(){
        try {

            URL url = new URL("https://www.google.com/finance/quote/KO:NYSE");
            URLConnection urlConn = url.openConnection();
            InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
            BufferedReader br = new BufferedReader(inStream);
            String price = null;
            String line = br.readLine();

            while (line != null) {
                if (line.contains("\"KO\",")) {
                    int target = line.indexOf("\"KO\",");
                    int decimalPoint = line.indexOf(".", target);
                    int start = decimalPoint;
                    while (line.charAt(start) != '\"') {
                        start--;
                    }
                    price = line.substring(start + 3, decimalPoint + 3);


                }
                line = br.readLine();
            }
            System.out.println("The current price of the CocaCola stock is: " + price);

        } catch (IOException ioe){
            ioe.printStackTrace();

        }



    }
}





