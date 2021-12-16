package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Nvidia {
    public static void stockNvidia() {
        try {
            URL url = new URL("https://www.google.com/finance/quote/NVDA:NASDAQ");
            URLConnection urlConn3 = url.openConnection();
            InputStreamReader inStream3 = new InputStreamReader(urlConn3.getInputStream());
            BufferedReader br3 = new BufferedReader(inStream3);
            String price3 = null;
            String line3 = br3.readLine();

            while (line3 != null) {
                if (line3.contains("\"NVDA\",")) {
                    int target3 = line3.indexOf("\"NVDA\",");
                    int decimalPoint3 = line3.indexOf(".", target3);
                    int start3 = decimalPoint3;
                    while (line3.charAt(start3) != '\"') {
                        start3--;
                    }
                    price3 = line3.substring(start3 + 3, decimalPoint3 + 3);
                }
                line3 = br3.readLine();


            }
            System.out.println("The current price of the Nvidia stock is: " + price3);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
