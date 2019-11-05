package labs.pumnya07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SchedulerEvent {
    /** Хранение даты мероприятия. */
    private Date date;
    /** Хранение времени начала мероприятия. */
    private Date time;
    /** Хранение длительности мероприятия. */
    private int duration;
    /** Хранение места проведения. */
    private String eventVenue;
    /** Хранение описания мероприятия. */
    private String description;
    /** Хранение участников мероприятия. */
    private String[] participants;
    /**
     * Получение даты.
     * @return дату
     */
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(this.date);
    }
    /**
     * Установка даты.
     * @param d - дата, которую нужно установить
     * @throws ParseException - если не удалось
     * спарсить дату
     */
    public void setDate(final String d) throws ParseException {
        if (this.checkDate(d)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            this.date = sdf.parse(d);
        }
    }
    /**
     * Проверка даты.
     * @param d - дата
     * @return - true, если дата подходит формату
     */
    private boolean checkDate(final String d) {
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
    /**
     * Получение времени.
     * @return время
     */
    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(this.time);
    }
    /**
     * Установка времени.
     * @param t - время, которое нужно установить
     * @throws ParseException - если не удалось
     * спарсить время
     */
    public void setTime(final String t) throws ParseException {
        if (checkTime(t)) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            this.time = sdf.parse(t);
        }
    }
    /**
     * Проверка времени.
     * @param t - время
     * @return - true, если время подходит формату
     */
    private boolean checkTime(final String t) {
        final String tf = "HH:mm";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(tf);
            sdf.setLenient(false);
            sdf.parse(t);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * Получение длительности мероприятия.
     * @return длительность
     */
    public int getDuration() {
        return this.duration;
    }
    /**
     * Установка длительности.
     * @param dur - длительность,
     *           которую нужно установить
     */
    public void setDuration(final int dur) {
        this.duration = dur;
    }
    /**
     * Получение места проведения.
     * @return место проведения
     */
    public String getVenue() {
        return this.eventVenue;
    }

    /**
     * Установка места проведения.
     * @param venue - место проведения
     */
    public void setVenue(final String venue) {
        if (this.checkVenue(venue)) {
            this.eventVenue = venue;
        }
    }
    /**
     * Проверка на корректность
     * ввода места проведения.
     * @param venue - место проведения
     * @return true, если строка
     * удовлетворяет регулярному выражению
     */
    public boolean checkVenue(final String venue) {
        Pattern pattern = Pattern.compile(
                "^[А-Я][а-я]+(\\s[А-Я][а-я]+)?");
        Matcher matcher = pattern.matcher(venue);
        return matcher.matches();
    }
    /**
     * Получение описания мероприятия.
     * @return описание
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Установка описания мероприятия.
     * @param desc - описание
     */
    public void setDescription(final String desc) {
        if (this.checkDesc(desc)) {
            this.description = desc;
        }
    }
    /**
     * Проверка на корректность
     * ввода описания.
     * @param desc - описание
     * @return true, если строка
     * удовлетворяет регулярному выражению
     */
    private boolean checkDesc(final String desc) {
        Pattern pattern = Pattern.compile(
                "^[А-Я][а-я]+(\\s?[А-Я]?[а-я]+)+\\.$");
        Matcher matcher = pattern.matcher(desc);
        return matcher.matches();
    }
    /**
     * Получение участников мероприятия.
     * @return массив участников
     */
    public String[] getParticipants() {
        return this.participants;
    }
    /**
     * Установка участников мероприятия.
     * @param partAmount - количество участников
     * @throws IOException - при
     * некорректном считывании
     */
    public void setParticipants(final int partAmount) throws IOException {
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(System.in));
        this.participants = new String[partAmount];
        System.out.format("Введите имена"
                + " %s участников.%n", partAmount);
        String name;
        for (int i = 0; i < partAmount; i++) {
            System.out.format("Участник №%d: ", i + 1);
            name = reader.readLine();
            if (checkName(name)) {
                this.participants[i] = name;
            } else {
                i--;
            }
        }
    }
    /**
     * Проверка на корректность
     * ввода имени участника.
     * @param name - имя
     * @return true, если строка
     * удовлетворяет регулярному выражению
     */
    private boolean checkName(final String name) {
        Pattern pattern = Pattern.compile(
                "^[А-Я][а-я]+(\\s[А-Я][а-я]+)?");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    /**
     * Создание мероприятия.
     * @return новое мероприятие
     * @throws ParseException если не удалось
     * спарсить дату или время.
     * @throws IOException - при
     * некорректном считывании
     */
    public static SchedulerEvent generate() throws ParseException, IOException {
        Scanner in = new Scanner(System.in);
        SchedulerEvent se = new SchedulerEvent();
        System.out.print("Введите дату "
                         + "мероприятия (дд.мм.гггг): ");
        se.setDate(in.nextLine());
        System.out.print("Введите время начала"
                + " мероприятия (чч:мм): ");
        se.setTime(in.nextLine());
        System.out.print("Введите длительность"
                         + " мероприятия (в минутах): ");
        se.setDuration(in.nextInt());
        in.nextLine();
        System.out.print("Введите место проведения: ");
        se.setVenue(in.nextLine());
        System.out.print("Введите описание"
                         + " мероприятия: ");
        se.setDescription(in.nextLine());
        System.out.print("Введите количество"
                + " участников: ");
        int amount = in.nextInt();
        in.nextLine();
        se.setParticipants(amount);
        return se;
    }
    /**
     * Вывод информации о мероприятии.
     */
    public void printInfo() {
        System.out.println("Дата: " + this.getDate());
        System.out.println("Время начала: " + this.getTime());
        System.out.println("Длительность: "
                         + this.getDuration() + " минут");
        System.out.println("Место проведения: "
                         + this.getVenue());
        System.out.println("Описание: " + this.getDescription());
        System.out.print("Участники: ");
        for (String name : this.getParticipants()) {
            System.out.print(name + " ");
        }
    }
}
