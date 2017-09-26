package com.kawnayeen.androidme.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.kawnayeen.androidme.MainActivity;
import com.kawnayeen.androidme.R;
import com.kawnayeen.androidme.data.AndroidImageAssets;

/**
 * Created by kawnayeen on 9/26/17.
 */
public class AndroidMeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        int headIndex = getIntent().getIntExtra(MainActivity.HEAD_INDEX, 0);
        int bodyIndex = getIntent().getIntExtra(MainActivity.BODY_INDEX, 0);
        int legIndex = getIntent().getIntExtra(MainActivity.LEG_INDEX, 0);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setSelectedImageIndex(headIndex);
            fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setSelectedImageIndex(bodyIndex);
            fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            legFragment.setSelectedImageIndex(legIndex);
            fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();
        }
    }
}
