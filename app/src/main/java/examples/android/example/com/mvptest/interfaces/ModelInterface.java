package examples.android.example.com.mvptest.interfaces;

import java.io.IOException;
import examples.android.example.com.mvptest.JSON;
import examples.android.example.com.mvptest.models.OnFinish;


public interface ModelInterface {

    void getData(OnFinish<JSON> callback) throws IOException;

}
