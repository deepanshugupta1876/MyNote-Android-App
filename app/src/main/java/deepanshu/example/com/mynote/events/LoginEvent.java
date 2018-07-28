package deepanshu.example.com.mynote.events;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import deepanshu.example.com.mynote.main.login.LoginActivity;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public class LoginEvent {

    public static class OnUserAlreadySignIn {

    }

    public static class OnGoogleSignInClicked {

    }

    public static class OnGoogleSignInStarted {
        public GoogleSignInResult result;

        public OnGoogleSignInStarted(GoogleSignInResult result) {
            this.result = result;
        }
    }

    public static class OnGoogleSignInFailed {
        public String errorMessage;

        public OnGoogleSignInFailed(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

    public static class OnGoogleSignInSuccess {
        public String successMessage;

        public OnGoogleSignInSuccess(String successMessage) {
            this.successMessage = successMessage;
        }
    }
}
