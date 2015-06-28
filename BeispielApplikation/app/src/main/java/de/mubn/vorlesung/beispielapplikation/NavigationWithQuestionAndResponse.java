package de.mubn.vorlesung.beispielapplikation;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class NavigationWithQuestionAndResponse extends ActionBarActivity {

    public static final String ANSWER_KEY = "ANSWER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_with_question_and_response);

        String question = getIntent().getExtras().getString(NavExamples.QUESTION_KEY);

        TextView questionLabel = (TextView)findViewById(R.id.tf_question);

        questionLabel.setText(question);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navigation_with_question_and_response, menu);
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

        String answer = ((EditText)findViewById(R.id.ed_answer)).getText().toString();

        answer = (answer.isEmpty()) ? "42" : answer;

        Intent i = new Intent();
        i.putExtra(ANSWER_KEY, answer);

        setResult(RESULT_OK, i);

        finish();

    }
}
