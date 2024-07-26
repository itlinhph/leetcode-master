# https://app.codility.com/programmers/trainings/5/three_letters/ 

def solution(A, B):
    # Implement your solution here
    result = ""

    while A > 0 or B > 0:
        if len(result) > 1 and result[-1] == result[-2]:
            if result[-1] == "a":
                result +="b"
                B-=1
            else:
                result +="a"
                A-=1
            continue

        if A > B:
            result +="a"
            A-=1
        else:
            result +="b"
            B-=1

    return result