package deepanshu.example.com.mynote;

import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Deepanshu on 11-07-2018.
 */

public class GoogleSignInIntentCall {
    private static final int RC_SIGN_IN = 3;
    private static Intent data1;
    public static void startGoogleSignInActivity(Activity activity) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(activity, gso);
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public static void processResult(Intent data) {
        data1 = data;
    }

    public static Intent getData1() {
        return data1;
    }
}
