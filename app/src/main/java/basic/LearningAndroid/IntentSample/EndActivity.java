package basic.LearningAndroid.IntentSample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import basic.LearningAndroid.R;

public class EndActivity extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        result=findViewById(R.id.result);
        String username=getIntent().getStringExtra("username");
        String family=getIntent().getStringExtra("family");
        boolean isIR=getIntent().getBooleanExtra("isIranian", true);
        int age=getIntent().getIntExtra("age", 0);
        result.setText(username+ " " + family + " " + age + " " + isIR);
    }
}
