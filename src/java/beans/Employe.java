package beans;

import java.util.Date;

public class Employe {
    private int employeId;
    private Role role;
    private String employeNom;
    private String employePrenom;
    private String employeGrade;
    private String employeLogin;
    private String employeMdp;
    private String employeMail;
    private Date prisePoste;
    private Date departPoste;

    public Employe(){
    
    }
    
    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmployeNom() {
        return employeNom;
    }

    public void setEmployeNom(String employeNom) {
        this.employeNom = employeNom;
    }

    public String getEmployePrenom() {
        return employePrenom;
    }

    public void setEmployePrenom(String employePrenom) {
        this.employePrenom = employePrenom;
    }

    public String getEmployeGrade() {
        return employeGrade;
    }

    public void setEmployeGrade(String employeGrade) {
        this.employeGrade = employeGrade;
    }

    public String getEmployeLogin() {
        return employeLogin;
    }

    public void setEmployeLogin(String employeLogin) {
        this.employeLogin = employeLogin;
    }

    public String getEmployeMdp() {
        return employeMdp;
    }

    public void setEmployeMdp(String employeMdp) {
        this.employeMdp = employeMdp;
    }

    public String getEmployeMail() {
        return employeMail;
    }

    public void setEmployeMail(String employeMail) {
        this.employeMail = employeMail;
    }

    public Date getPrisePoste() {
        return prisePoste;
    }

    public void setPrisePoste(Date prisePoste) {
        this.prisePoste = prisePoste;
    }

    public Date getDepartPoste() {
        return departPoste;
    }

    public void setDepartPoste(Date departPoste) {
        this.departPoste = departPoste;
    }
    
    
}
