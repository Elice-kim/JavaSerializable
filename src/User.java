import java.io.Serializable;

/**
 * Created by elicekim on 2017. 7. 1..
 */
public class User implements Serializable{

    private String name;
    //transient 로 전송하고싶지 않은 변수에 선언함
    private transient String password;
    private String email;
    private int age;

    public User(String name, String password, String email, int age) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String toString(){
        return "name :"+name+" password :"+ password +" email :"+email+" age :"+age;
    }


}
