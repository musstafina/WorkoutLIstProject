package Security;

import java.sql.SQLException;

public interface CheckPass {
    boolean checkLoginAndPass(String var1, String var2) throws SQLException;
}
