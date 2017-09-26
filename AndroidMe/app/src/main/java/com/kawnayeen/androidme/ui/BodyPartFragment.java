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

import java.util.List;

/**
 * Created by kawnayeen on 9/26/17.
 */
public class BodyPartFragment extends Fragment {
    private List<Integer> imageIds;
    private int selectedImageIndex;

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);
        if (imageIds != null) {
            imageView.setImageResource(imageIds.get(selectedImageIndex));
        }
        return rootView;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public void setSelectedImageIndex(int selectedImageIndex) {
        this.selectedImageIndex = selectedImageIndex;
    }
}
