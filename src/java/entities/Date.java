package entities;

public abstract class Date implements IDate{
    private Date date;

    public Date(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
