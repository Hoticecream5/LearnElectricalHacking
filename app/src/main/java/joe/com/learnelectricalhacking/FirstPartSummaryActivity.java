package joe.com.learnelectricalhacking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FirstPartSummaryActivity extends AppCompatActivity {
    Button resistorBtn, capacitorBtn, inductorBtn, nextBtn;
    EditText resistorEtd, capacitorEtd, inductorEtd;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_part_summary);
        resistorBtn = findViewById(R.id.resistor_summary_submit_button);
        capacitorBtn = findViewById(R.id.capacitor_summary_submit_button);
        inductorBtn = findViewById(R.id.inductor_summary_submit_button);
        resistorEtd = findViewById(R.id.resistor_summary_editText);
        capacitorEtd = findViewById(R.id.capacitor_summary_editText);
        inductorEtd = findViewById(R.id.inductor_summary_editText);
        nextBtn = findViewById(R.id.next_summary_button);

        resistorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resistorSubmitButtonClicked();
            }
        });
        capacitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capacitorSubmitButtonClicked();
            }
        });

        inductorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inductorSubmitButtonClicked();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButtonClicked();
            }
        });

    }


    public void nextButtonClicked() {
        Toast.makeText(FirstPartSummaryActivity.this,"Your total is " + (count),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DoneActivity.class);
        startActivity(intent);

    }

    public void resistorSubmitButtonClicked() {

        String resistorName = resistorEtd.getText().toString();
        resistorName = resistorName.toUpperCase();

        if (TextUtils.isEmpty(resistorName)) {
            Toast.makeText(this, "Enter name of component above ", Toast.LENGTH_SHORT).show();
        } else {
            if (resistorName.contentEquals("RESISTOR")) {
                Toast.makeText(this, "Correct ", Toast.LENGTH_SHORT).show();
                count = count + 1;
            } else {
                Toast.makeText(this, "wrong: its a resistor " + resistorName, Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void capacitorSubmitButtonClicked() {
        String capacitorName = capacitorEtd.getText().toString();
        capacitorName = capacitorName.toUpperCase();

        if (TextUtils.isEmpty(capacitorName)) {
            Toast.makeText(this, "Enter name of component above ", Toast.LENGTH_SHORT).show();
        } else {
            if (capacitorName.contentEquals("CAPACITOR")) {
                Toast.makeText(this, "Correct ", Toast.LENGTH_SHORT).show();
                count = count + 1;

            } else {
                Toast.makeText(this, "wrong: its a capacitor ", Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void inductorSubmitButtonClicked() {
        String inductorName = inductorEtd.getText().toString();
        inductorName = inductorName.toUpperCase();

        if (TextUtils.isEmpty(inductorName)) {
            Toast.makeText(this, "Enter name of component above ", Toast.LENGTH_SHORT).show();
        } else {
            if (inductorName.contentEquals("INDUCTOR")) {
                Toast.makeText(this, "Correct ", Toast.LENGTH_SHORT).show();
                count = count + 1;

            } else {
                Toast.makeText(this, "wrong: its an inductor ", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
