package com.example.master2java;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link first#newInstance} factory method to
 * create an instance of this fragment.
 */
public class first extends Fragment /*implements AdapterView.OnItemClickListener*/ {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


Dialog md ;

    public first() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment first.
     */
    // TODO: Rename and change types and number of parameters
    public static first newInstance(String param1, String param2) {
        first fragment = new first();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }


    String[] data={"first place" ,"second place" ,"third place"};
    int[] data2= {R.mipmap.annaba, R.mipmap.constatine2};
    View fragmentView ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_first, container, false);



        ListView listView = (ListView)view.findViewById(R.id.listt);
       ArrayList<places> arrayList = new ArrayList<>() ;
       arrayList.add(new places(R.mipmap.constantine,"this is constantine"));
        arrayList.add(new places(R.mipmap.oran,"this is Oran"));
        arrayList.add(new places(R.mipmap.annaba,"this is Annnobi"));
        arrayList.add(new places(R.mipmap.skikda,"this is Stroa"));



        places_adapter places_adapter = new places_adapter(getActivity(),R.layout.item_places, arrayList) ;
        listView.setAdapter(places_adapter);

        md = new Dialog(getContext()) ;

       // ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),R.layout.item_places,R.id.name_place,data);
       // listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position) {
                   case 0:
                       dialog dia = new dialog();
                       dia.show(getChildFragmentManager(), "mine");
                       break;
                   case 1 :
                       dialogg dia2 = new dialogg();
                       dia2.show(getChildFragmentManager(), "mine");
               }
                // int index = position ;

       // md.setContentView(R.layout.pop_layout);

               // Toast.makeText(getContext(),"Account is clicked" , Toast.LENGTH_SHORT).show();
                //  Toast.makeText(getApplicationContext(),"Selected places" +data[index], Toast.LENGTH_LONG).show();
            //      showpopup();


            }
        });
        return view ;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);


    }

    public void showpopup () {
  dialog d = new dialog();
d.show(getFragmentManager(),"example");

    }





}

