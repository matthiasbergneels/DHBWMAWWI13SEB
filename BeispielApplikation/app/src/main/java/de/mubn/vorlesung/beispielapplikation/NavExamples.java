package de.mubn.vorlesung.beispielapplikation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class NavExamples extends ActionBarActivity {

    public static final int REQUEST_CODE = 1000;
    public static final String QUESTION_KEY = "QUESTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_examples);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nav_examples, menu);
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

    public void onClick(View view){

        if(view.getId() == R.id.btn_simplenavwoh){
            Intent i = new Intent(this, SimpleNavigationExample.class);
            startActivity(i);
        }else if (view.getId() == R.id.btn_simplenavwh) {
            Intent i = new Intent(this, SimpleNavigationWithHierachy.class);
            startActivity(i);
        }else if (view.getId() == R.id.btn_navwithresponse) {
            Intent i = new Intent(this, NavigationWithQuestionAndResponse.class);

            EditText ed = (EditText)findViewById(R.id.ed_question_txt);

            String question = (ed.getText().toString().equals("")) ? getText(R.string.welcome_label).toString() : ed.getText().toString();

            i.putExtra(QUESTION_KEY, question);

            startActivityForResult(i, REQUEST_CODE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){

            ((EditText)findViewById(R.id.ed_question_txt)).setText("");

            if(resultCode == RESULT_OK){
                String answer = data.getExtras().getString(NavigationWithQuestionAndResponse.ANSWER_KEY);

                Toast.makeText(this, "The answer is: " + answer, Toast.LENGTH_LONG).show();
            }
        }

    }
}