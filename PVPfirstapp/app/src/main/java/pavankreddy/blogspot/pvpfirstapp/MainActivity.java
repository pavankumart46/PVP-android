package pavankreddy.blogspot.pvpfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the text view on Xml file to textView object
        textView = findViewById(R.id.count_tv);

    }

    public void showToast(View view)
    {
        Intent i = new Intent(this,GalleryActivity.class);
        startActivity(i);

    }

    public void showCount(View view)
    {
        count++;
        textView.setText(String.valueOf(count));
        //textView.setText(""+count);
    }
}
