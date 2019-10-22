package labs.pumnya01;

public final class Pumnya01 {
    private Pumnya01() {
    }
    /**
     * An entry point - main method.
     *
     * @param args - arguments of main method
     */
    public static void main(final String[] args) {
        final short recBookNum = 0x4668;
        final long phone = 380966244151L;
        final byte binaryPhonePart = 0b110011;
        final short octalPhonePart = 010067;
        final byte journalNum = 14;
        final byte constant = 26;
        final byte number = (journalNum - 1) % constant + 1;
        final char engChar = (char) number + 65;

        byte even = 0;
        byte odd = 0;
        byte oneCount = 0;
        String str;

        str = Short.toString(recBookNum) + Long.toString(phone)
                + Byte.toString(binaryPhonePart)
                + Short.toString(octalPhonePart)
                + Byte.toString(number)
                + Integer.toString((int) engChar);
        for (byte i = 0; i < str.length(); i++) {
            if (str.charAt(i) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Number: " + str);
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd + "\n");
        str = null;
        str = Integer.toBinaryString(recBookNum)
                + Long.toBinaryString(phone)
                + Integer.toBinaryString(binaryPhonePart)
                + Integer.toBinaryString(octalPhonePart)
                + Integer.toBinaryString(number)
                + Integer.toBinaryString((int) engChar);
        for (byte i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                oneCount++;
            }
        }
        System.out.println("Binary string: " + str);
        System.out.println("One digits amount: " + oneCount);
    }
}
