package deepanshu.example.com.mynote.base;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Bus;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;


/**
 * Created by Deepanshu on 09-07-2018.
 */

public abstract class BaseView<T extends AppCompatActivity> {

    protected Bus bus;
    private WeakReference<T> activityRef;

    public BaseView(T activity, Bus bus) {
        ButterKnife.bind(this,activity);
        this.bus = bus;
        this.activityRef = new WeakReference<T>(activity);
    }

    @Nullable
    public T getActivity(){
        return activityRef.get();
    }

}
