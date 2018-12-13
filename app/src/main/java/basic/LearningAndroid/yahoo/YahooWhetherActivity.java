package basic.LearningAndroid.yahoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import basic.LearningAndroid.R;
import basic.LearningAndroid.utils.BaseActivity;
import basic.LearningAndroid.utils.PublicMethods;
import basic.LearningAndroid.yahoo.models.YahooModel;
import cz.msebera.android.httpclient.Header;

public class YahooWhetherActivity extends BaseActivity {

    TextView result;
    EditText city;
    ListView forecasts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yahoo_whether);
        bind();
    }
    void bind()
    {
        result=findViewById(R.id.result);
        city=findViewById(R.id.city);
        forecasts=findViewById(R.id.forecasts);
        findViewById(R.id.show).setOnClickListener(V->{
            getWhetherFromYahoo(city.getText().toString());
        });
    }

    private void getWhetherFromYahoo(String city) {
        AsyncHttpClient client=new AsyncHttpClient();
        String url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+city+"%2C%20ir%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                PublicMethods.toast(mContext,"Failed");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                parseAndLoadData(responseString);
            }
        });

    }
    private void parseAndLoadData(String response)
    {
        try
        {
            Gson gson=new Gson();
            YahooModel yahoo=gson.fromJson(response,YahooModel.class);
            if(yahoo.getQuery().getCount()==1)
            {
                String temp=yahoo.getQuery().getResults().getChannel()
                        .getItem().getCondition().getTemp();
                result.setText("temp is:"+temp+" F");

                ForecastsListAdapter adapter=new ForecastsListAdapter(
                        mContext,yahoo.getQuery().getResults().getChannel()
                        .getItem().getForecast()
                );
                forecasts.setAdapter(adapter);
            }
            else
                {
                  PublicMethods.toast(mContext,"Failed to find result");
                }
        }
        catch(Exception e)
        {
            PublicMethods.toast(mContext,"Failed in parse data");
        }
    }
}
