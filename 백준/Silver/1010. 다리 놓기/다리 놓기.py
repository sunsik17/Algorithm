T = int(input())
result = []
dp = [[0 for _ in range(31)] for _ in range(31)]

for i in range(0, 31):
    for j in range(0, i + 1):
        if j == 0 or j == i:
            dp[i][j] = 1
        else:
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]


while T > 0:
    T -= 1
    N, M = map(int, input().split())
    result.append(str(dp[M][N]))

answer = '\n'.join(result)
print(answer)
