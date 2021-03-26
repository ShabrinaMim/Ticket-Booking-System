package hu.ozeki;

import java.net.*;

public class Java_example_httprequest {

    public static void main(String[] args) {
        try {
            String recipient = "+8801632940340";
            String message = "Hello World";
            String username = "admin";
            String password = "pass12345";
            String originator = "+8801716695930";

            String requestUrl  = "http://192.168.0.7:9500/api?action=sendmessage&" +
                    "username=" + URLEncoder.encode(username, "UTF-8") +
                    "&password=" + URLEncoder.encode(password, "UTF-8") +
                    "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
                    "&messagetype=SMS:TEXT" +
                    "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
                    "&originator=" + URLEncoder.encode(originator, "UTF-8") +
                    "&serviceprovider=SMPP1" +
                    "&responseformat=html";



            URL url = new URL(requestUrl);
            HttpURLConnection uc = (HttpURLConnection)url.openConnection();

            System.out.println(uc.getResponseMessage());

            uc.disconnect();

        } catch(Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

}