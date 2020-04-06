
package entities;

import java.io.Serializable;


public abstract class Utilisateur implements Serializable, IUtilisateur {
private String login;
private String pass;
private String email;

    public Utilisateur() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String log) {
        this.login = log;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    

}





    