package com.example.recycleview;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {


    public SignupFragment() {
        // Required empty public constructor
    }
    private TextView alreadyHaveAnAcount;
    private FrameLayout parentFrameLayout;

    private EditText email;
    private EditText fullName;
    private EditText pasword;
    private EditText confirmPasword;
    private ImageButton closeBtn;
    private Button signUpBtn;

    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    private FirebaseFirestore firebaseFirestore;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        parentFrameLayout= getActivity().findViewById(R.id.register_frame_Layout);

        alreadyHaveAnAcount = view.findViewById(R.id.already_have_an_Account);
        email = view.findViewById(R.id.sign_up_email);
        fullName=view.findViewById(R.id.sign_up_fullName);
        pasword=view.findViewById(R.id.sign_up_pasword);
        confirmPasword=view.findViewById(R.id.sign_up_confirmPasword);

       closeBtn= view.findViewById(R.id.sign_up_close_btn);

       signUpBtn=view.findViewById(R.id.sign_up_btn);

        progressBar=view.findViewById(R.id.sign_up_progressBar);

        firebaseAuth= FirebaseAuth.getInstance();

        firebaseFirestore = FirebaseFirestore.getInstance();
        progressBar.setVisibility(View.INVISIBLE);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyHaveAnAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SigninFragment());
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(),RegesterActivity.class);
                startActivity(mainIntent);
                getActivity().finish();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        fullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        pasword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        confirmPasword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPasword();
            }
        });
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs(){
        if(!TextUtils.isEmpty(email.getText())){
           if(!TextUtils.isEmpty(fullName.getText())){
               if(!TextUtils.isEmpty(pasword.getText()) && pasword.length()>=8){
                   if(!TextUtils.isEmpty(confirmPasword.getText())){
                       signUpBtn.setEnabled(true);

                   }else {
                       signUpBtn.setEnabled(false);
                   }

               }else{
                   signUpBtn.setEnabled(false);
               }
           }else {
               signUpBtn.setEnabled(false);
           }
        }else {
            signUpBtn.setEnabled(false);
        }
    }
    private void checkEmailAndPasword(){

        Drawable customErrorIcon = getResources().getDrawable(R.mipmap.warning);

        customErrorIcon.setBounds(0,0,customErrorIcon.getIntrinsicWidth(),customErrorIcon.getIntrinsicHeight());

        if (email.getText().toString().matches(emailPattern)) {
            if (pasword.getText().toString().equals(confirmPasword.getText().toString())) {

                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),pasword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                               if(task.isSuccessful()){
                                   Map<Object,String> userdata = new HashMap<>();
                                   userdata.put("fullname",fullName.getText().toString());
                                   //upload in firebase with following line
                                   firebaseFirestore.collection("USERS").add(userdata).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                       @Override
                                       public void onComplete(@NonNull Task<DocumentReference> task) {
                                           if(task.isSuccessful())
                                           {
                                               Intent mainIntent = new Intent(getActivity(),RegesterActivity.class);
                                               startActivity(mainIntent);
                                               getActivity().finish();
                                           }
                                           else
                                           {
                                               String error = task.getException().getMessage();
                                               Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                           }
                                       }
                                   });


                               }else {
                                   String error = task.getException().getMessage();
                                   Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                               }
                            }
                        });

            }else {
                confirmPasword.setError("Password doesn't matched!",customErrorIcon);
            }
        }else{

            email.setError("Invalid Email!",customErrorIcon);
        }
    }
    private void mainIntent(){
        Intent mainIntent = new Intent(getActivity(),tajmal_Testing.class);
        startActivity(mainIntent);
        getActivity().finish();

    }

}