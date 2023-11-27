import java.util.Arrays;

class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        int idx2 = 0;
        while(idx < A.length && idx2 < B.length){
            if(A[idx] < B[idx2]) {
                answer++;
                idx++;
                idx2++;
            } else if (A[idx] >= B[idx2]) {
                idx2++;
            }
        }
        return answer;
    }
}
