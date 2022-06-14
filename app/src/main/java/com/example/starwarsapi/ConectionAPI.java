package com.example.starwarsapi;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConectionAPI {
    private static final String LOG_TAG = ConectionAPI.class.getSimpleName();

    private static final String STAR_WARS_URL = "https://swapi.dev/api/";

    static String queryCharacters(String queryString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String retornoJSONString = null;
        try {
            String url = STAR_WARS_URL + queryString;

            Uri builtURI = Uri.parse(url).buildUpon()
                    .build();

            URL requestURL = new URL(builtURI.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                return null;
            }
            retornoJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Log.d(LOG_TAG, retornoJSONString);
        return retornoJSONString;
    }
}
