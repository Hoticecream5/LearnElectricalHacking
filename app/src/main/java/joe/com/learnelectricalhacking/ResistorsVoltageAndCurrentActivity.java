package joe.com.learnelectricalhacking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResistorsVoltageAndCurrentActivity extends AppCompatActivity {
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistors_voltage_and_current);

        nextBtn = findViewById(R.id.doneBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButtonClicked();
            }
        });
    }

    public void nextButtonClicked(){
        Toast.makeText(this,"Little quiz time ",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,FirstPartSummaryActivity.class);
        startActivity(intent);

    }


}
