package Security;

import java.sql.SQLException;

public abstract class Signup {
    public Signup() {
    }

    public abstract void createLoginAndPass(Long var1, String var2, String var3);

    public abstract void setLoginAndPass(Long var1, String var2, String var3) throws SQLException;
}
