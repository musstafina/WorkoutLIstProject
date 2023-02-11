package Security;

public class Login {
    private Long id;
    private String log;
    private String pass;

    public Login() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}