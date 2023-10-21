package com.ass2.i200702_i200665;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity {

    private LinearLayout searchResultsView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchResultsView = findViewById(R.id.SearchResultsLL);

        TextView searchRes = findViewById(R.id.recentSearchItem1Text);
        searchRes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Item.class);
                startActivity(intent);
            }
        });

        // Bottom Nav Bar
        Button home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Home.class);
                startActivity(intent);
            }
        });

        Button search = findViewById(R.id.searchButton);
        search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Search.class);
                startActivity(intent);
            }
        });

        Button addItem = findViewById(R.id.addButton);
        addItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, PostItem.class);
                startActivity(intent);
            }
        });

        Button chat = findViewById(R.id.chatButton);
        chat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Chat.class);
                startActivity(intent);
            }
        });

        Button profile = findViewById(R.id.profileButton);
        profile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Profile.class);
                startActivity(intent);
            }
        });

    }

    public void searchTextBox(LinearLayout ll)
    {
        if (searchResultsView.getVisibility() == LinearLayout.GONE)
        {
            searchResultsView.setVisibility(LinearLayout.VISIBLE); // Show
        } else
        {
            searchResultsView.setVisibility(LinearLayout.GONE); // Hide
        }
    }
}