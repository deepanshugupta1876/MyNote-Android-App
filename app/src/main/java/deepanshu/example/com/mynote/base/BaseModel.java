package deepanshu.example.com.mynote.base;

import com.squareup.otto.Bus;

import deepanshu.example.com.mynote.network.NetworkService;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public abstract class BaseModel {

    protected Bus bus;

    protected NetworkService networkService;

    public BaseModel (Bus bus){
        this.bus = bus;
        networkService = NetworkService.getInstance();
    }

}