# https://app.codility.com/programmers/trainings/5/parity_degree/


def solution(N):
    # Implement your solution here
    twopowerk = 1
    k = 0
    result = 0
    while twopowerk <= N:
        if N%twopowerk == 0:
            result = k
        twopowerk = twopowerk<<1 # bitwise multiple by 2
        k+=1

    return result


if __name__ == "__main__":
    print(solution(48))