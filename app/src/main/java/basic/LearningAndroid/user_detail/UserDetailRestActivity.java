package basic.LearningAndroid.user_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import basic.LearningAndroid.R;
import basic.LearningAndroid.utils.BaseActivity;
import basic.LearningAndroid.utils.PublicMethods;
import cz.msebera.android.httpclient.Header;

public class UserDetailRestActivity extends BaseActivity {
    TextView ip,city,country,isp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail_rest);
        bind();
        load();
    }
    void load()
    {
        AsyncHttpClient client=new AsyncHttpClient();
        client.get("http://ip-api.com/json", new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                PublicMethods.toast(mContext,"Error in receiving Data");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                parseAndShowResult(responseString);
            }
        });
    }

    void parseAndShowResult(String response) {

        try{
        JSONObject js=new JSONObject(response);
        }
        catch (Exception ex)
        {
            PublicMethods.toast(mContext,"Error");
        }
    }
    void bind()
    {
        ip=findViewById(R.id.ip);
        city=findViewById(R.id.city);
        country=findViewById(R.id.country);
        isp=findViewById(R.id.isp);
    }
}
