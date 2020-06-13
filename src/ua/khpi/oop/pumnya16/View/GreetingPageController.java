package labs.pumnya16.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GreetingPageController extends FXMLController {
    @FXML
    private Button startButton;

    @FXML
    private void handleStart() {
        getMain().showMainPage();
    }
}
