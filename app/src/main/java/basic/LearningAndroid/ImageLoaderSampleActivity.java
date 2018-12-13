package basic.LearningAndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoaderSampleActivity extends AppCompatActivity {

    ImageView avatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_sample);
        avatar=findViewById(R.id.avatar);

        Glide.with(this)
                .load("http://media.irib.ir/assets//radio_slider/20181120151156_9032.png")
                .into(avatar);
    }
}
