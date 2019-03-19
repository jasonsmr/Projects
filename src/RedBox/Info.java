package RedBox;

import java.io.Serializable;

//@XmlRootElement(name = "PlayerType")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Info implements Serializable {
    private String info = "BLANK TYPE";
    private String output = "I AM BLANK DISK OUTPUT";
    private PlayerType player;
    private BluRayEdition bluRayEdition;
    private DVDEdition dvdEdition;

    public Info() {
        this.info = "ISO";
        this.output = this.toString();
    }

    public Info(DVDEdition dvdEdition) {
        this.info = "DVD";
        this.dvdEdition = dvdEdition;
        this.output = this.toString();
    }

    public Info(BluRayEdition bluRayEdition) {
        this.info = "BluRay";
        this.bluRayEdition = bluRayEdition;
        this.output = this.toString();

    }

    public Info(PlayerType player) {
        this.info = "Game";
        this.player = player;
        this.output = this.toString();
    }

    public String getInfo() {
        return this.output;
    }

    public String toString() {
        switch (this.info) {
            case "DVD":
                System.out.println("Count: DVD");
                return "DVD - Standard Single Layered: " + this.dvdEdition;

            case "BluRay":
                System.out.println("Count: BLURAY");
                return "BluRay - Double Layered: " + this.bluRayEdition;

            case "Game":
                System.out.println("Count: GAME");
                return "Game - Required Player System: " + this.player;

            case "ISO":
                System.out.println("Count: ISO");
                return "ISO - SUBSYSTEM ENTRY - ISO";

            default:
                throw new IllegalArgumentException();
        }
    }


}
