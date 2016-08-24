package com.nextzy.mrsmile.testadison.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nextzy.mrsmile.testadison.ActivityControl;
import com.nextzy.mrsmile.testadison.R;

public class ChoosePrice extends Fragment implements View.OnClickListener {

    private static final String MOBILE_KEY = "mobile";
    private static final String NETWORK_KEY = "network";
    private static final String PRICE_KEY = "price";

    private ActivityControl control;

    private Button btnBack;
    private Button btn10;
    private Button btn20;
    private Button btn30;
    private Button btn40;
    private Button btn50;
    private Button btn60;
    private Button btn100;
    private Button btn200;
    private Button btn500;

    public ChoosePrice() {
        // Required empty public constructor
    }

    public static ChoosePrice newInstance(String mobile, String network) {
        ChoosePrice fragment = new ChoosePrice();
        Bundle args = new Bundle();
        args.putString(MOBILE_KEY, mobile);
        args.putString(NETWORK_KEY, network);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_price, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnBack = (Button) view.findViewById(R.id.btnBack);

        btn10 = (Button) view.findViewById(R.id.btn10);
        btn20 = (Button) view.findViewById(R.id.btn20);
        btn30 = (Button) view.findViewById(R.id.btn30);
        btn40 = (Button) view.findViewById(R.id.btn40);
        btn50 = (Button) view.findViewById(R.id.btn50);
        btn60 = (Button) view.findViewById(R.id.btn60);
        btn100 = (Button) view.findViewById(R.id.btn100);
        btn200 = (Button) view.findViewById(R.id.btn200);
        btn500 = (Button) view.findViewById(R.id.btn500);

        btnBack.setOnClickListener(this);

        btn10.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn30.setOnClickListener(this);
        btn40.setOnClickListener(this);
        btn50.setOnClickListener(this);
        btn60.setOnClickListener(this);
        btn100.setOnClickListener(this);
        btn200.setOnClickListener(this);
        btn500.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnBack) {
            control.onBackPressed();
        } else {
            String price = "";

            if (view == btn10) {
                price = btn10.getText().toString();
            } else if (view == btn20) {
                price = btn20.getText().toString();
            } else if (view == btn30) {
                price = btn30.getText().toString();
            } else if (view == btn40) {
                price = btn40.getText().toString();
            } else if (view == btn50) {
                price = btn50.getText().toString();
            } else if (view == btn60) {
                price = btn60.getText().toString();
            } else if (view == btn100) {
                price = btn100.getText().toString();
            } else if (view == btn200) {
                price = btn200.getText().toString();
            } else if (view == btn500) {
                price = btn500.getText().toString();
            }

            control.addFragment(Display.newInstance(getArguments().getString(MOBILE_KEY), getArguments().getString(NETWORK_KEY), price));
        }
    }
}
