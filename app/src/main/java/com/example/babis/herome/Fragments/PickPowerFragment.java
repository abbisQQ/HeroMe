package com.example.babis.herome.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.babis.herome.Activities.BackStory;
import com.example.babis.herome.Activities.MainActivity;
import com.example.babis.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private Button turtleBtn,lightingBtn,flightBtn,webBtn,laserBtn,backstoryBtn;




    private OnFragmentInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view  =  inflater.inflate(R.layout.fragment_pick_power, container, false);

        laserBtn = (Button)view.findViewById(R.id.laser_button);
        turtleBtn = (Button)view.findViewById(R.id.turtle_button);
        flightBtn = (Button)view.findViewById(R.id.flight_button);
        lightingBtn = (Button)view.findViewById(R.id.lightning_button);
        webBtn = (Button)view.findViewById(R.id.web_button);
        backstoryBtn = (Button)view.findViewById(R.id.backstory_button);


        turtleBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtlepower,0,R.drawable.nothing,0);
        lightingBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.thorshammer,0,R.drawable.nothing,0);
        flightBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.supermancrest,0,R.drawable.nothing,0);
        webBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spiderweb,0,R.drawable.nothing,0);
        laserBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laservision,0,R.drawable.nothing,0);



        laserBtn.setOnClickListener(this);
        turtleBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        lightingBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);

        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128);  //128 means 50% transparent


        backstoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadBackstoryScreen();


            }
        });


        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtlepower,0,R.drawable.nothing,0);
        lightingBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.thorshammer,0,R.drawable.nothing,0);
        flightBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.supermancrest,0,R.drawable.nothing,0);
        webBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spiderweb,0,R.drawable.nothing,0);
        laserBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laservision,0,R.drawable.nothing,0);


        Button btn = (Button)v;
        int leftDrawable =0;


        if(btn == turtleBtn){
            leftDrawable  = R.drawable.turtlepower;
            MainActivity.primaryPower = "Turtle Power";
            MainActivity.name = "Hulk";

        }else if(btn == lightingBtn){
            leftDrawable = R.drawable.thorshammer;
            MainActivity.primaryPower = "Lightning";
            MainActivity.name = "Thor";
        }else if(btn== flightBtn){
            leftDrawable = R.drawable.supermancrest;
            MainActivity.primaryPower = "Flight";
            MainActivity.name = "Superman";
         }else if(btn == webBtn ){
        leftDrawable = R.drawable.spiderweb;
            MainActivity.primaryPower = "Web Slinging";
            MainActivity.name = "Spiderman";
            }else if(btn== laserBtn){
        leftDrawable = R.drawable.laservision;
            MainActivity.primaryPower = "Laser Vision";
            MainActivity.name = "Cyclops";
    }
        MainActivity.imagePrimaryPower = leftDrawable;
        btn.setCompoundDrawablesRelativeWithIntrinsicBounds(leftDrawable,0,R.drawable.itemselected,0);



    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
