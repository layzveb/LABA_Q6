package CommonObjects;

import SpaceMarine.SpaceMarine;
import java.io.Serializable;

public abstract class UniversalObjectToSend implements Serializable {
    private String stringArgument;
    private SpaceMarine spaceMarine;

    public SpaceMarine getSpaceMarine() {
        return spaceMarine;
    }

    public void setSpaceMarine(SpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }

    public String getStringArgument() {
        return stringArgument;
    }

    public void setStringArgument(String stringArgument) {
        this.stringArgument = stringArgument;
    }
}
