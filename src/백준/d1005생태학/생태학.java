import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class 생태학 {
    static Map<String, Integer> treeMap = new LinkedHashMap<>();
    static Map<String, Float> answer = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tree = "";
        int count = 0;
        while ((tree = br.readLine()) != null && !tree.equals("")) {
            treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
            count++;
        }

        int finalCount = count;
        treeMap.forEach(
                (k, v) -> answer.put(k, ((float) v / (float) finalCount) * 100)
        );

        List<String> keySet = new ArrayList<>(answer.keySet());
        keySet.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        keySet.forEach(
                k -> sb.append(k)
                        .append(' ')
                        .append(String.format("%.4f",answer.get(k)))
                        .append('\n')
        );

        System.out.println(sb);
    }
}
