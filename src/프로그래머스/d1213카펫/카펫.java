import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int finalArea = brown + yellow;
        
        for(int[] arr : getDivisor(finalArea)) {
            int width = arr[0];
            int height = arr[1];
            int fakeYellow = 0;
            if (width > 2) {
                fakeYellow = (width - 2) * (height);
                fakeYellow -= ((width - 2) * 2);
            }
            if (fakeYellow == yellow) {
                answer[0] = width;
                answer[1] = height;
                return answer;
            }
        }
        return new int[]{};
    }
    
    private List<int[]> getDivisor(int a) {
        List<int[]> result = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                result.add(new int[]{a / i, i});
            }
        }
        return result;
    }
}
