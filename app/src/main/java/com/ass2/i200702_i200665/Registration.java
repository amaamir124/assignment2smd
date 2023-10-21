package com.ass2.i200702_i200665;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class Registration extends AppCompatActivity {

    EditText editTextEmail , editTextPassword , editTextContact , editTextName;
    FirebaseAuth mAuth;

    DatabaseReference databaseReference;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(Registration.this, Profile.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("users");


        editTextEmail= findViewById(R.id.emailTextBox);
        editTextPassword=findViewById(R.id.passwordTextBox);
        editTextContact=findViewById(R.id.contactTextBox);
        editTextName=findViewById(R.id.nameTextBox);

        Button signUp = findViewById(R.id.signUpButton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password,contact,name;
                email= String.valueOf(editTextEmail.getText());
                password= String.valueOf(editTextPassword.getText());
                contact= String.valueOf(editTextContact.getText());
                name= String.valueOf(editTextName.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Registration.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Registration.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(Registration.this,"Enter Name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(contact)){
                    Toast.makeText(Registration.this,"Enter Contact Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Registration.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();
                                            FirebaseUser firebaseUse=FirebaseAuth.getInstance().getCurrentUser();
                                            UserModel userModel= new UserModel(FirebaseAuth.getInstance().getUid(),name,email,contact,password);
                                            databaseReference.child(FirebaseAuth.getInstance().getUid()).setValue(userModel);


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


                Intent intent = new Intent(Registration.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });


        TextView login = findViewById(R.id.loginBottomText);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
