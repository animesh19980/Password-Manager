package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Check_Fragment extends Fragment {
    private EditText etPassword;
    private TextView tvPasswordError, checkdone, PasswordError;
    private CardView btnRegister;
    private CardView frameOne, frameTwo, frameThree, frameFour;
    private boolean isAtLeast8 = false, hasUppercase = false, hasNumber = false, hasSymbol = false, isRegistrationClickable = false;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_, container, false);

        tvPasswordError = view.findViewById(R.id.tvPasswordError);
        PasswordError = view.findViewById(R.id.PasswordError);
        etPassword = view.findViewById(R.id.etPassword);
        checkdone = view.findViewById(R.id.checkdone);
        btnRegister = view.findViewById(R.id.btnRegister);
        frameOne = view.findViewById(R.id.frameOne);
        frameTwo = view.findViewById(R.id.frameTwo);
        frameThree = view.findViewById(R.id.frameThree);
        frameFour = view.findViewById(R.id.frameFour);




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = etPassword.getText().toString();

                if (password.length() == 0) {
                    tvPasswordError.setVisibility(View.VISIBLE);
                } if (password.equals("098#@Black")) {
                    PasswordError.setVisibility(View.VISIBLE);
                } else {
                    checkdone.setVisibility(View.VISIBLE);
                }
            }
        });
        inputChange();
        return view;


    }

    private void checkEmpty(String password){
        if (password.length() > 0 && tvPasswordError.getVisibility() == View.VISIBLE) {
            tvPasswordError.setVisibility(View.GONE);
        }
    }

    @SuppressLint("ResourceType")
    private void scanCheck(){
        String password = etPassword.getText().toString();
        checkEmpty(password);

        if (password.length() >= 8) {
            isAtLeast8 = true;
            frameOne.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            isAtLeast8 = false;
            frameOne.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
        if (password.matches("(.*[A-Z].*)")) {
            hasUppercase = true;
            frameTwo.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            hasUppercase = false;
            frameTwo.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
        if (password.matches("(.*[0-9].*)")) {
            hasNumber = true;
            frameThree.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            hasNumber = false;
            frameThree.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
        if (password.matches("^(.*[?=_.()$#@%&*]).*")) {
            hasSymbol = true;
            frameFour.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            hasSymbol = false;
            frameFour.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
    }
     private  void inputChange(){
         etPassword.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 scanCheck();
             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });
     }
}