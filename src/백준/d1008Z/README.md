## Z
https://www.acmicpc.net/problem/1074


### 문제
한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.

![image](https://github.com/sunsik17/Algorithm/assets/117346927/ef44fdbc-060c-4528-88b9-e96436922ca0)


N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.

다음 예는 22 × 22 크기의 배열을 방문한 순서이다.

![image](https://github.com/sunsik17/Algorithm/assets/117346927/2e407789-ba77-4818-8a5d-5f01cae0d39c)


N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

다음은 N=3일 때의 예이다.

![image](https://github.com/sunsik17/Algorithm/assets/117346927/873c5aaf-1549-41d3-b78f-4708e7061fcb)
