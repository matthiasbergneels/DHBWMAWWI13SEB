package de.mubn.vorlesung.applicationmitnichts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class RichtigeActivity extends ActionBarActivity {

    public static final String MATH_TEXT = "MATH_TEXT";

    public static final int MATH_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_richtige);

        Log.d(RichtigeActivity.class.getSimpleName(), "onCreate ausgeführt");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(RichtigeActivity.class.getSimpleName(), "onStart ausgeführt");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(RichtigeActivity.class.getSimpleName(), "onRestart ausgeführt");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(RichtigeActivity.class.getSimpleName(), "onResume ausgeführt");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(RichtigeActivity.class.getSimpleName(), "onPause ausgeführt");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(RichtigeActivity.class.getSimpleName(), "onStop ausgeführt");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(RichtigeActivity.class.getSimpleName(), "onDestroy ausgeführt");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_richtige, menu);
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

    public void buttonPressed(View view){

        Log.d(RichtigeActivity.class.getSimpleName(), "Button gedrückt");

        Intent i = null;

        switch(view.getId()){
            case R.id.mathe_button:
                i = new Intent(this, MatheActivity.class);
                i.putExtra(MATH_TEXT, "Mathe ist soooo schön!");

                startActivityForResult(i, MATH_REQUEST);

                break;
            case R.id.db_button:
                i = new Intent(this, DBActivity.class);
                break;
        }

        if(i != null){
            startActivity(i);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MATH_REQUEST){
            if(resultCode == Activity.RESULT_OK){
                String response = data.getExtras().getString(MatheActivity.MATH_RESPONSE);

                Toast.makeText(this, "Antwort: " + response, Toast.LENGTH_LONG).show();
            }

        }

    }
}
