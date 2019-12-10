package pavankreddy.blogspot.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.textView);

        //Step 4 : Get the intent data into a string variable
        String txt = getIntent().getStringExtra("PAVAN");
        String gen = getIntent().getStringExtra("GEN");
        tv.setText(txt+"\n"+gen);
    }
}
