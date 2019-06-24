package examples.android.example.com.mvptest.models;


import examples.android.example.com.mvptest.JSON;
import examples.android.example.com.mvptest.interfaces.ModelInterface;
import retrofit2.Call;


public class MyModel implements ModelInterface {


    @Override
    public void getData(OnFinish<JSON> callback) {

        Call<JSON> call = RetrofitRequest.getInstance().getApiService().getJsonData();
        call.enqueue(callback);

    }
}
