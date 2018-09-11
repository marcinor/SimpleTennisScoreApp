package com.example.marcin.simpletennisscoresapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int s1 = 0, s2 = 0, g1 = 0, g2 = 0, p1 = 0, p2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayPoint1(String score) {
        TextView scoreView = (TextView) findViewById(R.id.point1_text_view);
        scoreView.setText(score);
    }

    private void displayGame1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.game1_text_view);
        scoreView.setText(String.valueOf(score));
    }

    private void displaySet1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set1_text_view);
        scoreView.setText(String.valueOf(score));
    }

    public void set1(View view) {
        s1 = s1 + 1;
        displaySet1(s1);
    }

    public void game1(View view) {
        if((g1==5 && g2<5)||(g1==6&& g2==5)||(g1==6&&g2==6)){set1(view); resetGames(view);}
        else {g1+=1; displayGame1(g1);}
    }

    public void point1(View view) {
        if (p1 < 30) {p1 += 15; displayPoint1(String.valueOf(p1));}
        else if (p1==30) {p1+=10; displayPoint1(String.valueOf(p1));}
        else if (p1==40){
            if(p2<40) {game1(view); resetPoints(view);}
            else if (p2==40) {displayPoint1("AD"); p1=50;}
            else if(p2==50) {p1=40; p2=40; displayPoint1(String.valueOf(p1)); displayPoint2(String.valueOf(p2));}
        }
        else if (p1==50 && p2==40) {game1(view); resetPoints(view);}
    }

    private void displayPoint2(String score) {
        TextView scoreView = (TextView) findViewById(R.id.point2_text_view);
        scoreView.setText(String.valueOf(score));
    }

    private void displayGame2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.game2_text_view);
        scoreView.setText(String.valueOf(score));
    }

    private void displaySet2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set2_text_view);
        scoreView.setText(String.valueOf(score));
    }

    public void set2(View view) {
        s2 = s2 + 1;
        displaySet2(s2);
    }

    public void game2(View view) {
        if((g2==5 && g1<5)||(g2==6&& g1==5)||(g2==6&&g1==6)){set2(view); resetGames(view);}
        else {g2+=1; displayGame2(g2);}
    }

    public void point2(View view) {
        if (p2 < 30) {p2 += 15; displayPoint2(String.valueOf(p2));}
        else if (p2==30) {p2+=10; displayPoint2(String.valueOf(p2));}
        else if (p2==40){
            if(p1<40) {game2(view); resetPoints(view);}
            else if (p1==40) {displayPoint2("AD"); p2=50;}
            else if (p1==50) {p1=40; p2=40; displayPoint1(String.valueOf(p1)); displayPoint2(String.valueOf(p2));}
        }
        else if (p2==50 && p1==40) {game2(view); resetPoints(view);}

    }

    public void resetSets(View view) {
        s1 = 0;
        s2 = 0;
        displaySet1(s1);
        displaySet2(s2);
    }

    public void resetGames(View view) {
        g1 = 0;
        g2 = 0;
        displayGame1(g1);
        displayGame2(g2);
    }

    public void resetPoints(View view) {
        p1 = 0;
        p2 = 0;
        displayPoint1(String.valueOf(p1));
        displayPoint2(String.valueOf(p2));
    }
}
