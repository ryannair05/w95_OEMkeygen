// Windows 95 OEM key generator
// Coded by Twizzlestorm - free to distribute!

import java.io.*;
public class Keygen {
    public static String gen() {
        String day, year, div7 = "0000000", rand;
        
        // First three digits
        day = String.valueOf((int)(Math.random() * ((366 - 1) + 1)) + 1);
        day = String.format("%03d", Integer.parseInt(day));

        // Next two digits
        year = String.valueOf((int)(Math.random() * ((2003 - 1995) + 1)) + 1995);
        year = year.substring(2);

        // Next seven digits
        while ((Integer.parseInt(div7) % 10 == 0) || (Integer.parseInt(div7) % 10 == 8) || (Integer.parseInt(div7) % 10 == 9)) {
            div7 = ("0" + (String.valueOf((int)((Math.random() * ((142857 - 1) + 1)) + 1) * 7)));
            div7 = String.format("%07d", Integer.parseInt(div7));
        }

        // Last five digits
        rand = String.valueOf((int)(Math.random() * ((99999 - 0) + 1)));
        rand = String.format("%05d", Integer.parseInt(rand));

        return (day + year + "-OEM-" + div7 + "-" + rand);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;

        System.out.print("Enter # of keys to generate: ");
        n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= n; i++) {
            System.out.println(gen());
        }
    }
}
