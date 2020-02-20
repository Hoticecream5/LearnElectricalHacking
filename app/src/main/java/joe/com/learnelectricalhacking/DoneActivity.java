package joe.com.learnelectricalhacking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

public class DoneActivity extends AppCompatActivity {
Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        nextBtn = findViewById(R.id.close_app_btn);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButtonClicked();
            }
        });
    }

    public void nextButtonClicked(){
        Toast.makeText(this,"You can exit app now",Toast.LENGTH_SHORT).show();
    }
}
