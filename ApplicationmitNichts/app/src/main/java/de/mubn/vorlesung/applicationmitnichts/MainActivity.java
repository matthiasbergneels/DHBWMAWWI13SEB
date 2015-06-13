package de.mubn.vorlesung.applicationmitnichts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by d041670 on 28.05.15.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView myView = new TextView(this);

        myView.setText("Nichts funktioniert!");

        setContentView(myView);

        Button myButton = new Button(this);
        myButton.setText("Drück mich");

        setContentView(myButton);
    }
}
