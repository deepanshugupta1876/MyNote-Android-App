package deepanshu.example.com.mynote.main.login;

import android.content.Intent;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.common.SignInButton;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.OnClick;
import deepanshu.example.com.mynote.R;
import deepanshu.example.com.mynote.base.BaseView;
import deepanshu.example.com.mynote.events.LoginEvent;
import deepanshu.example.com.mynote.main.my_note.MyNoteActivity;

/**
 * Created by Deepanshu on 11-07-2018.
 */

class LoginView extends BaseView<LoginActivity> {

    @BindView(R.id.googleSignIn)
    SignInButton googleSignInButton;

    LoginView(LoginActivity activity, Bus bus) {
        super(activity, bus);
    }

    void navigateToMainScreen() {
        LoginActivity activity = getActivity();

        if (activity != null) {
            Intent loginIntent = new Intent(activity, MyNoteActivity.class);
            activity.startActivity(loginIntent);
        }
    }

    void displayErrorMessage(String message) {
        LoginActivity activity = getActivity();

        if (activity == null) {
            return;
        }

        Toast.makeText(activity.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    void displaySuccessMessage(String message) {
        LoginActivity activity = getActivity();

        if (activity == null) {
            return;
        }

        Toast.makeText(activity.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.googleSignIn)
    void onGoogleSignInClicked() {
        bus.post(new LoginEvent.OnGoogleSignInClicked());
    }


}