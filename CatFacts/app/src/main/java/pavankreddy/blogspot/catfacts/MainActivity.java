package pavankreddy.blogspot.catfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView cf;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cf = findViewById(R.id.catfacts);
        pb = findViewById(R.id.progressbar);
        pb.setVisibility(View.GONE);
    }

    public void fetchCatFacts(View view)
    {
        pb.setVisibility(View.VISIBLE);
        new FetchCatFacts(this,cf,pb).execute();
    }
}
