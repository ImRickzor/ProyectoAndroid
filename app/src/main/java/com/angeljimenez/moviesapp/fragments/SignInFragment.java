package com.angeljimenez.moviesapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.angeljimenez.moviesapp.Activities.ExploreActivity;
import com.angeljimenez.moviesapp.R;


public class SignInFragment extends Fragment{


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public SignInFragment() {

    }


    public static SignInFragment newInstance(String param1, String param2) {
        SignInFragment fragment = new SignInFragment();
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
    Context context; //Declare the variable context
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sign_in, container, false);


        // IMPORTANT THIS CODE IS FOR CALLING AN ACTIVITY FROM A FRAGMENT

            //Pass your layout xml to the inflater and assign it to rootView.
        View rootView = inflater.inflate(R.layout.fragment_sign_in, container, false);
            context = rootView.getContext(); // Assign your rootView to context

            Button btnSignUpFrag = (Button) rootView.findViewById(R.id.btnSignInFrag);
        btnSignUpFrag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent
                    Intent intent = new Intent(context, ExploreActivity.class);
                    startActivity(intent);
                }
            });
            return rootView;
        }
    }


