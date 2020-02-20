package joe.com.learnelectricalhacking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;


import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectingActivity extends AppCompatActivity {
    private ImageView imgView,noResistorImageView;
    TextView resistorAddedTxtView;
    Button nextBtn;
    private ViewGroup rootLayout;
    private int _xDelta;
    private int _yDelta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connecting);
        rootLayout= findViewById(R.id.view_root);
        imgView = findViewById(R.id.resistorimageView);
        noResistorImageView = findViewById(R.id.resistorCircuitImageView);
        resistorAddedTxtView = findViewById(R.id.resistorAdded);

        nextBtn = findViewById(R.id.resistor_voltage_current_Btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButtonClicked();
            }
        });


        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
        imgView.setLayoutParams(layoutParams);
        imgView.setOnTouchListener(new ChoiceTouchListener());


    }

    public void nextButtonClicked(){
        Intent intent = new Intent(this,ResistorsVoltageAndCurrentActivity.class);
        startActivity(intent);

    }

    private final class ChoiceTouchListener implements OnTouchListener{
        public boolean onTouch(View view, MotionEvent event){
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK){
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;

                    break;
                case MotionEvent.ACTION_UP:

                        noResistorImageView.setImageResource(R.drawable.done_resistor_circuit);
                        imgView.setVisibility(View.GONE);
                        resistorAddedTxtView.setText("Now the resistor is connected to the circuit\n" +
                                " like above and current is flowing (the battery is working)" +
                                " and click next to see how the voltage and current are affected by a resistor");
                        nextBtn.setVisibility(View.VISIBLE);
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = X - _xDelta;
                    layoutParams.topMargin = Y - _yDelta;
                    layoutParams.rightMargin = -250;
                    layoutParams.bottomMargin = -250;
                    view.setLayoutParams(layoutParams);
                    break;


            }
            rootLayout.invalidate();
            return true;
        }
    }
}
