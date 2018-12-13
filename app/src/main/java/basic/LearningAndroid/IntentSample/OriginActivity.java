package basic.LearningAndroid.IntentSample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import basic.LearningAndroid.R;

public class OriginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username,family;
    Button showDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin2);
        bind();
    }
    void bind()
    {
        username=findViewById(R.id.username);
        family=findViewById(R.id.family);
        showDetails=findViewById(R.id.showDetails);
        showDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String usernameValue=username.getText().toString();
        String familyValue=family.getText().toString();
        Intent detIntent = new Intent(this,EndActivity.class);
        detIntent.putExtra("username", usernameValue);
        detIntent.putExtra("family",familyValue);
        detIntent.putExtra("isIranian",true);
        detIntent.putExtra("age",45);
        startActivity(detIntent);
    }
}
