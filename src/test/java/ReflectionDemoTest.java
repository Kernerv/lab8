import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Humans.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {

    @Test
    void findCountHumans() throws Exception {
        Human human1 = new Human("Гриша", 25);
        Human human2 = new Human("Валентин", 2);
        Human human3 = new Human2("Иван", 20);
        List<Object> list = new ArrayList<Object>();
        list.add(human1); list.add(human2);
        list.add(human3);
        list.add("aaaaa");
        ReflectionDemo reflectionDemo = new ReflectionDemo();
        int q = reflectionDemo.findCountHumans(list);

        assertEquals(3, q);
    }

    @Test
    void getListNamesOpenMethods() {
        Object object = new Human("Дмитрий", 2);
        List<String> expected = new ArrayList<String>(Arrays.asList("equals","hashCode","getAge","setAge","setName","getName","wait","wait","wait","toString","getClass","notify","notifyAll"));
        Collections.sort(expected);
        List<String> actual = new ArrayList<String>(ReflectionDemo.getListNamesOpenMethods(object));
        Collections.sort(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllSuperClasses(){
        Object human = new Human3("Саша", 20);
        List<String> expected = new ArrayList<String>(Arrays.asList("Humans.Human2", "Humans.Human", "java.lang.Object"));
        assertEquals(expected, ReflectionDemo.getAllSuperClasses(human));
    }
}