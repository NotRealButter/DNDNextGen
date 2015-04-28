package com.example.stephenhite.dndnextgen.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.stephenhite.dndnextgen.R;

public class GameClassFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    View v;

    public static GameClassFragment newInstance(String param1, String param2) {
        GameClassFragment fragment = new GameClassFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public GameClassFragment() {
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
        v = inflater.inflate(R.layout.fragment_game_class, container, false);
        Spinner raceSpinner = (Spinner) v.findViewById(R.id.classSpinner);
        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.class_array, R.layout.spinner_item);
        classAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        raceSpinner.setAdapter(classAdapter);
        raceSpinner.setOnItemSelectedListener(this);

        return v;
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        ImageView image = (ImageView) getView().findViewById(R.id.class_picture);
        TextView description = (TextView) getView().findViewById(R.id.class_description);
        switch (position) {
            case 0:
                description.setText(R.string.barbarian_text);
                image.setImageResource(R.drawable.barbarian);
                break;
            case 1:
                description.setText(R.string.bard_text);
                image.setImageResource(R.drawable.bard);
                break;
            case 2:
                image.setImageResource(R.drawable.cleric);
                description.setText(R.string.cleric_text);
                break;
            case 3:
                image.setImageResource(R.drawable.druid);
                description.setText(R.string.druid_text);
                break;
            case 4:
                image.setImageResource(R.drawable.fighter);
                description.setText(R.string.fighter_text);
                break;
            case 5:
                description.setText(R.string.monk_text);
                image.setImageResource(R.drawable.monk);
                break;
            case 6:
                description.setText(R.string.paladin_text);
                image.setImageResource(R.drawable.paladin);
                break;
            case 7:
                description.setText(R.string.ranger_text);
                image.setImageResource(R.drawable.ranger);
                break;
            case 8:
                image.setImageResource(R.drawable.rogue);
                description.setText(R.string.rogue_text);
                break;
            case 9:
                description.setText(R.string.sorcerer_text);
                image.setImageResource(R.drawable.sorceror);
                break;
            case 10:
                description.setText(R.string.warlock_text);
                image.setImageResource(R.drawable.magus);
                break;
            case 11:
                image.setImageResource(R.drawable.wizard);
                description.setText(R.string.wizard_text);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
