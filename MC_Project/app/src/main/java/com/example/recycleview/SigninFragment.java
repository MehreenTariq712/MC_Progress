package com.example.recycleview;


import android.content.Intent;
import android.os.Bundle;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.recycleview.RegesterActivity.onResetPaswordFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SigninFragment extends Fragment {


    public SigninFragment() {
        // Required empty public constructor
    }

    private TextView dontHaveAnAcount;
    private FrameLayout parentFrameLayout;

    private EditText email;
    private EditText pasward;

    private ImageButton closeBtn;
    private Button signInBtn;

    private FirebaseAuth firebaseAuth;

    private ProgressBar progressBar;

    private TextView forgotPassword;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signin, container, false);
        dontHaveAnAcount = view.findViewById(R.id.tv_dont_have_an_account);
        parentFrameLayout= getActivity().findViewById(R.id.register_frame_Layout);

        email = view.findViewById(R.id.sign_in_email);
        pasward = view.findViewById(R.id.sign_in_pasward);
        progressBar = view.findViewById(R.id.sign_in_progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        signInBtn = view.findViewById(R.id.sign_btn);
        closeBtn= view.findViewById(R.id.cross_btn);
        forgotPassword = view.findViewById(R.id.sign_in_forgot_pasword);

        firebaseAuth= FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dontHaveAnAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignupFragment());
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetPaswordFragment = true;
                setFragment(new reset_pasward_fragment());
            }
        });


        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(),MainActivity.class);
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
        pasward.addTextChangedListener(new TextWatcher() {
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

        signInBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkEmailAndPasword();
            }
        });

    }



    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }


    private void checkInputs() {
        if(!TextUtils.isEmpty(email.getText())){
            if(!TextUtils.isEmpty(pasward.getText())){

            }else{

            }


        }else{

        }

    }

    private void checkEmailAndPasword() {
        if(email.getText().toString().matches(emailPattern)){
            if(pasward.length()>= 8){

                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),pasward.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){

                                    Intent mainIntent = new Intent(getActivity(),MainActivity.class);
                                    startActivity(mainIntent);
                                    getActivity().finish();

                                }else {
                                   progressBar.setVisibility(View.INVISIBLE);
                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                progressBar.setVisibility(View.INVISIBLE);
            }else{

                Toast.makeText(getActivity(), "Incorrect email or password!",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getActivity(), "Incorrect email or password!",Toast.LENGTH_SHORT).show();
        }

    }


}
