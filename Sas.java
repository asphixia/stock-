package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Sas {
    public static void stockSas() {
        try {
            URL url = new URL("https://www.google.com/finance/quote/SAS:STO");
            URLConnection urlConn5 = url.openConnection();
            InputStreamReader inStream5 = new InputStreamReader(urlConn5.getInputStream());
            BufferedReader br5 = new BufferedReader(inStream5);
            String price5 = null;
            String line5 = br5.readLine();

            while (line5 != null) {
                if (line5.contains("\"SAS\",")) {
                    int target5 = line5.indexOf("\"SAS\",");
                    int decimalPoint5 = line5.indexOf(".", target5);
                    int start5 = decimalPoint5;
                    while (line5.charAt(start5) != '\"') {
                        start5--;
                    }
                    price5 = line5.substring(start5 + 3, decimalPoint5 + 3);
                }
                line5 = br5.readLine();


            }
            System.out.println("The current price of the Sas stock is: " + price5);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
