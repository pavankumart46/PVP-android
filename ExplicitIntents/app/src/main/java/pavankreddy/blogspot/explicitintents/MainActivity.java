package pavankreddy.blogspot.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String gender = "NOT KNOWN";

    public void selectMale(View view) {
        gender = "male";
    }

    public void selectFemale(View view) {
        gender = "female";
    }
    public void sendData(View view)
    {// Step-1 : get the text from EditText box
        EditText et = findViewById(R.id.text_box);
        String pvp = et.getText().toString();
        // Step -2 : send the data to other activity
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("PAVAN",pvp);
        i.putExtra("GEN",gender);
        //Step-3 : send request
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
