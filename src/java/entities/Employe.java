package entities;

import java.util.Date;

public class Employe extends Individu implements IUtilisateur{
    private int employeId;
    private Role role;
    private String employeNom;
    private String employePrenom;
    private String employeGrade;
    private String employeLogin;
    private String employeMdp;
    private String employeMail;
    private DatePrisePoste prisePoste;
    private DateDepartPoste departPoste;

    public Employe(){

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmployeGrade() {
        return employeGrade;
    }

    public void setEmployeGrade(String employeGrade) {
        this.employeGrade = employeGrade;
    }

    public DatePrisePoste getPrisePoste() {
        return prisePoste;
    }

    public void setPrisePoste(DatePrisePoste prisePoste) {
        this.prisePoste = prisePoste;
    }

    public DateDepartPoste getDepartPoste() {
        return departPoste;
    }

    public void setDepartPoste(DateDepartPoste departPoste) {
        this.departPoste = departPoste;
    }

    @Override
    public int getCode() {
        return employeId;
    }

    @Override
    public void setCode(int code) {
        employeId = code;
    }

    @Override
    public String getNom() {
        return employeNom;
    }

    @Override
    public void setNom(String nom) {
        employeNom = nom;
    }

    @Override
    public String getPrenom() {
        return employePrenom;
    }

    @Override
    public void setPrenom(String prenom) {
        employePrenom = prenom;
    }

    @Override
    public String getLogin() {
        return employeLogin;
    }

    @Override
    public void setLogin(String login) {
        employeLogin = login;
    }

    @Override
    public String getPass() {
        return employeMdp;
    }

    @Override
    public void setPass(String pass) {
        employeMdp = pass;
    }

    @Override
    public String getEmail() {
        return employeMail;
    }

    @Override
    public void setEmail(String email) {
        employeMail = email;
    }
}
