package com.example.movieexplorer;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;

    private List<Movie> movieList;


//    TextView check ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        check = findViewById(R.id.check);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        movieList = new ArrayList<>();
        fetchMovies();
    }

    private void fetchMovies() {


        String url = "https://api.themoviedb.org/3/trending/movie/day?language=en-US&api_key=3aa2c997ec3eb7851fa0e377b062b620";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray results = response.getJSONArray("results");
                            for (int i = 0; i < results.length(); i++) {
                                JSONObject movieObject = results.getJSONObject(i);
                                String title = movieObject.getString("title");
                                String overview = movieObject.getString("overview");
                                String posterPath = movieObject.getString("poster_path");
                                String releaseDate = movieObject.getString("release_date");
                                int movie_id = movieObject.getInt("id");

                                double rating = movieObject.getDouble("vote_average");

                                String MoreInfoLink = ": https://api.themoviedb.org/3/movie/" + movie_id + "?api_key=3aa2c997ec3eb7851fa0e377b062b620";




                                String poster = "https://image.tmdb.org/t/p/w185/" + posterPath;

                                Movie movie = new Movie(title, poster, overview, rating, releaseDate,movie_id);
                                movieList.add(movie);

//                                check.setText(poster);
                            }

                            MovieAdapter adapter = new MovieAdapter(MainActivity.this, movieList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}