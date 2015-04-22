package com.example.stephenhite.dndnextgen.Fragments;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.stephenhite.dndnextgen.CharCreateActivity;
import com.example.stephenhite.dndnextgen.R;

public class CharacterCreateFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    NumberPicker heightPicker, weightPicker;
    Spinner alignmentSpinner;
    CharCreateActivity characterCreateActivity;

    View v;
    NumberPicker ageBox;

    public static CharacterCreateFragment newInstance(String param1, String param2) {
        CharacterCreateFragment fragment = new CharacterCreateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CharacterCreateFragment() {
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
        v = inflater.inflate(R.layout.fragment_character_create, container, false);

        characterCreateActivity = (CharCreateActivity) getActivity();

        ageBox = (NumberPicker) v.findViewById(R.id.character_age_field);
        alignmentSpinner = (Spinner) v.findViewById(R.id.character_alignment_spinner);
        weightPicker = (NumberPicker) v.findViewById(R.id.character_weight_picker);
        heightPicker = (NumberPicker) v.findViewById(R.id.character_height_picker);

        ArrayAdapter<CharSequence> alignmentAdapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.alignment_array, android.R.layout.simple_spinner_item);
        alignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alignmentSpinner.setAdapter(alignmentAdapter);

        ageBox.setMinValue(10);
        ageBox.setMaxValue(1000);
        ageBox.setValue(21);

        heightPicker.setMinValue(48);
        heightPicker.setMaxValue(120);
        heightPicker.setValue(68);

        weightPicker.setMinValue(30);
        weightPicker.setMaxValue(2000);
        weightPicker.setValue(170);

        return v;
    }

    public OnFragmentInteractionListener getmListener() {
        return mListener;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        TextView nameBox = (TextView) v.findViewById(R.id.character_name_field);
        NumberPicker ageBox = (NumberPicker) v.findViewById(R.id.character_age_field);
        NumberPicker heightPicker = (NumberPicker) v.findViewById(R.id.character_height_picker);
        NumberPicker weightPicker = (NumberPicker) v.findViewById(R.id.character_weight_picker);
        Spinner alignmentBox = (Spinner) v.findViewById(R.id.character_alignment_spinner);

        characterCreateActivity.creatorCntl.userCharacter.setName(nameBox.getText().toString());
        characterCreateActivity.creatorCntl.userCharacter.setAge(ageBox.getValue());
        characterCreateActivity.creatorCntl.userCharacter.setHeight(heightPicker.getValue());
        characterCreateActivity.creatorCntl.userCharacter.setWeight(weightPicker.getValue());
        characterCreateActivity.creatorCntl.userCharacter.setAlignment(alignmentBox.getSelectedItem().toString());

        mListener = null;


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onPause() {
        super.onPause();

    }
}
