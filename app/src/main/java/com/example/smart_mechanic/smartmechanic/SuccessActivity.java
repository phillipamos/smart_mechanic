package com.example.smart_mechanic.smartmechanic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class SuccessActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);



        //Get reference to find shop button and attach the onClick listener
        Button findShopButton = (Button)findViewById(R.id.button_findShop);
        findShopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri shopsURI = Uri.parse("geo:0,0?q=Automotive+Shop");
                Intent intent = new Intent(Intent.ACTION_VIEW, shopsURI);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });


        //Get reference to the play button and attach the onClick listener
        ImageButton buttonPlay = (ImageButton) findViewById(R.id.imageButton_play);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioRecordTest playAudio = new AudioRecordTest();
                playAudio.startPlaying();

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_success, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
