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

public class ChooseNetwork extends Fragment implements View.OnClickListener {

    private static final String MOBILE_KEY = "mobile";

    private Button btnBack;
    private Button btnAis;
    private Button btnDtac;
    private Button btnTrue;

    private ActivityControl control;

    public ChooseNetwork() {
        // Required empty public constructor
    }

    public static ChooseNetwork newInstance(String mobile) {
        ChooseNetwork fragment = new ChooseNetwork();
        Bundle args = new Bundle();
        args.putString(MOBILE_KEY, mobile);
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
        return inflater.inflate(R.layout.fragment_choose_network, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnBack = (Button) view.findViewById(R.id.btnBack);
        btnAis = (Button) view.findViewById(R.id.btnAis);
        btnDtac = (Button) view.findViewById(R.id.btnDtac);
        btnTrue = (Button) view.findViewById(R.id.btnTrue);

        btnBack.setOnClickListener(this);
        btnAis.setOnClickListener(this);
        btnDtac.setOnClickListener(this);
        btnTrue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == btnBack) {
            control.onBackPressed();
        } else {
            String network = "";
            if (view == btnAis) {
                network = btnAis.getText().toString();
            } else if (view == btnDtac) {
                network = btnDtac.getText().toString();
            } else if (view == btnTrue) {
                network = btnTrue.getText().toString();
            }

            control.addFragment(ChoosePrice.newInstance(getArguments().getString(MOBILE_KEY), network));
        }
    }
}
