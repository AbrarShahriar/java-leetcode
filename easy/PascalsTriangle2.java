import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static void main(String[] args) {
        System.out.println(getRow(3).toString());
    }

    static List<Integer> getRow(int rowIndex) {
        int numOfRows = rowIndex + 1;
        List<List<Integer>> arr = new ArrayList<>(numOfRows);
        List<Integer> prev = new ArrayList<>(numOfRows);

        for (int i = 0; i < numOfRows; i++) {
            if (i == 0) {
                prev.add(1);
                arr.add(prev);
                continue;
            }

            List<Integer> inner = new ArrayList<>(i + 1);

            // First will be 1
            inner.add(1);

            // For inner elements
            for (int j = 1; j < i; j++) {
                inner.add(prev.get(j - 1) + prev.get(j));
            }

            // Last will be 1
            inner.add(1);

            prev = inner;
            arr.add(prev);
        }

        return arr.getLast();
    }
}
