package deepanshu.example.com.mynote.base;

import com.squareup.otto.Bus;

import deepanshu.example.com.mynote.firebase.FirebaseApis;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public abstract class BaseModel {

    protected Bus bus;

    private FirebaseApis firebaseApis;

    public BaseModel (Bus bus){
        this.bus = bus;
        firebaseApis = FirebaseApis.getInstance();
    }

}