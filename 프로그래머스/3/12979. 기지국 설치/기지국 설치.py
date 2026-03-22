def solution(n, stations, w):
    answer = 0

    idx = 1
    l = w * 2 + 1
    for station in stations:
        tmp = station - w
        if tmp > idx:
            if (tmp - idx) % l == 0:
                answer += ((tmp - idx) // l)
            else:
                answer += ((tmp - idx) // l) + 1
        
        
        idx = station + w + 1
    
    if idx <= n:
        diff = n - idx + 1
        if diff % l == 0:
            answer += diff // l
        else:
            answer += diff // l + 1
            

    return answer