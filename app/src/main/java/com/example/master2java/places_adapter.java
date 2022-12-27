package com.example.master2java;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class places_adapter extends ArrayAdapter<places> {
    private Context mcon;
    private int myresource;


    public places_adapter(@NonNull Context context, int resource, @NonNull ArrayList<places> objects) {
        super(context, resource, objects);
        this.mcon = context;
        this.myresource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcon);
        convertView = layoutInflater.inflate(myresource, parent, false);

        ImageView imag = convertView.findViewById(R.id.image_place);
        TextView txt = convertView.findViewById(R.id.name_place);

        imag.setImageResource(getItem(position).getPlaceID());
        txt.setText(getItem(position).getName());


        return convertView;
    }
}
