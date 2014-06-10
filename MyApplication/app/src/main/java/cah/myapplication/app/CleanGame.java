package cah.myapplication.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;


public class CleanGame extends ActionBarActivity {

    NumberPicker np, np2;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_game);

        np = (NumberPicker) findViewById(R.id.numberPicker1);

        np.setMinValue(4);
        np.setMaxValue(15);
        np.setWrapSelectorWheel(false);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {

            }
        });


        np2 = (NumberPicker) findViewById(R.id.numberPicker2);

        np2.setMinValue(3);
        np2.setMaxValue(20);
        np2.setWrapSelectorWheel(false);

        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {

            }
        });


        startGameButton();
        backToMenuButton();

    }


    private void startGameButton(){

        Button btnStartGameC = (Button) findViewById(R.id.btnStartGameC);

        btnStartGameC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                //Fill in code to start the game.
                //
            }
        });
    }

    private void backToMenuButton(){

        Button btnToMenu = (Button) findViewById(R.id.btnToMenu);

        btnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.clean_game, menu);
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
