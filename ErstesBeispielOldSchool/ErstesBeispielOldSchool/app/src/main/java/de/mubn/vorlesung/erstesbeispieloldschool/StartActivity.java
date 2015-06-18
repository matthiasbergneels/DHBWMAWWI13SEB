package de.mubn.vorlesung.erstesbeispieloldschool;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by d041670 on 18.06.15.
 */
public class StartActivity extends Activity {

    private static final String LOG_TAG = StartActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);

        mainLayout.setOrientation(LinearLayout.VERTICAL);

        TextView helloWorldText = new TextView(this);
        helloWorldText.setText("Hello World!");

        Button btn = new Button(this);

        btn.setText("Press for Magic");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "Button gedrückt");

            }
        });

        mainLayout.addView(helloWorldText);
        mainLayout.addView(btn);

        setContentView(mainLayout);
    }
}
