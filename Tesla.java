package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Tesla {

    public static void stockTesla() {
        try {
            URL url = new URL("https://www.google.com/finance/quote/.INX:INDEXSP");
            URLConnection urlConn1 = url.openConnection();
            InputStreamReader inStream1 = new InputStreamReader(urlConn1.getInputStream());
            BufferedReader br1 = new BufferedReader(inStream1);
            String price1 = null;
            String line1 = br1.readLine();

            while (line1 != null) {
                if (line1.contains("\"TSLA\",")) {
                    int target1 = line1.indexOf("\"TSLA\",");
                    int decimalPoint1 = line1.indexOf(".", target1);
                    int start1 = decimalPoint1;
                    while (line1.charAt(start1) != '\"') {
                        start1--;
                    }
                    price1 = line1.substring(start1 + 3, decimalPoint1 + 3);
                }
                line1 = br1.readLine();


            }
            System.out.println("The current price of the Tesla stock is: " + price1);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


}

