package labs.pumnya16.View;

import labs.pumnya16.Pumnya16;

public abstract class FXMLController {
    private Pumnya16 main;
    public void setMain(Pumnya16 main) {
        this.main = main;
    }
    public Pumnya16 getMain() {
        return main;
    }
}
