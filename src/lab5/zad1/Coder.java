package lab5.zad1;

public class Coder {
    public Coder() {
    }

    static String code(String var0) {
        StringBuilder var1 = new StringBuilder();

        for(int var2 = 0; var2 < var0.length(); ++var2) {
            var1.append((char)(var0.charAt(var2) + 5));
        }

        return var1.toString();
    }
}
