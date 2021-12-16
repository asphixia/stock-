package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NovoNordisk {
    public static void stockNovoNordisk() {
        try {
            URL url = new URL("https://www.google.com/finance/quote/NVO:NYSE");
            URLConnection urlConn2 = url.openConnection();
            InputStreamReader inStream1 = new InputStreamReader(urlConn2.getInputStream());
            BufferedReader br2 = new BufferedReader(inStream1);
            String price2 = null;
            String line2 = br2.readLine();

            while (line2 != null) {
                if (line2.contains("\"NVO\",")) {
                    int target2 = line2.indexOf("\"NVO\",");
                    int decimalPoint2 = line2.indexOf(".", target2);
                    int start2 = decimalPoint2;
                    while (line2.charAt(start2) != '\"') {
                        start2--;
                    }
                    price2 = line2.substring(start2 + 3, decimalPoint2 + 3);
                }
                line2 = br2.readLine();


            }
            System.out.println("The current price of the Novo Nordic stock is: " + price2);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
