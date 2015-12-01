package com.example.smart_mechanic.smartmechanic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Phillip on 9/29/2015.
 */
public class FailureActivity extends ActionBarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure_activity);


        ImageButton backButton = (ImageButton)findViewById(R.id.imageButton_fail_back);
        //Create intent to go back to try recording agian
       final Intent backIntent = new Intent(this, SoundLocationActivity.class);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(backIntent);
            }
        });

    }



}
