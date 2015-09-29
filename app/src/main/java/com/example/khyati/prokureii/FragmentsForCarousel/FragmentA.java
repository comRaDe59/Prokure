package com.example.khyati.prokureii.FragmentsForCarousel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khyati.prokureii.R;

import java.util.zip.Inflater;

/**
 * Created by khyati on 9/27/2015.
 */
public class FragmentA extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.car_fragment_a,container,false);
    }
}
