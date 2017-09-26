package com.kawnayeen.androidme.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.kawnayeen.androidme.R;
import com.kawnayeen.androidme.data.AndroidImageAssets;

/**
 * Created by kawnayeen on 9/26/17.
 */
public class MasterListFragment extends Fragment {

    OnImageClickListener callBack;

    public MasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = rootView.findViewById(R.id.images_grid_view);
        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(masterListAdapter);
        gridView.setOnItemClickListener((adapterView, view, position, l) -> callBack.onImageSelected(position));
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callBack = (OnImageClickListener) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface OnImageClickListener {
        void onImageSelected(int position);
    }
}
