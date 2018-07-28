package deepanshu.example.com.mynote.main.login;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.squareup.otto.Bus;

import deepanshu.example.com.mynote.base.BaseModel;
import deepanshu.example.com.mynote.entities.User;
import deepanshu.example.com.mynote.events.LoginEvent;
import deepanshu.example.com.mynote.firebase.FirebaseHelper;

/**
 * Created by Deepanshu on 09-07-2018.
 */

class LoginModel extends BaseModel {

    private static final String TAG = "GoogleSignin";
    private FirebaseAuth mAuth;

    LoginModel(Bus bus) {
        super(bus);
    }

    void checkUserAlreadySignIn() {

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    initSignIn(dataSnapshot);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    bus.post(new LoginEvent.OnGoogleSignInFailed(databaseError.getMessage()));
                }
            });
        } else {
            bus.post(new LoginEvent.OnGoogleSignInFailed("Login Failed. Please Try Again"));
        }
    }

    private void initSignIn(DataSnapshot dataSnapshot) {
        User currentUser = dataSnapshot.getValue(User.class);
        if(currentUser == null) {
            registerNewUser();
        }
        bus.post(new LoginEvent.OnGoogleSignInSuccess("Login Successful"));
    }

    private void registerNewUser() {
        String email = firebaseHelper.getAuthUserEmail();
        if(email != null){
            FirebaseUser firebaseUser = firebaseHelper.getAuthUserDetail();
            User currentUser = new User(email,firebaseUser.getDisplayName(),firebaseUser.getPhotoUrl());
            myUserReference.setValue(currentUser);
        }
    }

    void googleSignin(GoogleSignInResult result){
        if(result.isSuccess()) {
                GoogleSignInAccount acct = result.getSignInAccount();
                mAuth = FirebaseAuth.getInstance();
                assert acct != null;
                AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
                mAuth.signInWithCredential(credential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            initSignIn(dataSnapshot);
                                            Log.d("check ","hurray");
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {
                                            bus.post(new LoginEvent.OnGoogleSignInFailed(databaseError.getMessage()));
                                        }
                                    });
                                } else {
                                    bus.post(new LoginEvent.OnGoogleSignInFailed(task.getException().getMessage()));
                                }
                            }
                        });
        } else {
            bus.post(new LoginEvent.OnGoogleSignInFailed("Login Failed. Please Try Again"));
        }
    }
}