package basic.LearningAndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DestinationActivity extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        result=findViewById(R.id.result);
        String username=getIntent().getStringExtra("username");
        String family=getIntent().getStringExtra("family");
        result.setText( username + " "+ family );
    }
    public static void main(String[] args)
    {
        System.out.println("hi form java");
    }
}
