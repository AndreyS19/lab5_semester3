import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;
public class task5
{
    int prov=0;
    public static void task5_var5() {
        Scanner scan=new Scanner(System.in);
        String[] clients=new String[]{"176.62.80.71","127.0.0.1","179.16.235.2"};
        int prov=0;
        Socket s = null;
        try {

                ServerSocket server = new ServerSocket(8030);
                for(;prov==0;)
                {
                    System.out.println("выберите адрес получателя:\n1 - 176.62.80.71\n2 - 127.0.0.1\n3 - 179.16.235.2");
                    int clientnum=scan.nextInt();
                    scan.nextLine();
                    s = server.accept();
                    InetSocketAddress socketAddress = (InetSocketAddress) s.getRemoteSocketAddress();
                    String clientIpAddress = socketAddress.getAddress().getHostAddress();
                    if (Objects.equals(clientIpAddress, clients[clientnum - 1])) {
                        prov = 1;
                        System.out.println("подключен выбранный клиент");
                        System.out.println("введите сообщение");
                        PrintStream ps = new PrintStream(s.getOutputStream());
                        ps.println(scan.nextLine());
                        ps.flush();
                        s.close();

                    }
                    else {
                        System.out.println("к серверу пытался подключится клиент с id=" + clientIpAddress);
                        s.close();
                    }
                    //System.out.println(s);
                }


        } catch (IOException e) {
            System.out.println(" ошибка : " + e);
        }
    }//Клиент посылает через сервер сообщение другому клиенту, выбранному из списка
}
