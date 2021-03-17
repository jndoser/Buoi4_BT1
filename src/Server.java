import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("Server is ready...");

        Socket client = server.accept();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        int data = dis.readInt();
        System.out.println("Got: " + data);

        int result = GetSum(data);
        dos.writeInt(result);

        client.close();
        server.close();
    }

    public static int GetSum(int data)
    {
        String str = Integer.toString(data);
        char[] chars = str.toCharArray();
        int result = 0;
        for(int i =0; i < chars.length; i++)
        {
            result += Integer.parseInt(Character.toString(chars[i]));
        }
        return result;
    }
}
