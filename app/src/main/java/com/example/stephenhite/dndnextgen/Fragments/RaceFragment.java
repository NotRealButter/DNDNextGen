package com.example.stephenhite.dndnextgen.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.stephenhite.dndnextgen.R;

public class RaceFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View v;

    public static RaceFragment newInstance() {
        RaceFragment fragment = new RaceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.race_fragment, container, false);
        Spinner raceSpinner = (Spinner) v.findViewById(R.id.raceSpinner);
        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.race_array, R.layout.spinner_item);
        raceAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        raceSpinner.setAdapter(raceAdapter);
        raceSpinner.setOnItemSelectedListener(this);

        return v;
    }

    public static RaceFragment newInstance(String param1, String param2) {
        RaceFragment fragment = new RaceFragment();


        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    public RaceFragment() {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        ImageView image = (ImageView) getView().findViewById(R.id.race_picture);
        TextView description = (TextView) getView().findViewById(R.id.race_description);
        switch (position) {
            case 0:
                description.setText(R.string.human_text);
                image.setImageResource(R.drawable.human);
                break;
            case 1:
                description.setText(R.string.elf_text);
                image.setImageResource(R.drawable.elf);
                break;
            case 2:
                image.setImageResource(R.drawable.halfling);
                description.setText(R.string.halfling_text);
                break;
            case 3:
                image.setImageResource(R.drawable.halforc);
                description.setText(R.string.half_orc_text);
                break;
            case 4:
                image.setImageResource(R.drawable.halfelf);
                description.setText(R.string.half_elf_text);
                break;
            case 5:
                description.setText(R.string.dwarf_text);
                image.setImageResource(R.drawable.dwarf);
                break;
            case 6:
                description.setText(R.string.tiefling_text);
                image.setImageResource(R.drawable.tiefling);
                break;
            case 7:
                description.setText(R.string.eladrin_text);
                image.setImageResource(R.drawable.eladrin);
                break;
            case 8:
                image.setImageResource(R.drawable.dragonborn);
                description.setText(R.string.dragon_born_text);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}