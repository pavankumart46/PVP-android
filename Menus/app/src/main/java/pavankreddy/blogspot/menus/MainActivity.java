package pavankreddy.blogspot.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // attaching menuitems.xml to activity
        getMenuInflater().inflate(R.menu.menuitems,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first:
                Toast.makeText(this,
                        "First Option is selected",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                Toast.makeText(this, "Second Option is selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                showAlert();
                break;

            default:
                Toast.makeText(this, "default Option is selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void showAlert()
    {
        AlertDialog.Builder alertDialog =
                new AlertDialog.Builder(this);
        alertDialog.setTitle("MY FIRST ALERT");
        alertDialog.setMessage("This is a lengthy message that describes nothing");
        alertDialog.setIcon(R.drawable.ic_launcher_background);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "positive button is clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("NOT OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
}
