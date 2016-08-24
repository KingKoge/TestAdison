package com.nextzy.mrsmile.testadison.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nextzy.mrsmile.testadison.ActivityControl;
import com.nextzy.mrsmile.testadison.MainActivity;
import com.nextzy.mrsmile.testadison.R;

public class Display extends Fragment implements View.OnClickListener {

    private ActivityControl control;

    private static final String MOBILE_KEY = "mobile";
    private static final String NETWORK_KEY = "network";
    private static final String PRICE_KEY = "price";

    private TextView tvMobile;
    private TextView tvNetwork;
    private TextView tvPrice;

    private Button btnOK;

    public Display() {
        // Required empty public constructor
    }

    public static Display newInstance(String mobile, String network, String price) {
        Display fragment = new Display();
        Bundle args = new Bundle();
        args.putString(MOBILE_KEY, mobile);
        args.putString(NETWORK_KEY, network);
        args.putString(PRICE_KEY, price);
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
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvMobile = (TextView) view.findViewById(R.id.tvMobile);
        tvNetwork = (TextView) view.findViewById(R.id.tvNetwork);
        tvPrice = (TextView) view.findViewById(R.id.tvPrice);

        btnOK = (Button) view.findViewById(R.id.btnOk);

        btnOK.setOnClickListener(this);

        tvMobile.setText(getArguments().getString(MOBILE_KEY));
        tvNetwork.setText(getArguments().getString(NETWORK_KEY));
        tvPrice.setText(getArguments().getString(PRICE_KEY));
    }

    @Override
    public void onClick(View view) {
        if (view == btnOK) {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
            control.finishThis();
        }
    }
}
