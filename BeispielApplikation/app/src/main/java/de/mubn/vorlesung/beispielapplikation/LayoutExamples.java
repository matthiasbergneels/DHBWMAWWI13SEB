package de.mubn.vorlesung.beispielapplikation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LayoutExamples extends ActionBarActivity {

    private final String LOG_TAG = LayoutExamples.class.getSimpleName();

    public static final String KEY_LAYOUT_ID = "LAYOUT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_examples);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_layout_examples, menu);
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

        switch(view.getId()){
            case R.id.btn_frame_layout:
                startActivityWithLayoutId(R.layout.example_layout_frame);
                break;
            case R.id.btn_absolut_layout:
                startActivityWithLayoutId(R.layout.example_layout_absolut);
                break;
            case R.id.btn_linear_layout:
                startActivityWithLayoutId(R.layout.example_layout_linear);
                break;
            case R.id.btn_relativ_layout:
                startActivityWithLayoutId(R.layout.example_layout_relativ);
                break;
            case R.id.btn_table_layout:
                startActivityWithLayoutId(R.layout.example_layout_table);
                break;
            default:
                Helper.logAndToast(this, LOG_TAG, "No valid Layout!");


        }

    }

    private void startActivityWithLayoutId(int layoutId){
        Intent i = new Intent(this, LayoutExample.class);
        i.putExtra(KEY_LAYOUT_ID, layoutId);

        startActivity(i);
    }
}
