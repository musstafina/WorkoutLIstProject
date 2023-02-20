package Workout;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import Task.Task;

public class WorkoutList extends Confirm implements RequestService {
    
    Task task = new Task();
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");

    public WorkoutList() throws SQLException {
    }

    public void confirm(int id) throws SQLException {
        String sqlConfirm = "UPDATE task SET isDone = true WHERE id = ?;";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlConfirm);
        preparedStatement.setInt(1, this.task.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void createTask(int id, String taskName, String urgency, String description) {
        this.task.setId(id);
        this.task.setTask_name(taskName);
        this.task.setUrgency(urgency);
        this.task.setDescription(description);
    }

    public void deleteTask(int id) throws SQLException {
        String sqlDelete = "delete from task where id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlDelete);
        preparedStatement.setInt(1, this.task.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void editTask(int id, String taskName, String urgency, String description) throws SQLException {
        this.createTask(id, taskName, urgency, description);
        String sqlEdit = "UPDATE task SET task_name = ?, urgency = ?, description = ? WHERE id = ?;";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlEdit);
        preparedStatement.setInt(4, this.task.getId());
        preparedStatement.setString(1, this.task.getTask_name());
        preparedStatement.setString(2, this.task.getUrgency());
        preparedStatement.setString(3, this.task.getDescription());
        preparedStatement.executeUpdate();
    }

    @Override
    public void findAllTasks() throws SQLException {
        Statement statement = this.connection.createStatement();
        String sqlFind = "select * from task order by id desc";
        ResultSet resultSet = statement.executeQuery(sqlFind);

        while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("id");
            var10000.println("" + var10001 + ":\nTask Name: " + resultSet.getString("task_name") + "\nTask Description: " + resultSet.getString("description") + "\nTask urgency: " + resultSet.getString("urgency") + "\nTask status: " + resultSet.getString("isdone") + "\n___________________________________________________________________________________________________");
        }

    }

    public void setTask(int id, String taskName, String urgency, String description) throws SQLException {
        this.createTask(id, taskName, urgency, description);
        String sql = "insert into task (id, task_name, urgency, isDone, description) values(?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, this.task.getId());
        preparedStatement.setString(2, this.task.getTask_name());
        preparedStatement.setString(3, this.task.getUrgency());
        preparedStatement.setString(5, this.task.getDescription());
        preparedStatement.setBoolean(4, this.task.isDone());
        preparedStatement.executeUpdate();
    }
}
