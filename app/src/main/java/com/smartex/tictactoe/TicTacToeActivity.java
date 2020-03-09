package com.smartex.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class TicTacToeActivity extends AppCompatActivity {
    private static final String TAG = "TicTacToeActivity";

    ImageButton[][] imageButtons;
    //p1 in X p2 is O
    String p1Name, p2Name;
        //2 empty , 1 X , 0 O
    final int[][] winPositions = {{0, 1, 2},
            {3, 4, 5}
            , {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}
            , {0, 4, 8}, {2, 4, 6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        initViews();
        getPlayerName();


    }

    private void initViews() {


    }

    private void getPlayerName() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            p1Name = bundle.getString("p1Name", "Player 1");
            p2Name = bundle.getString("p2Name", "Player 2");
        } else {
            p1Name = "Player 1";
            p2Name = "Player 2";
        }
        //tv1.setText(p1Name);tv2.setText(p2Name);
    }

    private void ibPressed() {

    }
}
