package com.example.stephenhite.dndnextgen.CreatorLogic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stephenhite.dndnextgen.R;

import java.util.ArrayList;

public class RaceAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Race> mRaceItems;

    public RaceAdapter(Context context, ArrayList<Race> raceItems) {
        mContext = context;
        mRaceItems = raceItems;
    }

    @Override
    public int getCount() {
        return mRaceItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mRaceItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_item, null);
        } else {
            view = convertView;
        }

        TextView titleView = (TextView) view.findViewById(R.id.title);
        TextView subtitleView = (TextView) view.findViewById(R.id.subTitle);
        return view;
    }

}
