package com.example.babis.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.babis.herome.Activities.MainActivity;
import com.example.babis.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button accident,genetic,born,choose;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        born = (Button)view.findViewById(R.id.born_button);
        accident = (Button)view.findViewById(R.id.accident_button);
        genetic = (Button)view.findViewById(R.id.genetic_button);
        choose = (Button)view.findViewById(R.id.choose_button);

        accident.setOnClickListener(this);
        born.setOnClickListener(this);
        genetic.setOnClickListener(this);





        choose.setEnabled(false);
        choose.getBackground().setAlpha(128);  //128 means 50% transparent

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity =  (MainActivity)getActivity();
                mainActivity.loadPowerScreen();
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
        choose.setEnabled(true);
        choose.getBackground().setAlpha(255);

        accident.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        born.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.rocket,0,0,0);
        genetic.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.atomic,0,0,0);



        Button btn = (Button)v;
        int leftDrawable =0;


        if(btn == accident){
            leftDrawable  = R.drawable.lightning;
            MainActivity.howYouGotIt = "Accident";
        }else if(btn == born){
            MainActivity.howYouGotIt = "Born With It";
            leftDrawable = R.drawable.rocket;
        }else if(btn== genetic){
            MainActivity.howYouGotIt = "Genetic Mutation";
            leftDrawable = R.drawable.atomic;
        }
        MainActivity.imageHowYouGotIt = leftDrawable;
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
