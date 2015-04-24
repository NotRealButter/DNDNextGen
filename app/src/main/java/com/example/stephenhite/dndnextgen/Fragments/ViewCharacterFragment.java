package com.example.stephenhite.dndnextgen.Fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.stephenhite.dndnextgen.CreatorLogic.CreatorCntl;
import com.example.stephenhite.dndnextgen.MainActivity;
import com.example.stephenhite.dndnextgen.R;

public class ViewCharacterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    public TextView nameBox;
    public NumberPicker ageBox;
    public NumberPicker heightBox;
    public NumberPicker weightBox;
    //        TextView raceBox;
//        TextView classBox;
    public Spinner alignmentBox;
    CreatorCntl creatorCntl;

    // TODO: Rename and change types and number of parameters
    public static ViewCharacterFragment newInstance(String param1, String param2) {
        ViewCharacterFragment fragment = new ViewCharacterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ViewCharacterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_character, container, false);
        view.setBackgroundColor(Color.WHITE);
        creatorCntl = MainActivity.creatorCntl;

        nameBox = (TextView) view.findViewById(R.id.character_name_changer);
        ageBox = (NumberPicker) view.findViewById(R.id.character_age_changer);
        heightBox = (NumberPicker) view.findViewById(R.id.character_height_changer);
        weightBox = (NumberPicker) view.findViewById(R.id.character_weight_changer);
//         raceBox = (TextView) findViewById(R.id.character_race_box);
//         classBox = (TextView) findViewById(R.id.character_class_box);
        alignmentBox = (Spinner) view.findViewById(R.id.character_alignment_changer);

        ArrayAdapter<CharSequence> alignmentAdapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.alignment_array, android.R.layout.simple_spinner_item);
        alignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alignmentBox.setAdapter(alignmentAdapter);

        ageBox.setMinValue(10);
        ageBox.setMaxValue(1000);
        ageBox.setValue(21);

        heightBox.setMinValue(48);
        heightBox.setMaxValue(120);
        heightBox.setValue(69);

        weightBox.setMinValue(30);
        weightBox.setMaxValue(2000);
        weightBox.setValue(200);

        nameBox.setText(creatorCntl.userCharacter.getName());
        ageBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getAge()));
        heightBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getHeight()));
        weightBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getWeight()));

        alignmentBox.setSelection(creatorCntl.findIndexOf(creatorCntl.userCharacter.getAlignment(), alignmentBox));


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
