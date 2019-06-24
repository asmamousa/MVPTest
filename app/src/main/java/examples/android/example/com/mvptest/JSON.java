package examples.android.example.com.mvptest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSON {

    @SerializedName("test")
    @Expose
    private String text;


    public String getText() {
        return text;
    }
}
