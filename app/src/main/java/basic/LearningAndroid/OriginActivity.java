package basic.LearningAndroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OriginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username,family;
    Button showDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin);
        bind();
    }
    void bind()
    {
        username =findViewById(R.id.username);
        family=findViewById(R.id.family);
        showDetails=findViewById(R.id.showDetails);
        showDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String usernameValue=username.getText().toString();
        String familyValue=family.getText().toString();

        Intent detIntent=new Intent(this,DestinationActivity.class);
        detIntent.putExtra("username",usernameValue);
        detIntent.putExtra("family",familyValue);
        startActivity(detIntent);
    }
}
