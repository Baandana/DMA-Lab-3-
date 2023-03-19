package com.example.wordsapp3.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordsapp3.Adapters.LetterAdapter;
import com.example.wordsapp3.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LetterAdapter letterAdapter;

    private Boolean isGridLayoutManager = true;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        // Setting up the RecyclerView

        setRecyclerView();

        setTitle("Letter App");

    }

    // Helper method to set up the RecyclerView with the current layout
    private void setRecyclerView()
    {
        if(isGridLayoutManager)
            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
        else
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerView.setAdapter(new LetterAdapter());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout_menu, menu);
        setIcon(menu.findItem(R.id.action_switch_layout));
        return true;

    }

    public void setIcon(MenuItem menuItem)
    {
        if(menuItem != null)
            menuItem.setIcon(
                    isGridLayoutManager? ContextCompat.getDrawable(this,R.drawable.vertical_distribute)
                            :ContextCompat.getDrawable(this,R.drawable.grid_drawable)
            );
    }
    // Method to handle clicks on items in the options menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_switch_layout)
        {
            isGridLayoutManager = !isGridLayoutManager;
            setRecyclerView();

            // Setting the icon for the layout switch button
            setIcon(item);
            return true;
        }
        else
            // If the clicked item is not the layout switch button, call the superclass method
            return super.onOptionsItemSelected(item);

    }
}