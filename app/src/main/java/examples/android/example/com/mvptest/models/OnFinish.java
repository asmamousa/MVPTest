package examples.android.example.com.mvptest.models;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class OnFinish <T> implements Callback <T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful() && response.body() != null) {

            onResult(true, response.body());
        } else {
            onResult(false, null);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onResult(false, null);
    }

    public abstract void onResult(boolean isSuccess, T result);
}
