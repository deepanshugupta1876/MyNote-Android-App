package deepanshu.example.com.mynote.base;

import com.google.firebase.database.DatabaseReference;
import com.squareup.otto.Bus;

import deepanshu.example.com.mynote.firebase.FirebaseHelper;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public abstract class BaseModel {

    protected Bus bus;

    protected FirebaseHelper firebaseHelper;
    protected DatabaseReference myUserReference;

    public BaseModel (Bus bus){
        this.bus = bus;
        firebaseHelper = FirebaseHelper.getInstance();
        myUserReference = firebaseHelper.getMyUserReference();
    }

}