package pavankreddy.blogspot.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoSecond(View view)
    {
        startActivity(new Intent(this,SecondActivity.class));
    }

    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/ // If you don't remove this line, 
        // back button behavior will not change
        Toast.makeText(this, "Clicked On Back Button", Toast.LENGTH_SHORT).show();
    }
}
