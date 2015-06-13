package de.mubn.vorlesung.applicationmitnichts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MatheActivity extends ActionBarActivity {

    public static final String MATH_RESPONSE = "MATH_RESPONSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathe);

        Intent i = getIntent();

        String mathText = i.getExtras().getString(RichtigeActivity.MATH_TEXT);

        TextView textView = (TextView)findViewById(R.id.mathe_textview);

        textView.setText(mathText);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mathe, menu);
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

        Intent i = new Intent();
        EditText editText = (EditText)findViewById(R.id.math_editText);

        String response = editText.getText().toString();

        i.putExtra(MATH_RESPONSE, response);

        setResult(Activity.RESULT_OK, i);

        finish();
    }
}
