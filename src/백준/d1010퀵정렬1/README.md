## 퀵정렬1
https://www.acmicpc.net/problem/24090

### 문제
오늘도 서준이는 퀵 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 퀵 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 교환되는 수를 구해서 우리 서준이를 도와주자.

크기가 N인 배열에 대한 퀵 정렬 의사 코드는 다음과 같다.

``` c
quick_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
    if (p < r) then {
    q <- partition(A, p, r);  # 분할
    quick_sort(A, p, q - 1);  # 왼쪽 부분 배열 정렬
    quick_sort(A, q + 1, r);  # 오른쪽 부분 배열 정렬
    }
}

partition(A[], p, r) {
    x <- A[r];    # 기준원소
    i <- p - 1;   # i는 x보다 작거나 작은 원소들의 끝지점
    for j <- p to r - 1  # j는 아직 정해지지 않은 원소들의 시작 지점
    if (A[j] ≤ x) then A[++i] <-> A[j]; # i값 증가 후 A[i] <-> A[j] 교환
    if (i + 1 != r) then A[i + 1] <-> A[r]; # i + 1과 r이 서로 다르면 A[i + 1]과 A[r]을 교환
    return i + 1;
}
```