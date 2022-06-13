package com.example.starwarsapi;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class LoadStarWarsAPI extends AsyncTaskLoader<String> {
    private String mQueryString;
    LoadStarWarsAPI(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return ConectionAPI.queryCharacters(mQueryString);
    }
}
