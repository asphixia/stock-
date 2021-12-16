package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Vestas {
    public static void stockVestas() {
        try {
            URL url = new URL("https://www.google.com/finance/quote/VWS:CPH");
            URLConnection urlConn6 = url.openConnection();
            InputStreamReader inStream6 = new InputStreamReader(urlConn6.getInputStream());
            BufferedReader br6 = new BufferedReader(inStream6);
            String price6 = null;
            String line6 = br6.readLine();

            while (line6 != null) {
                if (line6.contains("\"VWS\",")) {
                    int target6 = line6.indexOf("\"VWS\",");
                    int decimalPoint6 = line6.indexOf(".", target6);
                    int start6 = decimalPoint6;
                    while (line6.charAt(start6) != '\"') {
                        start6--;
                    }
                    price6 = line6.substring(start6 + 3, decimalPoint6 + 3);
                }
                line6 = br6.readLine();


            }
            System.out.println("The current price of the Vestas stock is: " + price6);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
