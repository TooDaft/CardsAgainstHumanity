package cah.myapplication.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PlayGameActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);


           dirtyButton();
           cleanButton();
    }


    private void dirtyButton() {

        Button btnDirtyGame = (Button) findViewById(R.id.btnDirtyGame);

        btnDirtyGame.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                showDialog();
            }
        });
    }


    private void cleanButton() {

        Button btnCleanGame = (Button) findViewById(R.id.btnCleanGame);

        btnCleanGame.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                startActivity(new Intent(getApplicationContext(),GameSetup.class));
                Game.isDirty = false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play_game, menu);
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

    private void showDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Age Verification");
        dialogBuilder.setMessage("Are you at least 18 years old?");

        dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                startActivity(new Intent(getApplicationContext(), GameSetup.class));
                Game.isDirty = false;
            }
        });

        dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int which){
               startActivity(new Intent(getApplicationContext(),GameSetup.class));
               Game.isDirty = true;
           }
        });



        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

}
