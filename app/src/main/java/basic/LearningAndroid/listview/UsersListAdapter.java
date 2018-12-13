package basic.LearningAndroid.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import basic.LearningAndroid.R;

public class UsersListAdapter extends BaseAdapter {
    Context mContext;
    String names[];

    public UsersListAdapter(Context mContext, String[] names) {
        this.mContext = mContext;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.users_list_item,viewGroup,false);
        TextView name= v.findViewById(R.id.name);
        name.setText(names[position]);

        return v;
    }
}
