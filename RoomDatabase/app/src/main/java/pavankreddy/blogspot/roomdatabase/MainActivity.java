package pavankreddy.blogspot.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name,age,salary;
    TextView results;
    EmployeeDatabase employeeDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        salary = findViewById(R.id.salary);
        results = findViewById(R.id.results);

        employeeDatabase = Room
                .databaseBuilder(this,EmployeeDatabase.class,"mydb")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        int s = Integer.parseInt(salary.getText().toString());

        Employee employee = new Employee(n,a,s);
        employeeDatabase.EmployeeDao().insertEmployee(employee);
        Toast.makeText(this, "DATA IS INSERTED", Toast.LENGTH_SHORT).show();
    }

    public void getData(View view)
    {
        results.setText("\n");
        List<Employee> employees = employeeDatabase.EmployeeDao().getAll();
        for(int i=0;i<employees.size();i++){
            results.append(""+employees.get(i).getId()+"-");
            results.append(employees.get(i).getName()+"-");
            results.append(""+employees.get(i).getAge()+"-");
            results.append(""+employees.get(i).getSalary()+"-");
            results.append("\n");
        }
    }
}
