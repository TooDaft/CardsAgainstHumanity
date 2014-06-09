package cah.myapplication.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainMenu extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        playGameButton();
        howToPlayButton();
    }

    private void playGameButton() {

        Button btnPlayGame = (Button) findViewById(R.id.btnPlayGame);

        btnPlayGame.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                startActivity(new Intent(getApplicationContext(),PlayGameActivity.class));
            }
        });
    }


    private void howToPlayButton() {

        Button btnHowToPlay = (Button) findViewById(R.id.btnHowToPlay);

        btnHowToPlay.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                startActivity(new Intent(getApplicationContext(),HowToPlay.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
