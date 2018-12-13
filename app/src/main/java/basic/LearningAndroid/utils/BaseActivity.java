package basic.LearningAndroid.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.orhanobut.hawk.Hawk;

public class BaseActivity extends AppCompatActivity {
    public Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        Hawk.init(this).build();
    }
}
