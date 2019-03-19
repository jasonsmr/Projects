package RedBox;

import java.io.Serializable;

public enum DVDEdition  implements Serializable {
    DirectorsCut, Enhanced, Standard, NONE;

    @Override
    public String toString() {
        switch (this) {
            case DirectorsCut: return "DirectorsCut";
            case Enhanced: return "Enhanced";
            case Standard: return "Standard";
            case NONE: return "";
            default: throw new IllegalArgumentException();
        }
    }
}
