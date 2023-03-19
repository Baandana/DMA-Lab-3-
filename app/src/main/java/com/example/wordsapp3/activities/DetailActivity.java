package com.example.wordsapp3.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordsapp3.Adapters.WordAdapter;
import com.example.wordsapp3.R;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView letterRecyclerView;
    private WordAdapter wordAdapter;

    public static final String TAG ="DETAIL_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        letterRecyclerView=findViewById(R.id.recycler_view);

        Log.d(TAG, "onCreate: I'm In");
        wordAdapter = new WordAdapter(this, getIntent().getStringExtra("LETTER"));

        letterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        letterRecyclerView.setAdapter(wordAdapter);
        setTitle("Words with the letter : " + getIntent().getStringExtra("LETTER"));

    }






}