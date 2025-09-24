import org.example.Main;
import org.example.WordCounter;
import org.example.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {

    List<Employee> employees = new LinkedList<>();

    @BeforeEach
    void setUp() {
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);
    }

    @DisplayName("Employee sınıfı doğru access modifiers sahip mi")
    @Test
    public void testTaskAccessModifiers() throws NoSuchFieldException {
        Field idFields = employees.get(0).getClass().getDeclaredField("id");
        Field firstnameFields = employees.get(0).getClass().getDeclaredField("firstname");
        Field lastnameFields = employees.get(0).getClass().getDeclaredField("lastname");

        assertEquals(2, idFields.getModifiers());
        assertEquals(2, firstnameFields.getModifiers());
        assertEquals(2, lastnameFields.getModifiers());
    }

    @DisplayName("findDuplicates method doğru çalışıyor mu?")
    @Test
    public void testFindDuplicatesMethod() {
        List<Employee> list = Main.findDuplicates(employees);
        assertEquals(6, list.size());
        assertEquals("Dogancan", list.get(0).getFirstname());
    }

    @DisplayName("findUniques method doğru çalışıyor mu?")
    @Test
    public void testFindUniquesMethod() {
        Map<Integer, Employee> map = Main.findUniques(employees);
        assertEquals(4, map.size());
        assertEquals("Dogancan", map.get(1).getFirstname());
    }

    @DisplayName("removeDuplicates method doğru çalışıyor mu?")
    @Test
    public void testRemoveMethod() {
        List<Employee> list = Main.removeDuplicates(employees);
        System.out.println(list);
        assertEquals(1, list.size());
        assertEquals("Burak", list.get(0).getFirstname());
    }

    @DisplayName("calculatedWord method doğru çalışıyor mu?")
    @Test
    public void testCalculateWordMethod() {
        Map<String, Integer> map = WordCounter.calculatedWord();
        assertEquals(3, map.get("which"));
        assertEquals(2, map.get("turkish"));
        assertEquals(3, map.get("mustafa"));
        assertEquals(3, map.get("kemal"));
    }

}
