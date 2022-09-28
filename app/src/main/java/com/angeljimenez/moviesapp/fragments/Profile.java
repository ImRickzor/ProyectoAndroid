package com.angeljimenez.moviesapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.angeljimenez.moviesapp.ExploreActivity;
import com.angeljimenez.moviesapp.R;
import com.angeljimenez.moviesapp.databinding.FragmentProfileBinding;

public class Profile extends Fragment implements View.OnClickListener {
    FragmentProfileBinding binding;
    public Profile(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentProfileBinding.inflate(inflater,container, false);
        binding.rbOrdenar1.setOnClickListener(this);

        binding.rbOrdenar1.setChecked(true);
        mostrarOrdenar1();
        return binding.getRoot();

    }

    @Override
    public void onClick(View view) {
        mostrarOrdenar2();

    }

    private void mostrarOrdenar2() {
        VistaPelis2Fragment VistaPelis2Fragment = new VistaPelis2Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorPelis, VistaPelis2Fragment);
        transaction.commit();
    }

    private void mostrarOrdenar1() {
        VistaPelisProfileFragment VistaPelisProfileFragment = new VistaPelisProfileFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorPelis, VistaPelisProfileFragment);
        transaction.commit();
    }




}