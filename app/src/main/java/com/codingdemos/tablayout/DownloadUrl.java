package com.codingdemos.tablayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jason on 10/17/18.
 */

public class DownloadUrl {

    public String ReadTheURL (String placeUrl) throws IOException {
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(placeUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            data = stringBuffer.toString();
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            httpURLConnection.disconnect();
        }

        return data;
    }
}