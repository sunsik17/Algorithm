import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] result = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, (x,y) -> (y+x).compareTo(x+y));

        if ("0".equals(result[0])){
            return "0";
        }
        for (int i = 0; i < result.length; i++) {
            answer.append(result[i]);
        }
        return answer.toString();
    }
}