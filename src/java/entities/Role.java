package entities;


public class Role extends ClassGenerique {
    private int roleId;
    private String roleNom;
    
    public Role(){
        super();
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleNom() {
        return roleNom;
    }

    public void setRoleNom(String roleNom) {
        this.roleNom = roleNom;
    }
}
