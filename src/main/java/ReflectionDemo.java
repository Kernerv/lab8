import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import Humans.*;

public class ReflectionDemo {

    /*TASK1*/
    public int findCountHumans(List<Object> objects){
        int count = 0;
        for (Object o: objects) {
            if( o instanceof Human){count++;}
        }
        return count;
    }

    /*TASK2*/
    public static List<String> getListNamesOpenMethods(Object object){
        List<String> list = new ArrayList<String>();
        for (Method m: object.getClass().getMethods()){
            list.add(m.getName());
        }
        return list;
    }

    /*TASK3*/
    public static List<String> getAllSuperClasses(Object obj) {
        List<String> result = new ArrayList<>();
        Class<?> curr = obj.getClass();
        do {
            curr = curr.getSuperclass();
            result.add(curr.getName());
        } while (curr != Object.class);
        return result;
    }
}
