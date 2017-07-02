import java.io.*;

public class Main {

    public static String USER_INFO = "user.file";

    public static void main(String[] args) {
        executeSerializable();
        executeDeserializable();
    }

    private static void executeSerializable() {

        try {
            // ObjectOutputStream 을 이용한 객체 파일 저장
            FileOutputStream fos = new FileOutputStream(USER_INFO);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            // User Class 에 데이터를 입력하여 객체 2개 생성한다.
            User user1 = new User("Jack", "1234", "jack@gmail.com", 20);
            User user2 = new User("Gikko", "1004", "loveu@gmail.com", 30);

            // 해당 파일에 2개의 객체를 순차적으로 쓴다
            oos.writeObject(user1);
            oos.writeObject(user2);

            //스트림을 닫음
            oos.close();
            System.out.println("complete Serializable");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeDeserializable() {

        try {
            //USER_INFO로 부터 객체를 읽어오는 스트림을 생
            FileInputStream fis = new FileInputStream(USER_INFO);
            BufferedInputStream bfs = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bfs);

            User u1 = (User) ois.readObject();
            User u2 = (User) ois.readObject();

            //password 변수는 transient 선언으로 직렬화에 보내지 않아 null로 출력된다
            System.out.println(u1.toString());
            System.out.println(u2.toString());

            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
