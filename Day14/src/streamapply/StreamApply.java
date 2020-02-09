package streamapply;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class StreamApply {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket(InetAddress.getByName("localhost"),8080);//写文件与当地服务器交互
            PrintWriter out =new PrintWriter(new
                    BufferedWriter(new OutputStreamWriter(
                            socket.getOutputStream())));
            String s="Hello";
            out.println(s);
            out.flush();
            BufferedReader in=new BufferedReader(new
                    InputStreamReader(
                            socket.getInputStream()));
              String line;
              line=in.readLine();
            System.out.println(line);

            out.close();
            socket.close();
        }catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}
