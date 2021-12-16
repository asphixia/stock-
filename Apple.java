package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Apple {
    public static void stockApple() {
        try {
            URL url = new URL("https://www.google.com/finance/quote/AAPL:NASDAQ");
            URLConnection urlConn7 = url.openConnection();
            InputStreamReader inStream7 = new InputStreamReader(urlConn7.getInputStream());
            BufferedReader br7 = new BufferedReader(inStream7);
            String price7 = null;
            String line7 = br7.readLine();

            while (line7 != null) {
                if (line7.contains("\"AAPL\",")) {
                    int target7 = line7.indexOf("\"AAPL\",");
                    int decimalPoint7 = line7.indexOf(".", target7);
                    int start7 = decimalPoint7;
                    while (line7.charAt(start7) != '\"') {
                        start7--;
                    }
                    price7 = line7.substring(start7 + 3, decimalPoint7 + 3);
                }
                line7 = br7.readLine();


            }
            System.out.println("The current price of the Apple stock is: " + price7);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
