package com.ass2.i200702_i200665;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatMessages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_messages);


        ImageView back = findViewById(R.id.backArrow);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ImageView voiceCall = findViewById(R.id.voiceCall);
        voiceCall.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatMessages.this, VoiceCall.class);
                startActivity(intent);
            }
        });

        ImageView camera = findViewById(R.id.cameraIcon);
        camera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatMessages.this, Photo.class);
                startActivity(intent);
            }
        });

        ImageView videoCall = findViewById(R.id.videoCall);
        videoCall.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatMessages.this, VideoCall.class);
                startActivity(intent);
            }
        });

    }
}