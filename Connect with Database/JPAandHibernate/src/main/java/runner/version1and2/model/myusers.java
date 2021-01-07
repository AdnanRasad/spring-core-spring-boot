package runner.version1and2.model;
import javax.persistence.*;

@Entity
@Table(name = "myusers")
public class myusers {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId ;//so the column has to be user_id

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    public myusers(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //FOR HYBERNATE DEFAULT CONSTRUCTOR IS NEEDED
    public myusers() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "myusers2{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
