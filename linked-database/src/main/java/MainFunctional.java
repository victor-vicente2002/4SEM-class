import models.Student;
import utils.DoubleLinkedList;
import utils.Node;
import utils.NodeStream;
import java.util.List;

public class MainFunctional {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("02201065", "Víctor Vicente", "2CCO"),
                new Student("022010132", "Bezerra da Silva", "1ADS"),
                new Student("022010100", "Milton aqui", "1ADS"),
                new Student("022010098", "Stélio Natálio", "1ADS")
        );
        NodeStream stream = new NodeStream(new Node(null));
        stream.getList().saveAll(students);

        stream.map((student) -> {
            student.setName("Marcus");
            return student;
        });

        NodeStream stream1 = stream.filter((student) -> student.getRa().equals("02201065"));
        System.out.println(stream1.getList().getSize());

        int stream2 = stream.reduce((acumulator, student) -> acumulator++);
        System.out.println(stream2);
    }
}
