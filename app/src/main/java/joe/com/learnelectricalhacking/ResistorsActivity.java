package joe.com.learnelectricalhacking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResistorsActivity extends AppCompatActivity {
Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistors);
           nextBtn = findViewById(R.id.resitorButton);

        nextBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            nextButtonClicked();
        }
    });
}



    public void nextButtonClicked(){
        Intent intent = new Intent(this,AllDoneActivity.class);
        startActivity(intent);

}

}
