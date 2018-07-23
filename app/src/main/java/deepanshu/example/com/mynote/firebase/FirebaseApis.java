package deepanshu.example.com.mynote.firebase;

import android.view.GestureDetector;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public class FirebaseApis {

    private DatabaseReference databaseReference;
    private final static String SEPARATOR = "__";
    private final static String NOTE_PATH = "notes";
    private final static String USER_PATH = "users";

    private static FirebaseApis mInstance;

    public static FirebaseApis getInstance() {
        if (mInstance == null) {
            mInstance = new FirebaseApis();
        }
        return mInstance;
    }

    public FirebaseApis () {
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getDatabaseReference(){
        return databaseReference;
    }

    public String getAuthUserEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = null;
        if(user != null) {
            email = user.getEmail();
        }

        return email;
    }

    public DatabaseReference getUserReference(String  email) {
        DatabaseReference userReference = null;
        if(email != null) {
            String emailKey =email.replace(".","_");
            userReference = databaseReference.getRoot().child(USER_PATH).child(emailKey);
        }
        return userReference;
    }

    public DatabaseReference getMyUserReference() {
        return getUserReference(getAuthUserEmail());
    }
}
