/*
1.Написать консольное java приложение, где в методе main класс Student.java
с 3-5 полей любых типов, создать объект этого класса, и захордкодить любые значения
2.Представить(Конвертировать) этот объект student в файле student.json
3.Представить(Конвертировать) этот объект student в файле student.xml

Для помощи, необходимо изучить JAXB, найти какие статьи конвертации java класса в json и xml
*/
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
//import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.MarshallerProperties;
//import com.howtodoinjava.demo.model.Student;
//import com.hoodooing.demo.model.Student;
//import com.hoodooin.demo.model.Student;

class Main
{
    public static void main(String[] args)
    {
        System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        Student student = new Student(1, "Lokesh", "Gupta");

        jaxbObjectToJSON(student);
        jaxbObjectToXML(student);
    }

    private static void jaxbObjectToJSON(Student student)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // To format JSON
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Set JSON type
            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            //Store JSON to File
            File file = new File("student.json");
            jaxbMarshaller.marshal(student, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
    
    private static void jaxbObjectToXML(Student student)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File("student.xml");

            //Writes XML file to file-system
            jaxbMarshaller.marshal(student, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}