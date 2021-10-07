package CommonObjects;

import java.io.Serializable;

public class RemoveKeyDTO extends UniversalObjectToSend implements Serializable {
    private String stringArgument;

    @Override
    public String getStringArgument() {
        return stringArgument;
    }

    @Override
    public void setStringArgument(String stringArgument) {
        this.stringArgument = stringArgument;
    }
}
