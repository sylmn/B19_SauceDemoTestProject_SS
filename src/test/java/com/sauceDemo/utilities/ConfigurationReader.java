package com.sauceDemo.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * Bu class configuration.properties dosyasinda bulunan verileri okumaya yarar.
     */

    private static Properties properties;  // properties'leri icinde key/value formatinda saklayan yapi

    static {
        try {
            // bilgilerin saklandigi dosyanin yolu
            String path = "configuration.properties";

            //buradaki dosyalari java icin oku

            /**
             * FileInputStream-> Java'ya disaridan veri almak icin kullanilir.
             * FileOutputStream ->Java'dan disariya veri vermek icin kullanilir.
             */

            FileInputStream input = new FileInputStream(path);
            // key/value yapisinda bilgi tutan properties objemi instantiate edeyim.
            properties = new Properties();

            //FIS ile okunan bilgileri properties e yükleyelim
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
