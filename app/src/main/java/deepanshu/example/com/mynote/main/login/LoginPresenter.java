package deepanshu.example.com.mynote.main.login;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.UserInfo;
import com.squareup.otto.Subscribe;

import deepanshu.example.com.mynote.GoogleSignInIntentCall;
import deepanshu.example.com.mynote.base.BaseActivity;
import deepanshu.example.com.mynote.base.BasePresenter;
import deepanshu.example.com.mynote.events.LoginEvent;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public class LoginPresenter extends BasePresenter<LoginView,LoginModel>{
    static final int RC_SIGN_IN = 3;
    private LoginActivity activity = getView().getActivity();

    LoginPresenter(LoginView mView, LoginModel mModel) {
        super(mView, mModel);
    }


    @Subscribe
    public void onUserAlreadySignIn(LoginEvent.OnUserAlreadySignIn userAlreadySignIn){
        getModel().checkUserAlreadySignIn();

    }

    @Subscribe
    public void onGoogleSignInClicked(LoginEvent.OnGoogleSignInClicked googleSignInClicked){

        if(activity != null) {
            Intent intent = loginWithGoogle(activity);
            activity.startActivityForResult(intent,RC_SIGN_IN);
        }
    }

    private Intent loginWithGoogle(LoginActivity activity) {return GoogleSignInIntentCall.startGoogleSignInActivity(activity);}

//    public static void getAuthWithGoogle(GoogleSignInResult result, final BaseActivity activity) {
//        if(result.isSuccess()) {
//            try {
//                final GoogleSignInAccount acct = result.getSignInAccount();
//                GoogleSignInIntentCall.getAuthWithGoogle(acct)
//                        .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//
//                                if (task.isSuccessful()) {
//                                    for (UserInfo profile : task.getResult().getUser().getProviderData()) {
//                                        String providerId = profile.getProviderId();
//                                        String uid = profile.getUid();
//                                        String name = profile.getDisplayName();
//                                        String email = profile.getEmail();
//                                        Uri photoUri = profile.getPhotoUrl();
//                                        Log.d("fisache", providerId + " " + uid + " " + name + " " + email + " " + photoUri);
//                                    }
//                                } else {
//                                    Log.d("fisache", "failed");
//                                }
//                            }
//                        });
//            }catch (Exception ex){
//                Log.d("errorzzzzz", ex.getMessage());
//            }
//        } else {
//            Log.d("fisache", "failed");
//        }
//    }

    @Subscribe
    public void onGoogleSignInStarted(LoginEvent.OnGoogleSignInStarted googleSignInStarted){
        getModel().googleSignin(googleSignInStarted.result);
    }

    @Subscribe
    public void onGoogleSignInSuccess(LoginEvent.OnGoogleSignInSuccess googleSignInSuccess){
        getView().displaySuccessMessage(googleSignInSuccess.successMessage);
        getView().navigateToMainScreen();
    }

    @Subscribe
    public void onGoogleSignInFailed(LoginEvent.OnGoogleSignInFailed googleSignInFailed){
        getView().displayErrorMessage(googleSignInFailed.errorMessage);
    }
}