package pavankreddy.blogspot.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LOGS","onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LOGS","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LOGS","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LOGS","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LOGS","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LOGS","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LOGS","onRestart()");
    }
}
