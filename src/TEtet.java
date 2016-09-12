/**
 * Created by vitaly on 9/12/16.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class TEtet {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        List list = new ArrayList();
        FileOutputStream stream = new FileOutputStream("file.txt");
        stream.write("sdfsd sdf sdf sdf sdf".getBytes()); // работает только с байтами
        stream.close();

        FileWriter writer = new FileWriter("f2.txt");
        writer.write("hello");
        writer.close();

        FileReader reader = new FileReader("f2.txt");
        char[] cbuf = new char[50];
        int read = reader.read(cbuf); // сиомлово количетсво

        String s = new String(cbuf, 0, read); // считай с нулвого по read
        System.out.println(s);

        BufferedReader r = new BufferedReader(new FileReader("f2.txt"));
        String s1 = r.readLine();
        System.out.println(s1);

    }
}
