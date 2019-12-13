package pavankreddy.blogspot.roomdatabase;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//DAO is always an interface

@Dao
public interface EmployeeDao {

    @Insert
    void insertEmployee(Employee employee);

    @Query("select * from employee")
    List<Employee> getAll();

}
