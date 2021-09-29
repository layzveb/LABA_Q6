package SpaceMarine;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private long x; //Максимальное значение поля: 534
    private Long y; //Поле не может быть null

    public Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }


    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "( " + x + "; " + y + " )";
    }
}
