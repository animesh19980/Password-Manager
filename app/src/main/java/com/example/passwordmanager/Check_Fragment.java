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

import java.util.Arrays;
import java.util.List;


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
                    return;
                }

                List<String> forbiddenPasswords = Arrays.asList("Password@012","Password@123","Password@234","Password@345","Password@456","Password@567","Password@678","Password@789","Password@890","Love!234","Summer21","Hello!45","Pizza!123","Coffee#1","Friend$7","Choco#8t","Beach!7s","Winter#68","Sport$45","Dream!21","T3aT!m34","Flower$6","Star!789","Golden#4","Mount#45","Fishes$2","Light#67","Play!m8","Read!n#2","Corn#789","Rain$567","Moon!345","Song$123","Wind#678","Bard$234","Joker#56","Film$234","Drink#78","Plant$12","Cat$!789","Ball#123","Party$67","Tree$!89","Cake$456","Milk#!23","Dog$#567","Lamp!890","Book#234","Farm$678","Toy$!123","Soap$!67","Gift$#89","Fox$!234","Hot#5678","Pool!123","Bird$!90");

                for (String forbiddenPassword : forbiddenPasswords) {
                    if (password.equals(forbiddenPassword)) {
                        PasswordError.setVisibility(View.VISIBLE);
                        return;
                    }
                }

                checkdone.setVisibility(View.VISIBLE);
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