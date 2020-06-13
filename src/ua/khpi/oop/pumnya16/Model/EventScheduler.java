package labs.pumnya16.Model;

import javafx.beans.property.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventScheduler implements Serializable {

    private static final long serialVersionUID = -4232419163919693876L;

    private transient StringProperty date;
    private transient StringProperty time;
    private transient StringProperty venue;
    private transient StringProperty description;
    private transient FloatProperty duration;
    private transient StringProperty organizer;

    public EventScheduler(String date, String time, float dur, String venue, String descr, String organizer) {
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.venue = new SimpleStringProperty(venue);
        this.description = new SimpleStringProperty(descr);
        this.organizer = new SimpleStringProperty(organizer);
        this.duration = new SimpleFloatProperty(dur);
    }

    public EventScheduler() {
    }

    public final StringProperty getDateProperty() {
        return this.date;
    }

    public final String getDate() {
        return this.date.get();
    }

    public final void setDate(final String date) {
        if (checkDate(date)) {
            this.date.setValue(date);
        }
    }

    public final StringProperty getTimeProperty() {
        return this.time;
    }

    public final String getTime() {
        return time.get();
    }

    public final void setTime(final String time) {
        if (checkTime(time)) {
            this.time.setValue(time);
        }
    }

    public final StringProperty getVenueProperty() {
        return this.venue;
    }

    public final String getVenue() {
        return this.venue.get();
    }

    public final void setVenue(final String venue) {
        if (checkVenue(venue)) {
            this.venue.setValue(venue);
        }
    }

    public final StringProperty getDescriptionProperty() {
        return this.description;
    }

    public final String getDescription() {
        return this.description.get();
    }

    public final void setDescription(final String descr) {
        if (checkDescription(descr)) {
            this.description.setValue(descr);
        }
    }

    public final FloatProperty getDurationProperty() {
        return this.duration;
    }

    public final float getDuration() {
        return this.duration.get();
    }

    public final void setDuration(final Float duration) {
        if (checkDuration(duration)) {
            this.duration.setValue(duration);
        }
    }

    public final StringProperty getOrganizerProperty() {
        return this.organizer;
    }

    public final String getOrganizer() {
        return this.organizer.get();
    }

    public final void setOrganizer(final String organizer) {
        if (checkName(organizer)) {
            this.organizer.setValue(organizer);
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(getDate());
        s.writeUTF(getTime());
        s.writeUTF(getDescription());
        s.writeUTF(getOrganizer());
        s.writeUTF(getVenue());
        s.writeFloat(getDuration());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        date = new SimpleStringProperty(s.readUTF());
        time = new SimpleStringProperty(s.readUTF());
        description = new SimpleStringProperty(s.readUTF());
        organizer = new SimpleStringProperty(s.readUTF());
        venue = new SimpleStringProperty(s.readUTF());
        duration = new SimpleFloatProperty(s.readFloat());
    }

    public static boolean checkDate(final String d) {
        if (d == null) {
            return false;
        }
        final String df = "dd.MM.yyyy";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(df);
            sdf.setLenient(false);
            sdf.parse(d);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean checkTime(final String time) {
        if (time == null) {
            return false;
        }
        final String tf = "HH:mm";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(tf);
            sdf.setLenient(false);
            sdf.parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean checkVenue(final String venue) {
        if (venue == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(
                "^[А-Я][а-я]+(\\s[\"<>№]?[А-Я]*[а-я]+[\"<>№]?)*");
        Matcher matcher = pattern.matcher(venue);
        return matcher.matches();
    }

    public static boolean checkName(final String name) {
        if (name == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[А-Я а-я ,.'-]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean checkDescription(final String desc) {
        if (desc == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(
                "^[А-Я][а-я]+(\\s[А-Я]*[а-я]+)*");
        Matcher matcher = pattern.matcher(desc);
        return matcher.matches();
    }

    public static boolean checkDuration(final Float dur) {
        if(dur <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Дата: ").append(this.getDate()).append("\n");
        builder.append("Время начала: ").append(
                this.getTime()).append("\n");
        builder.append("Длительность (часы): ").append(
                this.getDuration()).append("\n");
        builder.append("Место проведения: ").append(
                this.getVenue()).append("\n");
        builder.append("Описание: ").append(
                this.getDescription()).append("\n");
        builder.append("Организатор: ").append(
                this.getOrganizer()).append("\n");
        return builder.toString();
    }
}
