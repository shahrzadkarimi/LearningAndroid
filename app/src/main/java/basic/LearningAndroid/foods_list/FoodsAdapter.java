package basic.LearningAndroid.foods_list;

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

public class FoodsAdapter extends BaseAdapter {
    Context mContext;
    List<FoodModel> foods;

    public FoodsAdapter(Context mContext, List<FoodModel> foods) {
        this.mContext = mContext;
        this.foods = foods;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int position) {
        return foods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.foods_list_item,viewGroup,false);
        ImageView image=v.findViewById(R.id.image);
        TextView name=v.findViewById(R.id.name);
        TextView price=v.findViewById(R.id.price);

        name.setText(foods.get(position).getName());
        price.setText(foods.get(position).getPrice()+"");
        Glide.with(mContext).load(foods.get(position)
        .getImage()).into(image);
        return v;
    }
}
