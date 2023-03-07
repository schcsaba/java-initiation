public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");

        // Déclaration
        byte monByte;
        int monEntier;
        char monChar;
        double monDouble;
        long monLong;
        String s1;
        String s2;

        // Initialisation
        monByte = 127;
        monEntier = 12;
        monChar = 'c';
        monDouble = 554.265454;
        monLong = 4545353513135135134L;
        s1 = "Une chaîne ";
        s2 = "de charactère";

        // Utilisation
        System.out.println(monEntier);
        System.out.println(monChar);
        System.out.println(monDouble);
        System.out.println(monLong);
        System.out.println(monByte + 1); // 128
        System.out.println(s1 + s2);

        monByte++;

        System.out.println(monByte); // -128

    }

}
