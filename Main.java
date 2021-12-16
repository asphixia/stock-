package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args){
        System.out.println("*********************stock-prices-in-$*********************");
        Tesla stock = new Tesla();
        Tesla.stockTesla();

        CocaCola stock1 = new CocaCola();
        CocaCola.stockCocaCola();

        NovoNordisk stock2 = new NovoNordisk();
        NovoNordisk.stockNovoNordisk();

        Nvidia stock3 = new Nvidia();
        Nvidia.stockNvidia();

        Norwegian stock4 = new Norwegian();
        Norwegian.stockNorwegian();

        Sas stock5 = new Sas();
        Sas.stockSas();

        Vestas stock6 = new Vestas();
        Vestas.stockVestas();

        Apple stock7 = new Apple();
        Apple.stockApple();

        System.out.println("***********************************************************");










    }
}