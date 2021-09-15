package com.airmoll.airfood.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airmoll.airfood.LoginActivity;
import com.airmoll.airfood.MainActivity;
import com.airmoll.airfood.R;
import com.airmoll.airfood.databinding.FragmentMoreBinding;

public class MoreFragment extends Fragment {


    private FragmentMoreBinding binding;
    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(getLayoutInflater(),container,false);
        View v = binding.getRoot();

        binding.moreSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });
        return v;
    }

    private void goToLogin()
    {

    }
}