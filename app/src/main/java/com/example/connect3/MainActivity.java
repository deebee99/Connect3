package com.example.connect3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    int f = 0;
    int color = 0;
    final int status[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    final int[][] pos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}};


    public void start(View view) {
        ImageView i = (ImageView) view;
        int index = Integer.parseInt(i.getTag().toString());
        if (status[index] != 2) {
            Toast.makeText(this, "already filled! choose another one", Toast.LENGTH_LONG).show();
            return;
        }
        if (color == 0) {
            i.setImageResource(R.drawable.yellow);
            status[index] = 1;
            color = 1;
        } else if (color == 1) {

            i.setImageResource(R.drawable.red);
            status[index] = 0;
            color = 0;
        }

        for (int p[] : pos) {
            if (status[p[0]] != 2 && status[p[0]] == status[p[1]] && status[p[1]] == status[p[2]]) {
                Toast.makeText(this, " player " + (color + 1) + " won ", Toast.LENGTH_LONG).show();
                f = 1;
                finish();
                startActivity(getIntent());
            }
        }
        int c = 0;
        for (int ii : status) {
            if (ii != 2) c++;
        }
        if (c == 9) {
            if (f == 0)
                Toast.makeText(this, "Game over - no one won !! start again", Toast.LENGTH_LONG).show();
            finish();
            startActivity(getIntent());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
