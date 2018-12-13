package basic.LearningAndroid;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import basic.LearningAndroid.utils.PublicMethods;
import basic.LearningAndroid.yahoo.ForecastsListAdapter;
import basic.LearningAndroid.yahoo.models.YahooModel;
import cz.msebera.android.httpclient.Header;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnCameraIdleListener {

    private GoogleMap mMap;
    TextView location,temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        location=findViewById(R.id.location);
        temp=findViewById(R.id.temp);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng(35.7860519,51.3856745);
        mMap.addMarker(new MarkerOptions().position(home).title("Marker in home"));
         //Store these lat lng values somewhere. These should be constant.
        mMap.setOnCameraIdleListener(this);
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                home, 18);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.animateCamera(location);
    }

    void getWhetherByLocation(double lat, double lng)
    {
        String url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(SELECT%20woeid%20FROM%20geo.places%20%20WHERE%20text%3D%22("+lat+"%2C"+lng+")%22)%20and%20u%3D%22C%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                PublicMethods.toast(MapsActivity.this,"Failed");
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
                String tempValue=yahoo.getQuery().getResults().getChannel()
                        .getItem().getCondition().getTemp();
                String location=yahoo.getQuery().getResults().getChannel().getLocation()
                        .getCity();
                this.temp.setText(tempValue);
                this.location.setText(location);

            }
            else
            {
                PublicMethods.toast(this,"Failed to find result");
            }
        }
        catch(Exception e)
        {
            PublicMethods.toast(this,"Failed in parse data");
        }
    }
    @Override
    public void onCameraIdle() {
        double latitude=mMap.getCameraPosition().target.latitude;
        double longitude=mMap.getCameraPosition().target.longitude;
        getWhetherByLocation(latitude,longitude);
        //PublicMethods.toast(this    ,"lat" + latitude + "long" + longitude);
    }
}
