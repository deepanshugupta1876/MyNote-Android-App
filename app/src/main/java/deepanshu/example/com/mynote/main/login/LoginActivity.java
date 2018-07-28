package deepanshu.example.com.mynote.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import deepanshu.example.com.mynote.GoogleSignInIntentCall;
import deepanshu.example.com.mynote.R;
import deepanshu.example.com.mynote.base.BasePresenter;
import deepanshu.example.com.mynote.base.BasePresenterActivity;
import deepanshu.example.com.mynote.events.LoginEvent;

public class LoginActivity extends BasePresenterActivity {

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return new LoginPresenter(
                new LoginView(LoginActivity.this, bus),
                new LoginModel(bus)
        );
    }

    @NonNull
    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus.post(new LoginEvent.OnUserAlreadySignIn());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LoginPresenter.RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            bus.post(new LoginEvent.OnGoogleSignInStarted(result));
        }
    }
}