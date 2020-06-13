package labs.pumnya14;

import labs.pumnya09.GenericList;
import labs.pumnya13.FirstThread;
import labs.pumnya13.SecondThread;
import labs.pumnya13.ThirdThread;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Random;

public class Pumnya14 {
    /** Количество наносекунд в одной миллисекунде. */
    private static final int DIVIDER = 1_000_000;
    /** Приватный конструктор утилитарного класса. */
    private Pumnya14() {
        // Пустое тело
    }

    /**
     * Создаёт таблицу.
     * @param seqTime время последовательной обработки
     * @param concurTime время одновременной обработки
     * @param timeDiff разница во времени обработок
     */
    public static void generateTable(int size,double seqTime, double concurTime, double timeDiff) {
        String[] columnNames = {
                "Размер массива",
                "Одновременная обработка",
                "Последовательная обработка",
                "Разница"
        };
        String[][] data = {
                {Integer.toString(size),
                    Double.toString(seqTime),
                    Double.toString(concurTime),
                    Double.toString(timeDiff)}
        };
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        JTable table = new JTable(data, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setPreferredWidth(175);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("ВЫВОД");

        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(593, 150));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        GenericList<Integer> list = new GenericList<>();
        int size = 10000000;
        for (int i = 0; i < size; i++) {
            list.pushBack(new Random().nextInt(20000));
        }
        Thread thr1 = new FirstThread(list, 5000);
        Thread thr2 = new SecondThread(list, 5000);
        Thread thr3 = new ThirdThread(list, 5000);

        double concurrentTime = System.nanoTime();
        thr1.start();
        thr2.start();
        thr3.start();

        thr1.join();
        thr2.join();
        thr3.join();
        concurrentTime = (System.nanoTime() - concurrentTime) * 10e-10;
        System.out.print("\n");
        double sequentialTime = System.nanoTime();
        thr1.run();
        thr2.run();
        thr3.run();
        sequentialTime = (System.nanoTime() - sequentialTime) * 10e-10;
        double timeDiff = sequentialTime / concurrentTime;
        Pumnya14.generateTable(size, concurrentTime, sequentialTime, timeDiff);
    }
}
