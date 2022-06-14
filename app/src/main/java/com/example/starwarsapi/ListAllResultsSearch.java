package com.example.starwarsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListAllResultsSearch extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    ArrayList<String> stringArrayList;
    String queryString;

    private ListView allSearchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle e = getIntent().getExtras();
        if( e != null ) {
            queryString = e.getString("queryString");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_result_search);

        stringArrayList = new ArrayList<String>();
        allSearchResults = (ListView) findViewById(R.id.ListViewAllSearchResults);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected())
        {
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        if (args != null) {
            queryString = args.getString("queryString");
        }
        return new LoadStarWarsAPI(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject object = jsonArray.getJSONObject(i);
                if(queryString.equals("films/")) {
                    String title = object.getString("title");
                    stringArrayList.add(title);
                } else {
                    String name = object.getString("name");
                    stringArrayList.add(name);
                }
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArrayList);
            allSearchResults.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        // Método vazio
    }
}