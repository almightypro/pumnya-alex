package labs.pumnya09;

import labs.pumnya07.SchedulerEvent;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public final class Pumnya09 {
    private Pumnya09() {
    }
    /**
     * Точка входа, главный метод.
     * @param args - аргументы главного метода
     * @throws IOException - при неудачной
     * работе с файлами
     * @throws ClassNotFoundException - при
     * отсутствии необходимого класса
     */
    public static void main(final String[] args)
            throws IOException, ClassNotFoundException {
        GenericList<SchedulerEvent> container1 = new GenericList<>();
        container1.pushBack(SchedulerEvent.generate(true));
        container1.pushFront(SchedulerEvent.generate(false));
        container1.pushBack(SchedulerEvent.generate());
        System.out.println("Данные: ");
        System.out.print(container1.toString());
        System.out.println("Serialization...");
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("DataFile.dat"));
        oos.writeObject(container1);
        oos.close();
        System.out.println("Done!\n");
        System.out.println("Deserialization...");
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("DataFile.dat"));
        GenericList<SchedulerEvent> container2 =
                (GenericList) ois.readObject();
        ois.close();
        System.out.print(container2.toString());

        System.out.println("Сохраненеие в XML...");
        FileOutputStream fos = new FileOutputStream("Encoded.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(fos));
        xmlEncoder.writeObject(container1);
        xmlEncoder.close();
        System.out.println("Done!\n");

        System.out.println("Чтение из XML...");
        try {
            FileInputStream fis = new FileInputStream("Encoded.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(
                    new BufferedInputStream(fis));
            GenericList<SchedulerEvent> container3 =
                    (GenericList) xmlDecoder.readObject();
            xmlDecoder.close();
            System.out.print(container3.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
