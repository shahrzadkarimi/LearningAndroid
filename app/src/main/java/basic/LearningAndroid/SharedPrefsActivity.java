package basic.LearningAndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import basic.LearningAndroid.utils.BaseActivity;
import basic.LearningAndroid.utils.PublicMethods;

public class SharedPrefsActivity extends BaseActivity implements View.OnClickListener {

    EditText username,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);
        bind();
       loadData();
    }
    public void bind()
    {
        username=findViewById(R.id.username);
        mobile=findViewById(R.id.mobile);
        findViewById(R.id.save).setOnClickListener(this);
    }
   void loadData()
    {
        //String defU=PreferenceManager.getDefaultSharedPreferences(this)
        //        .getString("username","");
        //String defM=PreferenceManager.getDefaultSharedPreferences(this)
        //        .getString("mobile","");
        String defU=PublicMethods.getData(this,"username","");
        String defM=PublicMethods.getData(this,"mobile","");
        if(defU.length()>0)
            username.setText(defU);
        if(defM.length()>0)
            mobile.setText(defM);
    }

    @Override
    public void onClick(View view) {
        String uValue=username.getText().toString();
        String mValue=mobile.getText().toString();
        //PreferenceManager.getDefaultSharedPreferences(this).edit()
        //        .putString("username", uValue).apply();
        //PreferenceManager.getDefaultSharedPreferences(this).edit()
        //        .putString("mobile", mValue).apply();
        PublicMethods.saveData(this,"username",uValue);
        PublicMethods.saveData(this,"mobile",mValue);
        username.setText("");
        mobile.setText("");
        Toast.makeText(this, "Data saved successfully.", Toast.LENGTH_SHORT).show();
    }
}
