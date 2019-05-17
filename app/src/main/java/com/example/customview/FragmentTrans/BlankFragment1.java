package com.example.customview.FragmentTrans;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.customview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {


    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        ImageView imageView = view.findViewById(R.id.BlankFragment_img1);

        Fragment fragment2 = new BlankFragment2();
        fragment2.setSharedElementEnterTransition(new ChangeBounds());
        imageView.setOnClickListener(v-> getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.ActivityForFragment_FrameLayout, fragment2)
                .addSharedElement(imageView, "trans")
                .addToBackStack(null)
                .commit());
        return view;
    }

}
