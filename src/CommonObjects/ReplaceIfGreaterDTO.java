package CommonObjects;

import SpaceMarine.SpaceMarine;

import java.io.Serializable;

public class ReplaceIfGreaterDTO extends UniversalObjectToSend implements Serializable {
    private String stringArgument;
    private SpaceMarine spaceMarine;

    @Override
    public String getStringArgument() {
        return stringArgument;
    }

    @Override
    public void setStringArgument(String stringArgument) {
        this.stringArgument = stringArgument;
    }

    public SpaceMarine getSpaceMarine() {
        return spaceMarine;
    }

    public void setSpaceMarine(SpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }
}

