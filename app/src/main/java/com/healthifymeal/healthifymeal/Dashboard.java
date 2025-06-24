package com.healthifymeal.healthifymeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {


    RecyclerView getStartedRecyclerView;
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dashboard);


        featuredRecycler = findViewById(R.id.featured_recycler);

        featuredRecycler();


    }

    public void callBMIScreen(View view) {

        Intent intent = new Intent(Dashboard.this, BMI.class);
        startActivity(intent);
    }




    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelper> featured = new ArrayList<>();
        featured.add(new FeaturedHelper(R.drawable.dietitian_1,"Dr. Sarah Gill", "Dr. Sarah is an experienced dietician who have helped thousands of patients."));
        featured.add(new FeaturedHelper(R.drawable.dietitian_1,"Dr. Sarah Gill", "Dr. Sarah is an experienced dietician who have helped thousands of patients."));
        featured.add(new FeaturedHelper(R.drawable.dietitian_1,"Dr. Sarah Gill", "Dr. Sarah is an experienced dietician who have helped thousands of patients."));

        adapter = new FeaturedAdapter(featured);
        featuredRecycler.setAdapter(adapter);

    }
}