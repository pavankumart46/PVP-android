package pavankreddy.blogspot.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener
{

    EditText name,hobby;
    TextView results;
    private static final String NAME_KEY = "name";
    private static final String HOBBY_KEY = "hobby";
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        hobby = findViewById(R.id.hobby);
        results = findViewById(R.id.results);

        sp = getSharedPreferences("MYSP",MODE_PRIVATE);

        sp.registerOnSharedPreferenceChangeListener(this);

    }

    public void saveData(View view)
    {
        String n = name.getText().toString();
        String h = hobby.getText().toString();

        SharedPreferences.Editor editor = sp.edit();
        editor.putString(NAME_KEY,n);
        editor.putString(HOBBY_KEY,h);
        editor.apply();

        Toast.makeText(this, "Successfully written to Shared Preferences", Toast.LENGTH_SHORT).show();

        name.setText("");
        hobby.setText("");
        name.clearFocus();
        hobby.clearFocus();
    }

    public void getData(View view)
    {
         if(sp!=null){
             String n = sp.getString(NAME_KEY,"");
             String h = sp.getString(HOBBY_KEY,"");
             results.setText(n+"\n"+h);
         }
         else{
             Toast.makeText(this, "THERE IS NO DATA", Toast.LENGTH_SHORT).show();
         }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        if(sp!=null){
            String n = sp.getString(NAME_KEY,"");
            String h = sp.getString(HOBBY_KEY,"");
            results.setText(n+"\n"+h);
        }
        else{
            Toast.makeText(this, "THERE IS NO DATA", Toast.LENGTH_SHORT).show();
        }
    }
}
