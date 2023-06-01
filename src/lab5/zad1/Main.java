package lab5.zad1;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) {
        if (var0.length != 1) {
            System.out.println("Wrong password!");
        } else {
            String var1 = var0[0];
            String[] var2 = var1.split("_");
            Date var3 = Date.from(Instant.now());
            SimpleDateFormat var4 = new SimpleDateFormat("yyyy");
            String var5 = var4.format(var3);
            int var6 = Integer.parseInt(var5);
            if (var2[0].length() == 5 && var2[1].length() == 4) {
                if (var2[0].equals(Coder.code("m35Zl")) && Integer.parseInt(var2[1]) == var6) {
                    System.out.println("Good guess");
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("Wrong password!");
            }

        }
    }
}
