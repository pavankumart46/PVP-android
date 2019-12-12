package pavankreddy.blogspot.catfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cf = findViewById(R.id.catfacts);
    }

    public void fetchCatFacts(View view)
    {
        new FetchCatFacts(this,cf).execute();
    }
}
