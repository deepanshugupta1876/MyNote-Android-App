package deepanshu.example.com.mynote.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.squareup.otto.Bus;

import deepanshu.example.com.mynote.BusManager;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public abstract class BasePresenterActivity <T extends BasePresenter> extends BaseActivity {
    protected Bus bus = BusManager.getInstance();
    protected T mPresenter;

    @NonNull
    protected abstract T getPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusManager.getInstance().register(mPresenter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusManager.getInstance().unregister(mPresenter);
    }
}