package cah.myapplication.app;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.io.FileNotFoundException;

/**
 * Activity Screen on which the user selects the number of players and the target number of awesome points
 */

public class GameSetup extends ActionBarActivity {

    NumberPicker np, np2;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);

        //errors out when I access Game.numPlayers
        //Game.numPlayers = 2;
        Game.maxAwesomePoints = 1;

        //set up the first picker with a range of 2 to 8
        np = (NumberPicker) findViewById(R.id.numberPicker1);   //set up the first picker with a range of 2 to 8
        np.setMinValue(2);
        np.setMaxValue(8);
        np.setWrapSelectorWheel(false);

        //the first picker is to be used to select the number of players
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                Game.numPlayers = i2;
            }
        });

        //set up the second picker with a range of 1 to 6
        np2 = (NumberPicker) findViewById(R.id.numberPicker2);
        np2.setMinValue(1);
        np2.setMaxValue(6);
        np2.setWrapSelectorWheel(false);

        //the second picker is to be used to select the target number of awesome points
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                Game.maxAwesomePoints = i2;
            }
        });

        gamePlayGame();
    }

    /**
     * Sets up the Start Game button to display a dialog box.
     * Reads in the white and black cards from either the clean or dirty decks based on the value of Game.isDirty
     * Creates an ArrayList of players using the number of players selected with the picker
     */
    private void gamePlayGame(){

        Button btnPlayGame= (Button) findViewById(R.id.btnPlayGame);

        btnPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Game.readInput();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                Game.createPlayers();
                showDialog();
            }
        });

    }

    @Override
    /**
     * Inflate the menu; this adds items to the action bar if it is present.
     */
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.game_setup, menu);
        return true;

    }

    @Override
    /**
     * Handle action bar item clicks here. The action bar will
     * automatically handle clicks on the Home/Up button, so long
     * as you specify a parent activity in AndroidManifest.xml.
     */
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Builds the dialog box that is displayed when the Start Game button is pressed.
     * Starts the CardCzarRead activity when the Ok button is pressed.
     */
    private void showDialog(){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Switch to Card Czar");
        dialogBuilder.setMessage("Player 1 is the Card Czar. Hand him or her the device.");

        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which){
                startActivity(new Intent(getApplicationContext(),CardCzarRead.class));
            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

}
