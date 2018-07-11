package deepanshu.example.com.mynote.main.login;

import com.squareup.otto.Subscribe;

import deepanshu.example.com.mynote.GoogleSignInIntentCall;
import deepanshu.example.com.mynote.base.BasePresenter;
import deepanshu.example.com.mynote.events.LoginEvent;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public class LoginPresenter extends BasePresenter<LoginView,LoginModel>{

    LoginPresenter(LoginView mView, LoginModel mModel) {
        super(mView, mModel);
    }


    @Subscribe
    public void onUserAlreadySignIn(LoginEvent.OnUserAlreadySignIn userAlreadySignIn){
        getModel().checkUserAlreadySignIn();
    }

    @Subscribe
    public void onGoogleSignInClicked(LoginEvent.OnGoogleSignInClicked googleSignInClicked){
        LoginActivity activity = getView().getActivity();
        if(activity != null) {
            GoogleSignInIntentCall.startGoogleSignInActivity(activity);
            getModel().googleSignIn(GoogleSignInIntentCall.getData1());
        }
    }



    @Subscribe
    public void onGoogleSignInStarted(LoginEvent.OnGoogleSignInStarted googleSignInStarted){
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