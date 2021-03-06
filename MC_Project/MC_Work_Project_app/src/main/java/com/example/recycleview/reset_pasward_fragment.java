package com.example.recycleview;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class reset_pasward_fragment extends Fragment {


    public reset_pasward_fragment() {
        // Required empty public constructor
    }

    private EditText registeredEmail;
    private Button resetPasswordBtn;
    private TextView goBack;

    private FrameLayout parentFrameLayout;

    private ViewGroup emailIconContainer;
    private ImageView emailIcon;
    private TextView emailIconText;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reset_pasward_fragment, container, false);

        registeredEmail = view.findViewById(R.id.forgot_password_email);
        resetPasswordBtn= view.findViewById(R.id.reset_password_btn);
        goBack = view.findViewById(R.id.tv_forgot_pasword_goback);

        parentFrameLayout = getActivity().findViewById(R.id.register_frame_Layout);

        emailIconContainer = view.findViewById(R.id.forgot_password_email_Icon_container);
        emailIcon = view.findViewById(R.id.forgot_password_email_Icon);
        emailIconText = view.findViewById(R.id.forgot_password_email_Icon_text);
        progressBar = view.findViewById(R.id.forgot_password_progress_bar);

        firebaseAuth = FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registeredEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checksInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(emailIconContainer);
                emailIconText.setVisibility(View.GONE);

                TransitionManager.beginDelayedTransition(emailIconContainer);
                emailIcon.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                resetPasswordBtn.setEnabled(true);
                resetPasswordBtn.setTextColor(Color.rgb(255,255,255));

                firebaseAuth.sendPasswordResetEmail(registeredEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                             if (task.isSuccessful()){
                                Toast.makeText(getActivity(),"Email sent successfully!",Toast.LENGTH_LONG).show();

                             }else{

                                 String error = task.getException().getMessage();


                                 emailIconText.setText(error);
                                 emailIconText.setTextColor(getResources().getColor(R.color.colorPrimary));
                                 TransitionManager.beginDelayedTransition(emailIconContainer);
                                 emailIconText.setVisibility(View.VISIBLE);


                             }
                                progressBar.setVisibility(View.GONE);
                                registeredEmail.setEnabled(true);
                                resetPasswordBtn.setTextColor(Color.rgb(255,255,255));

                            }
                        });
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SigninFragment());
            }
        });


    }
    private void checksInputs(){
        if(TextUtils.isEmpty(registeredEmail.getText())){
            registeredEmail.setEnabled(false);
            resetPasswordBtn.setTextColor(Color.argb(50,255,255,255));

        }else{

            registeredEmail.setEnabled(true);
            resetPasswordBtn.setTextColor(Color.rgb(255,255,255));
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
