package com.kawnayeen.androidme.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kawnayeen.androidme.R;
import com.kawnayeen.androidme.data.AndroidImageAssets;

/**
 * Created by kawnayeen on 9/26/17.
 */
public class BodyPartFragment extends Fragment {
    public BodyPartFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        return rootView;
    }
}
