package com.nextzy.mrsmile.testadison.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.nextzy.mrsmile.testadison.ActivityControl;
import com.nextzy.mrsmile.testadison.R;


public class Mobile extends Fragment implements View.OnClickListener {

    private ActivityControl control;

    private Button btnSubmit;
    private EditText edtMobile;

    public Mobile() {
        // Required empty public constructor
    }

    public static Mobile newInstance() {
        Mobile fragment = new Mobile();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            control = (ActivityControl) getActivity();
        }

        if (getArguments() != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        edtMobile = (EditText) view.findViewById(R.id.edtMobile);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnSubmit) {
            control.addFragment(ChooseNetwork.newInstance(edtMobile.getText().toString()));
        }
    }

    private boolean checkInput() {
        return edtMobile.getText().toString().isEmpty();
    }
}
