package deepanshu.example.com.mynote.main.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.squareup.otto.Bus;

import java.util.concurrent.Executor;

import deepanshu.example.com.mynote.base.BaseModel;
import deepanshu.example.com.mynote.events.LoginEvent;

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
            bus.post(new LoginEvent.OnGoogleSignInSuccess("Login Successful"));
        }
    }

    void googleSignIn(Intent data) {
        mAuth = FirebaseAuth.getInstance();
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        handleSignInResult(task);
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            firebaseAuthWithGoogle(account);
        } catch (ApiException e) {
            Log.d(TAG, "signInResult:failed code=" + e.getStatusCode());
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

        AuthCredential authCredential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(authCredential)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in successMessage, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:successMessage");
                            FirebaseUser user = mAuth.getCurrentUser();
                            bus.post(new LoginEvent.OnGoogleSignInSuccess("Login Successful"));
                        } else {
                            // If sign in fails, display a message to the user.
                            bus.post(new LoginEvent.OnGoogleSignInFailed(task.getException().getMessage()));
                        }
                    }
                }
                );
    }
}