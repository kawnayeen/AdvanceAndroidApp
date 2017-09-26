package com.kawnayeen.androidme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.kawnayeen.androidme.ui.AndroidMeActivity;
import com.kawnayeen.androidme.ui.MasterListFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public static final String HEAD_INDEX = "headIndex";
    public static final String BODY_INDEX = "bodyIndex";
    public static final String LEG_INDEX = "legIndex";
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position Clicked " + position, Toast.LENGTH_LONG).show();
        int segment = position / 12;
        int index = position % 12;
        switch (segment) {
            case 0:
                headIndex = index;
                break;
            case 1:
                bodyIndex = index;
                break;
            case 2:
                legIndex = index;
                break;
        }

        Bundle b = new Bundle();
        b.putInt(HEAD_INDEX, headIndex);
        b.putInt(BODY_INDEX, bodyIndex);
        b.putInt(LEG_INDEX, legIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(view -> startActivity(intent));
    }
}
