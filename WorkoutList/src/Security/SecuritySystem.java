package Security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SecuritySystem extends Signup implements CheckPass {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "123456";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    Login login = new Login();
    private Connection connection;

   public SecuritySystem() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public boolean checkLoginAndPass(String login, String password) throws SQLException {
        boolean isTrue = true;
        Statement statement = this.connection.createStatement();
        String sql = "select * from signup";
        ResultSet result = statement.executeQuery(sql);

        while(result.next()) {
            if (result.getString("log").equals(login) && result.getString("pass").equals(password)) {
                isTrue = false;
                break;
            }
        }

        return isTrue;
    }

    public void createLoginAndPass(Long id, String log, String pass) {
        this.login.setId(id);
        this.login.setLog(log);
        this.login.setPass(pass);
    }

    public void setLoginAndPass(Long id, String log, String pass) throws SQLException {
        this.createLoginAndPass(id, log, pass);
        String sql = "insert into signup (id, log, pass) values(?, ?, ?);";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setLong(1, this.login.getId());
        preparedStatement.setString(2, this.login.getLog());
        preparedStatement.setString(3, this.login.getPass());
        preparedStatement.executeUpdate();
    }
}
