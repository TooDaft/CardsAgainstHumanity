package cah.myapplication.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * This is the screen on which the user will select which version of the game he or she will be playing.
 */

public class VersionSelect extends ActionBarActivity {


    @Override
    /**
     * Creates two buttons; one labelled 'Clean' and one labelled 'Dirty'
     */
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_select);

           dirtyButton();
           cleanButton();

    }

    /**
     * Sets up the Dirty button so that when it is clicked, a dialog box appears
     */
    private void dirtyButton() {

        Button btnDirtyGame = (Button) findViewById(R.id.btnDirtyGame);

        btnDirtyGame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                showDialog();
            }
        });

    }

    /**
     * Sets up the Clean button so that when it is clicked, Game.isDirty is set to false, and the GameSetup activity is started.
     */
    private void cleanButton() {

        Button btnCleanGame = (Button) findViewById(R.id.btnCleanGame);

        btnCleanGame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Game.isDirty = false;
                startActivity(new Intent(getApplicationContext(),GameSetup.class));
            }
        });

    }

    @Override

    /**
     * Inflate the menu; this adds items to the action bar if it is present.
     */
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.version_select, menu);
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
     * Sets up a dialog box to verify that the user is at least 18 years old.
     * If they click yes, Game.isDirty is set to true; otherwise, it is set to false.
     * From here the GameSetup activity is started
     */
    private void showDialog(){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Age Verification");
        dialogBuilder.setMessage("Are you at least 18 years old?");

        dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                Game.isDirty = false;
                startActivity(new Intent(getApplicationContext(), GameSetup.class));
            }
        });

        dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int which){
               Game.isDirty = true;
               startActivity(new Intent(getApplicationContext(),GameSetup.class));
           }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

}
