package pavankreddy.blogspot.intentsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openUrl(View view)
    {
        //Step-1: get the text from EditText box on the xml file
        EditText et = findViewById(R.id.url_text_box);
        String pvp = et.getText().toString();
        // Step-2: Write implicit intent to open a web browser with the link
        Intent i = new Intent();
            // Sub step 1 - Set the action on Intent object
        i.setAction(Intent.ACTION_VIEW);
            // Sub Step 2 - Set the Data For the intent
        i.setData(Uri.parse(pvp));

        //Shorter Form of the above steps is
        //Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(pvp));

        // Step-3 Send the request to the system
        startActivity(i);
    }

    public void openMaps(View view)
    {

    }
}
