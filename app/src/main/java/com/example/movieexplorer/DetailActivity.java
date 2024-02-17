package com.example.movieexplorer;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class DetailActivity extends AppCompatActivity {

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        requestQueue = Volley.newRequestQueue(this);

        ImageView imageView = findViewById(R.id.poster_image);
        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mTitle);
        TextView overview_tv = findViewById(R.id.movie_desc);
        TextView runtime_tv = findViewById(R.id.runtime);
        TextView genre_tv = findViewById(R.id.genres);
        TextView releaseDate_tv = findViewById(R.id.RDateDetail);

        int id = 0;

        Bundle bundle = getIntent().getExtras();

        // Check if bundle is not null
        if (bundle != null) {
            String mTitle = bundle.getString("title");
            String mPoster = bundle.getString("poster");
            String mOverview = bundle.getString("overview");
            String mReleaseDate = bundle.getString("releaseDate");

            id = bundle.getInt("id");

            double mRating = bundle.getDouble("rating");

            // Check if all necessary data is available
            if (mTitle != null && mPoster != null && mOverview != null) {
                Glide.with(this).load(mPoster).into(imageView);
                rating_tv.setText("Rating: "+ String.valueOf(mRating));
                releaseDate_tv.setText(mReleaseDate);

                title_tv.setText(mTitle);
                overview_tv.setText(mOverview);
            } else {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            }
        } else {

            Toast.makeText(this, "bundle error", Toast.LENGTH_LONG).show();
        }



        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=3aa2c997ec3eb7851fa0e377b062b620";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Parse response and update UI
                        try {
                            int runtime = response.getInt("runtime");

                            JSONArray genresArray = response.getJSONArray("genres");
                            List<String> genresList = new ArrayList<>();
                            for (int i = 0; i < genresArray.length(); i++) {
                                JSONObject genreObject = genresArray.getJSONObject(i);
                                String genreName = genreObject.getString("name");
                                genresList.add(genreName);
                            }

                            String genre = TextUtils.join(", ", genresList);

                            runtime_tv.setText(String.valueOf(runtime)+ " Min");
                            genre_tv.setText(genre);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }


}





