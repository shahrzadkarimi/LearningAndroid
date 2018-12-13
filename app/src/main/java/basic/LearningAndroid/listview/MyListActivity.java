package basic.LearningAndroid.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import basic.LearningAndroid.R;
import basic.LearningAndroid.utils.BaseActivity;
import basic.LearningAndroid.utils.PublicMethods;

public class MyListActivity extends BaseActivity {

    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        myList=findViewById(R.id.myList);
        String names[]={
                "Ali",
                "Shahab",
                "Amin",
                "Reza",
                "Sara",
                "Shahrzad",
                "Rozita",
        };
        UsersListAdapter adapter=new UsersListAdapter(mContext,names);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                PublicMethods.toast(mContext,"Item number:" + position);
            }
        });
    }
}
