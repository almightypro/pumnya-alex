package labs.pumnya16.View;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AboutPageController extends FXMLController{
    private Stage dialogStage;

    public void setDialogStage(Stage stage) {
        this.dialogStage = stage;
    }
    @FXML
    public void handleClose() {
        this.dialogStage.close();
    }
    @FXML
    public void handleDiscord() {
        try {
            Desktop.getDesktop().browse(new URI("https://discord.com/users/527049968176070656"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    @FXML
    public void handleTelegram() {
        try {
            Desktop.getDesktop().browse(new URI("https://t.me/SiriusQuase"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    @FXML
    public void handleSkype() {
        try {
            Desktop.getDesktop().browse(new URI("https://join.skype.com/invite/i6li7fhK7Yqw"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    @FXML
    public void handleYoutube() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/channel/UCfrAsAoknyVJtOuWge0ojIg"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    @FXML
    public void handleExit(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ESCAPE) {
            this.dialogStage.close();
        }
    }
}
