import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);

        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao day so: ");
        String str = sc.nextLine();

        try {
            int data = Integer.parseInt(str);
            dos.writeInt(data);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        int result = dis.readInt();
        System.out.println("Tong cac chu so vua nhap la: " + result);

        client.close();
    }
}
