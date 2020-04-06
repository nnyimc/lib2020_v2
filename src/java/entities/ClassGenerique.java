package entities;

public class ClassGenerique <T> implements IClassGenerique<T>{
    private T classAccess;

    public ClassGenerique(){

    }

    public T getClassAccess() {
        return classAccess;
    }

    public void setClassAccess(T classAccess) {
        this.classAccess = classAccess;
    }

}
