package examples.android.example.com.mvptest.interfaces;

import examples.android.example.com.mvptest.JSON;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    @GET("MVPTest")
    Call<JSON> getJsonData();

}

