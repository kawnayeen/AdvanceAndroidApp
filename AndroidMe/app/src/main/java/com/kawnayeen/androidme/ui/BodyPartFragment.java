package com.kawnayeen.androidme.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kawnayeen.androidme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kawnayeen on 9/26/17.
 */
public class BodyPartFragment extends Fragment {
    private List<Integer> imageIds;
    private int selectedImageIndex;
    private static final String IMAGE_ID_LIST = "image_ids";
    private static final String SELECTED_INDEX = "selected_index";

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            imageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            selectedImageIndex = savedInstanceState.getInt(SELECTED_INDEX);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);
        if (imageIds != null) {
            imageView.setImageResource(imageIds.get(selectedImageIndex));
            imageView.setOnClickListener(view -> {
                if (selectedImageIndex < imageIds.size() - 1) {
                    selectedImageIndex++;
                } else {
                    selectedImageIndex = 0;
                }
                imageView.setImageResource(imageIds.get(selectedImageIndex));
            });
        }
        return rootView;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public void setSelectedImageIndex(int selectedImageIndex) {
        this.selectedImageIndex = selectedImageIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) imageIds);
        outState.putInt(SELECTED_INDEX, selectedImageIndex);
    }
}
