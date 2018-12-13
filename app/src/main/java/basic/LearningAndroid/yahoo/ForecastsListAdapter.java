package basic.LearningAndroid.yahoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import basic.LearningAndroid.R;
import basic.LearningAndroid.yahoo.models.Forecast;

public class ForecastsListAdapter extends BaseAdapter {
    Context mContext;
    List<Forecast> forecasts;

    public ForecastsListAdapter(Context mContext, List<Forecast> forecasts) {
        this.mContext = mContext;
        this.forecasts = forecasts;
    }

    @Override
    public int getCount() {
        return forecasts.size();
    }

    @Override
    public Object getItem(int i) {
        return forecasts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v=LayoutInflater.from(mContext)
                .inflate(R.layout.forecasts_list_item,viewGroup,false);

        TextView date=v.findViewById(R.id.date);
        TextView status=v.findViewById(R.id.status);
        TextView min=v.findViewById(R.id.min);
        TextView max=v.findViewById(R.id.max);
        ImageView icon=v.findViewById(R.id.icon);


        Forecast currentData=forecasts.get(i);
        date.setText(currentData.getDate());
        status.setText(currentData.getText());
        min.setText(currentData.getHigh());
        max.setText(currentData.getLow());

        String img="https://cdn2.iconfinder.com/data/icons/weather-color-2/500/weather-01-512.png";

        if(!currentData.getText().toLowerCase().contains("sunny"))
            img="https://cdn0.iconfinder.com/data/icons/citycons/150/Citycons_sunny-512.png";
        Glide.with(mContext).load(img).into(icon);

        return v;
    }
}
