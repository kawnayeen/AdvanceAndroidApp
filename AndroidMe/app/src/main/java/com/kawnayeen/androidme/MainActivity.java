package com.kawnayeen.androidme;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kawnayeen.androidme.data.AndroidImageAssets;
import com.kawnayeen.androidme.ui.BodyPartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();

        BodyPartFragment headFragment = new BodyPartFragment();
        headFragment.setImageIds(AndroidImageAssets.getHeads());
        headFragment.setSelectedImageIndex(1);
        fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();

        BodyPartFragment bodyFragment = new BodyPartFragment();
        bodyFragment.setImageIds(AndroidImageAssets.getBodies());
        bodyFragment.setSelectedImageIndex(1);
        fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();

        BodyPartFragment legFragment = new BodyPartFragment();
        legFragment.setImageIds(AndroidImageAssets.getLegs());
        legFragment.setSelectedImageIndex(1);
        fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();
    }
}
