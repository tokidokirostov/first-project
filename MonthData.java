import java.util.HashMap;

public class MonthData {
    HashMap<Integer, Integer> step = new HashMap<>();
    MonthData() {
        for (int i = 0; i < 30; i++) {
            step.put(i, 0);
        }
    }
}
