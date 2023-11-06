import java.io.*;
import java.net.*;
import java.util.Scanner;

public class task5
{
    public static void task5_var5() {
        Socket s = null;
        try {
            Scanner scan=new Scanner(System.in);
            ServerSocket server = new ServerSocket(8030);
            s = server.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println(scan.nextLine());
            ps.flush();
            s.close();
        } catch (IOException e) {
            System.out.println(" ошибка : " + e);
        }
    }
}


