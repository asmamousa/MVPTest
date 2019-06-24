package examples.android.example.com.mvptest.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import examples.android.example.com.mvptest.interfaces.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitRequest {

    private ApiService apiService;
    private static RetrofitRequest instance=null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private RetrofitRequest() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build(); //logging

        String ROOT_URL = "https://gist.githubusercontent.com/asmamousa/6fdaf4ba449b732af829e2f394cd55ae/raw/b8a7c1bd1a82dda500e1687b45cf7f3740565698/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiService.class);

    }

   static RetrofitRequest getInstance(){

        if(instance==null){
            instance=new RetrofitRequest();
        }

        return instance;
    }

    ApiService getApiService() {
        return apiService;
    }
}
