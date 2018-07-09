package deepanshu.example.com.mynote.network;

/**
 * Created by Deepanshu on 09-07-2018.
 */

public class NetworkService {
    private static NetworkService mInstance;

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }
}
