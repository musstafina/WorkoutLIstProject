package Workout;

import java.sql.SQLException;

public interface RequestService {
    void createTask(int var1, String var2, String var3, String var4);

    void deleteTask(int var1) throws SQLException;

    void editTask(int var1, String var2, String var3, String var4) throws SQLException;

    void findAllTasks() throws SQLException;
}
