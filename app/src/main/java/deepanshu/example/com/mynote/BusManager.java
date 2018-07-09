package deepanshu.example.com.mynote;

import com.squareup.otto.Bus;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public class BusManager {
    private Bus bus;
    private static volatile BusManager instance = null;

    private BusManager(){
        bus = new Bus();
    }

    public static Bus getInstance(){
        if(instance == null) {
            synchronized (BusManager.class){
                if(instance == null) {
                    instance = new BusManager();
                }
            }
        }
        return instance.getBus();
    }

    public Bus getBus(){
        return bus;
    }

}
