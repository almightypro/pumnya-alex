package labs.pumnya16.Util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import labs.pumnya16.Model.EventScheduler;
import labs.pumnya16.Pumnya16;

import java.io.*;
import java.util.ArrayList;

public class Util {
    private Util() {
        // empty body
    }

    private static Pumnya16 main;
    public static void setMain(Pumnya16 m) {
        main = m;
    }

    public static void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Resource File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Event files", "*.event"));
        fileChooser.setInitialDirectory(new File("D:/Programming Projects/Java Projects/pumnya-alex"));
        File file = fileChooser.showSaveDialog(main.getPrimaryStage());
        if (file != null) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(file.getName()));
                oos.writeObject(new ArrayList<>(main.getEventData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Event files", "*.event"));
        fileChooser.setInitialDirectory(new File("D:/Programming Projects/Java Projects/pumnya-alex"));
        File file = fileChooser.showOpenDialog(main.getPrimaryStage());
        if (file != null) {
            try {
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(file.getName()));
                main.setEventData((ArrayList<EventScheduler>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static ObservableList<EventScheduler> search(String str) {
        ObservableList<EventScheduler> temp = FXCollections.observableArrayList();
        for(int i = 0; i < main.getEventData().size(); i++) {
            if(searchInItem(main.getEventData().get(i), str)) {
                temp.add(main.getEventData().get(i));
            }
        }
        return temp;
    }

    private static boolean searchInItem(EventScheduler item, String str) {
        if(item.getDate().contains(str)) {
            return true;
        }
        if(item.getTime().contains(str)) {
            return true;
        }
        if(item.getVenue().contains(str)) {
            return true;
        }
        if(item.getDescription().contains(str)) {
            return true;
        }
        if(item.getOrganizer().contains(str)) {
            return true;
        }
        if(String.valueOf(item.getDuration()).contains(str)) {
            return true;
        }
        return false;
    }
}
