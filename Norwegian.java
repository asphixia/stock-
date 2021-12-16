package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Norwegian {
    public static void stockNorwegian() {
        try {
            URL url = new URL("https://www.google.com/finance/quote/NWARF:OTCMKTS");
            URLConnection urlConn4 = url.openConnection();
            InputStreamReader inStream4 = new InputStreamReader(urlConn4.getInputStream());
            BufferedReader br4 = new BufferedReader(inStream4);
            String price4 = null;
            String line4 = br4.readLine();

            while (line4 != null) {
                if (line4.contains("\"NWARF\",")) {
                    int target4 = line4.indexOf("\"NWARF\",");
                    int decimalPoint4 = line4.indexOf(".", target4);
                    int start4 = decimalPoint4;
                    while (line4.charAt(start4) != '\"') {
                        start4--;
                    }
                    price4 = line4.substring(start4 + 3, decimalPoint4 + 4);
                }
                line4 = br4.readLine();


            }
            System.out.println("The current price of the Norwegian stock is: " + price4);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
