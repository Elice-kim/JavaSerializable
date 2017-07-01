import java.io.*;

public class Main {

    public static String USER_INFO = "user.file";

    public static void main(String[] args) {
        executeSerializable();
    }

    private static void executeSerializable() {

        try {
            FileOutputStream fos = new FileOutputStream(USER_INFO);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            User user1 = new User("Jack","1234", "jack@gmail.com",20);
            User user2 = new User("Gikko","1004", "loveu@gmail.com",30);

            oos.writeObject(user1);
            oos.writeObject(user2);
            oos.close();
            System.out.println("complete Serializable");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
