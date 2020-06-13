package labs.pumnya16.View;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.util.StringConverter;
import labs.pumnya16.Model.EventScheduler;
import labs.pumnya16.Util.Util;

public class MainPageController extends FXMLController {
    @FXML
    public TextField searchField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField timeField;
    @FXML
    private TextField durationField;
    @FXML
    private TextField venueField;
    @FXML
    private TextField descrField;
    @FXML
    private TextField organizerField;
    @FXML
    private TableView<EventScheduler> tableView;
    @FXML
    private TableColumn<EventScheduler, String> dateCol;
    @FXML
    private TableColumn<EventScheduler, String> timeCol;
    @FXML
    private TableColumn<EventScheduler, Float> durationCol;
    @FXML
    private TableColumn<EventScheduler, String> venueCol;
    @FXML
    private TableColumn<EventScheduler, String> descrCol;
    @FXML
    private TableColumn<EventScheduler, String> organizerCol;

    private EventScheduler selectedColumn;

    @FXML
    public void handleOpen() {
        Util.loadFromFile();
        setTableItems(getMain().getEventData());
    }
    @FXML
    public void handleSave() {
        Util.saveToFile();
    }
    @FXML
    public void handleExit() {
        getMain().getPrimaryStage().close();
    }
    @FXML
    public void handleExitButton() {
        getMain().getPrimaryStage().close();
    }
    @FXML
    public void handleAbout() {
        getMain().showAboutPage();
    }
    @FXML
    public void handleAdd() {
        if(isInputValid()) {
            getMain().getEventData().add(new EventScheduler(
                    dateField.getText(), timeField.getText(), Float.parseFloat(durationField.getText()),
                    venueField.getText(), descrField.getText(), organizerField.getText()));
        }
        dateField.clear();
        timeField.clear();
        venueField.clear();
        descrField.clear();
        durationField.clear();
        organizerField.clear();
        setTableItems(getMain().getEventData());
    }
    @FXML
    public void handleClear() {
        getMain().getEventData().clear();
        setTableItems(getMain().getEventData());
    }
    @FXML
    public void handleDelete() {
        getMain().getEventData().remove(getSelectedColumn());
        setTableItems(getMain().getEventData());
    }
    @FXML
    public void handleTextInput() {
        if(searchField.getText().length() == 0) {
            setTableItems(getMain().getEventData());
        } else {
            ObservableList<EventScheduler> temp = Util.search(searchField.getText());
            setTableItems(temp);
        }
    }
    @FXML
    public void handleSaveButton() {
        Util.saveToFile();
    }
    @FXML
    public void handleLoadButton() {
        Util.loadFromFile();
        setTableItems(getMain().getEventData());
    }
    @FXML
    public void handleDateChange(TableColumn.CellEditEvent<EventScheduler, String> t) {
        t.getTableView().getItems().get(t.getTablePosition().getRow()).setDate(t.getNewValue());
    }
    @FXML
    public void handleTimeChange(TableColumn.CellEditEvent<EventScheduler, String> t) {
        t.getTableView().getItems().get(t.getTablePosition().getRow()).setTime(t.getNewValue());
    }
    @FXML
    public void handleVenueChange(TableColumn.CellEditEvent<EventScheduler, String> t) {
        t.getTableView().getItems().get(t.getTablePosition().getRow()).setVenue(t.getNewValue());
    }
    @FXML
    public void handleDescrChange(TableColumn.CellEditEvent<EventScheduler, String> t) {
        t.getTableView().getItems().get(t.getTablePosition().getRow()).setDescription(t.getNewValue());
    }
    @FXML
    public void handleOrganizerChange(TableColumn.CellEditEvent<EventScheduler, String> t) {
        t.getTableView().getItems().get(t.getTablePosition().getRow()).setOrganizer(t.getNewValue());
    }
    @FXML
    public void handleDurationChange(TableColumn.CellEditEvent<EventScheduler, Float> t) {
        t.getTableView().getItems().get(t.getTablePosition().getRow()).setDuration(t.getNewValue());
    }

    @FXML
    void initialize() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        timeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        durationCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<>() {
            @Override
            public String toString(Float value) {
                return Float.toString(value);
            }
            @Override
            public Float fromString(String s) {
                return Float.parseFloat(s);
            }
        }));
        venueCol.setCellValueFactory(new PropertyValueFactory<>("venue"));
        venueCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descrCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        descrCol.setCellFactory(TextFieldTableCell.forTableColumn());
        organizerCol.setCellValueFactory(new PropertyValueFactory<>("organizer"));
        organizerCol.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                setSelectedColumn(tableView.getSelectionModel().getSelectedItem());
            }
        });
    }

    public void setTableItems(ObservableList<EventScheduler> data) {
        tableView.setItems(data);
    }

    private void setSelectedColumn(EventScheduler event) {
        selectedColumn = event;
    }

    private EventScheduler getSelectedColumn() {
        return selectedColumn;
    }

    private boolean isInputValid() {
        StringBuilder error = new StringBuilder();
        if (!EventScheduler.checkDate(dateField.getText())) {
            error.append("\"Date\" ");
        }
        if (!EventScheduler.checkTime(timeField.getText())) {
            error.append("\"Time\" ");
        }
        if (!EventScheduler.checkVenue(venueField.getText())) {
            error.append("\"Venue\" ");
        }
        if (!EventScheduler.checkDescription(descrField.getText())) {
            error.append("\"Description\" ");
        }
        if (!EventScheduler.checkName(organizerField.getText())) {
            error.append("\"Organizer\" ");
        }
        if (durationField.getText().equals("") ||
                !EventScheduler.checkDuration(Float.parseFloat(durationField.getText()))) {
            error.append("\"Duration\" ");
        }
        if (error.length() == 0) {
            return true;
        } else {
            error.append("- поле(я) с ошибками");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(600);
            alert.setWidth(800);
            alert.initOwner(getMain().getPrimaryStage());
            alert.initModality(Modality.WINDOW_MODAL);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Некоторым полям требуются правки!");
            alert.setContentText(error.toString());
            alert.showAndWait();

            return false;
        }
    }
}
