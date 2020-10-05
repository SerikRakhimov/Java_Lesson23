import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement
public class Student {
    @XmlElement(required = true)
    private Integer id;
    @XmlElement(required = true)
    private String firstName;
    @XmlElement(required = true)
    private String lastName;
    public Student(){

    }
    public Student(Integer id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}