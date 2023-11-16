package com.example.perfectmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detailview extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private StaffAdapter staffAdapter;

    private ImageView img;
    private TextView name;
    private TextView year;
    private WebView videoView;


    private ProgressBar pb, progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview);

        viewPager2 = findViewById(R.id.viewPager);
        img = findViewById(R.id.img_film);
        name = findViewById(R.id.name_film);
        year = findViewById(R.id.year_film);
        videoView = findViewById(R.id.videoView);
        pb = findViewById(R.id.vid_prog);
        progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        String name_film = getIntent().getStringExtra("name");
        String image = getIntent().getStringExtra("img");
        String year_film = getIntent().getStringExtra("year");
        String fragment = getIntent().getStringExtra("fragment");

        if ("top".equals(fragment)) {
            year.setText("Год выпуска: " + year_film);
        } else if ("premier".equals(fragment)) {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("ru", "RU"));
            Date date = null;
            try {
                date = inputFormat.parse(year_film);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            String outputDateStr = outputFormat.format(date);
            year.setText("Год премьеры: " + outputDateStr);
        }

        name.setText(name_film);
        Picasso.with(getApplicationContext()).load(image).into(img);

        String id_film = getIntent().getStringExtra("id");
        int id = Integer.parseInt(id_film);

        ApiInterface apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);
        Call<ArrayList<Staff>> call = apiInterface.getStaffList(id);

        call.enqueue(new Callback<ArrayList<Staff>>() {
            @Override
            public void onResponse(Call<ArrayList<Staff>> call, Response<ArrayList<Staff>> response) {
                if (response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);

                    ArrayList<Staff> staffList = response.body();

                    staffAdapter = new StaffAdapter(detailview.this, staffList);
                    viewPager2.setAdapter(staffAdapter);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Staff>> call, Throwable t) {

            }
        });
        ApiInterface trailer = ServiceBuilder.buildRequest().create(ApiInterface.class);
        Call<Trailer> call_trailer = apiInterface.getTrailerFilmsList(id);
        call_trailer.enqueue(new Callback<Trailer>() {
            @Override
            public void onResponse(Call<Trailer> call, Response<Trailer> response) {
                if (response.isSuccessful()) {
                    for (TrailerItems item : response.body().items){
                        if (item.getSite().equals("YOUTUBE")){
                            WebSettings webSettings = videoView.getSettings();
                            webSettings.setJavaScriptEnabled(true);
                            videoView.getSettings().setJavaScriptEnabled(true);
                            videoView.setWebViewClient(new webViewClient(pb));
                            videoView.loadUrl(item.getUrl());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Trailer> call, Throwable t) {
                Log.d("e", t.getMessage());
            }
        });
    }
}