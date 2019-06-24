package examples.android.example.com.mvptest.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import examples.android.example.com.mvptest.interfaces.PresenterInterface;
import examples.android.example.com.mvptest.R;
import examples.android.example.com.mvptest.interfaces.ViewInterface;
import examples.android.example.com.mvptest.databinding.ActivityMainBinding;
import examples.android.example.com.mvptest.presenters.PresenterImp;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    ActivityMainBinding activityMainBinding;
    PresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        presenter=new PresenterImp(this);
        presenter.getDataFromModel();
    }

    @Override
    public void setViewData(String text) {

        activityMainBinding.text.setText(text);
    }
}
