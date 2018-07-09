package deepanshu.example.com.mynote.main;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.otto.Bus;

import deepanshu.example.com.mynote.base.BaseModel;
import deepanshu.example.com.mynote.events.LoginEvent;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public class LoginModel extends BaseModel {
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth auth;

    public LoginModel(Bus bus) {
        super(bus);
    }

    public void login(final String email, String password) {
        bus.post(new LoginEvent.OnLoginStarted());
    }

}
