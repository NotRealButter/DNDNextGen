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
    public NumberPicker strBox;
    public NumberPicker dexBox;
    public NumberPicker conBox;
    public NumberPicker intBox;
    public NumberPicker wisBox;
    public NumberPicker chaBox;
    public Spinner alignmentBox;
    public Spinner classBox;

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
        alignmentBox = (Spinner) view.findViewById(R.id.character_alignment_changer);
        classBox = (Spinner) view.findViewById(R.id.character_class_changer);

        strBox = (NumberPicker) view.findViewById(R.id.str_picker);
        dexBox = (NumberPicker) view.findViewById(R.id.dex_picker);
        conBox = (NumberPicker) view.findViewById(R.id.con_picker);
        intBox = (NumberPicker) view.findViewById(R.id.int_picker);
        wisBox = (NumberPicker) view.findViewById(R.id.wis_picker);
        chaBox = (NumberPicker) view.findViewById(R.id.cha_picker);

        ArrayAdapter<CharSequence> alignmentAdapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.alignment_array, android.R.layout.simple_spinner_item);
        alignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alignmentBox.setAdapter(alignmentAdapter);

        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.class_array, android.R.layout.simple_spinner_item);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classBox.setAdapter(classAdapter);

        ageBox.setMinValue(10);
        ageBox.setMaxValue(1000);
        ageBox.setValue(21);

        heightBox.setMinValue(48);
        heightBox.setMaxValue(120);
        heightBox.setValue(69);

        weightBox.setMinValue(30);
        weightBox.setMaxValue(2000);
        weightBox.setValue(200);

        strBox.setMinValue(0);
        strBox.setMaxValue(20);
        strBox.setValue(12);

        dexBox.setMinValue(0);
        dexBox.setMaxValue(20);
        dexBox.setValue(12);

        conBox.setMinValue(0);
        conBox.setMaxValue(20);
        conBox.setValue(12);

        intBox.setMinValue(0);
        intBox.setMaxValue(20);
        intBox.setValue(12);

        wisBox.setMinValue(0);
        wisBox.setMaxValue(20);
        wisBox.setValue(12);

        chaBox.setMinValue(0);
        chaBox.setMaxValue(20);
        chaBox.setValue(12);

        nameBox.setText(creatorCntl.userCharacter.getName());
        ageBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getAge()));
        heightBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getHeight()));
        weightBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getWeight()));

        strBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getStrVal()));
        dexBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getDexVal()));
        conBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getConVal()));
        intBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getIntVal()));
        wisBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getWisVal()));
        chaBox.setValue(Integer.valueOf(creatorCntl.userCharacter.getChaVal()));

        alignmentBox.setSelection(creatorCntl.findIndexOf(creatorCntl.userCharacter.getAlignment(), alignmentBox));
        classBox.setSelection(creatorCntl.findIndexOf(creatorCntl.userCharacter.getClass1(), classBox));

        return view;
    }

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
        void onFragmentInteraction(Uri uri);
    }

}
