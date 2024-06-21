package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ResultActivity extends AppCompatActivity {

    MaterialCardView home;
    TextView correctt,wrongt,resultinfo,resultscore;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home=findViewById(R.id.returnHome);
        correctt=findViewById(R.id.correctScore);
        wrongt=findViewById(R.id.wrongScore);
        resultinfo=findViewById(R.id.resultInfo);
        resultscore=findViewById(R.id.resultScore);
        resultImage=findViewById(R.id.resultImage);

        int correct=getIntent().getIntExtra("correct",0);
        int wrong=getIntent().getIntExtra("wrong",0);
        int score=correct*5;

        correctt.setText(""+correct);
        wrongt.setText(""+wrong);
        resultscore.setText(""+score);

        if(correct >= 0 && correct <= 5){
            resultinfo.setText("Ohhh! You have to take the quiz again");
            resultImage.setImageResource(R.drawable.ic_sad);
        }else if(correct >= 6 && correct <= 10){
            resultinfo.setText("Try a little bit more kid you can do it");
            resultImage.setImageResource(R.drawable.ic_neutral);
        } else if (correct >= 11 && correct <= 15) {
            resultinfo.setText("Hmmm! Pretty good. Well done");
            resultImage.setImageResource(R.drawable.ic_smile);
        }else if (correct >= 16 && correct <= 20) {
            resultinfo.setText("Your great! Seems like you have potential.");
            resultImage.setImageResource(R.drawable.ic_smile);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(ResultActivity.this, MainActivity.class));
        finish();
    }

}