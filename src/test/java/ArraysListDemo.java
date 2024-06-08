import java.util.Arrays;
import java.util.List;

public class ArraysListDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 23);
        List<Integer> integers = List.of(1, 2, 3);
        try {
            list.add(2);// add or remove
        } catch (Exception e) {
           e.printStackTrace();
        }
        try {
            integers.remove(8);// add or remove
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
