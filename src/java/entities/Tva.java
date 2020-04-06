package entities;

public class Tva extends ClassGenerique{
    private int tvaCode;
    private float tvaTaux;
    
    public Tva(){
        super();
    }

    public int getTvaCode() {
        return tvaCode;
    }

    public void setTvaCode(int tvaCode) {
        this.tvaCode = tvaCode;
    }

    public float getTvaTaux() {
        return tvaTaux;
    }

    public void setTvaTaux(float tvaTaux) {
        this.tvaTaux = tvaTaux;
    }
}
