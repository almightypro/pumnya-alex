package labs.pumnya16;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;

import labs.pumnya16.Model.EventScheduler;
import labs.pumnya16.Util.Util;
import labs.pumnya16.View.AboutPageController;
import labs.pumnya16.View.GreetingPageController;
import labs.pumnya16.View.MainPageController;

import java.io.IOException;
import java.util.ArrayList;

public class Pumnya16 extends Application {

    private Stage primaryStage;
    private ObservableList<EventScheduler> eventData = FXCollections.observableArrayList();

    public ObservableList<EventScheduler> getEventData() {
        return this.eventData;
    }

    public void setEventData(ArrayList<EventScheduler> list) {
        this.eventData.clear();
        this.eventData.addAll(list);
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    public Pumnya16() {
        eventData.add(new EventScheduler("01.01.1111", "01:01", 1, "Первое место.", "Первое описание!", "А. Бук"));
        eventData.add(new EventScheduler("02.02.2222", "02:02", 2, "Второе место!", "Второе описание?", "Б. Вук"));
        eventData.add(new EventScheduler("03.03.3333", "03:03", 3, "Третье место?", "Третье описание.", "В. Гук"));
        Util.setMain(this);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle("Event Scheduler");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Pumnya16.class.getResourceAsStream("Content/EventScheduler.png")));
        initGreetingPage();
    }

    public static void main(String[] args) {
        launch();
    }

    public void initGreetingPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Pumnya16.class.getResource("View/GreetingPage.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            GreetingPageController controller = loader.getController();
            controller.setMain(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMainPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Pumnya16.class.getResource("View/MainPage.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            MainPageController controller = loader.getController();
            controller.setMain(this);
            controller.setTableItems(this.getEventData());
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAboutPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Pumnya16.class.getResource("View/AboutPage.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.setTitle("About");
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            dialogStage.getIcons().add(new Image(Pumnya16.class.getResourceAsStream("Content/about.png")));
            AboutPageController controller = loader.getController();
            controller.setMain(this);
            controller.setDialogStage(dialogStage);

            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
