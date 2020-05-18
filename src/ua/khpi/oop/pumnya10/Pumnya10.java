package labs.pumnya10;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class Pumnya10 {
    private Pumnya10() {
    }

    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        boolean isExit = false;
        List<String> list = Arrays.asList(args);
        boolean isAuto = list.contains("-auto");

        while(!isExit) {
            isExit = Dialog.run(isAuto);
        }
    }
}
