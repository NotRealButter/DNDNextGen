package com.example.stephenhite.dndnextgen.Fragments;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.stephenhite.dndnextgen.R;

public class CharacterCreateFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Spinner alignmentSpinner;

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
        View v = inflater.inflate(R.layout.fragment_character_create, container, false);
        alignmentSpinner = (Spinner) v.findViewById(R.id.character_alignment_spinner);
        ArrayAdapter<CharSequence> alignmentAdapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.alignment_array, android.R.layout.simple_spinner_item);
        alignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alignmentSpinner.setAdapter(alignmentAdapter);
        return v;
    }

    public OnFragmentInteractionListener getmListener() {
        return mListener;
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
