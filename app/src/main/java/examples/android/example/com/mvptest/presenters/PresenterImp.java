package examples.android.example.com.mvptest.presenters;

import java.io.IOException;
import java.lang.reflect.Type;

import examples.android.example.com.mvptest.JSON;
import examples.android.example.com.mvptest.interfaces.PresenterInterface;
import examples.android.example.com.mvptest.interfaces.ViewInterface;
import examples.android.example.com.mvptest.interfaces.ModelInterface;
import examples.android.example.com.mvptest.models.MyModel;
import examples.android.example.com.mvptest.models.OnFinish;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterImp implements PresenterInterface {


   private ViewInterface view;
    private String text;


    public PresenterImp (ViewInterface view){

        this.view=view;

    }

    @Override
    public void getDataFromModel() throws IOException {

        ModelInterface model = new MyModel();


       model.getData(new OnFinish<JSON>() {
           @Override
           public void onResult(boolean isSuccess, JSON result) {

               if(isSuccess){

                   view.setViewData(result.getText());
               }

               else {
                   view.setViewData(null);
               }

           }
       });




    }


}
