package com.smartex.tictactoe;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button bstart;
    EditText etP1Name, etP2Name;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked");
                String p1Name = etP1Name.getText().toString();
                String p2Name = etP2Name.getText().toString();

                if ((p1Name.length() * p2Name.length()) != 0) {
                    Log.d(TAG, "onClick: starting act.");
                    Bundle bundle = new Bundle();
                    bundle.putString("p1Name", p1Name);
                    bundle.putString("p2Name", p2Name);
                    startActivity(new Intent(MainActivity.this,TicTacToeActivity.class).putExtra("bundle",bundle));
                    playSound();
                } else {
                    Log.d(TAG, "onClick: text missing");
                    tv1.setTextColor(getResources().getColor(R.color.colorWarning,getTheme()));
                    tv2.setTextColor(getResources().getColor(R.color.colorWarning,getTheme()));
                    toast("Please Enter Players name");
                }
            }
        });
    }

    private void playSound() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.inflicted);

    }

    private void toast(String message) {
        Log.d(TAG, "toast: " + message);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void initviews() {
        Log.d(TAG, "initviews: started");
        bstart = findViewById(R.id.bStart);
        etP1Name = findViewById(R.id.etPlayer1Name);
        etP2Name = findViewById(R.id.etPlayer2Name);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
    }
}
