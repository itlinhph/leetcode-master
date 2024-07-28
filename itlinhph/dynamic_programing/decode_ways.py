# https://leetcode.com/problems/decode-ways/description/

class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """

        # Fibonaxi with conditions
        if s[0] == "0":
            return 0
        elif len(s) == 1 and 0 < int(s) < 10:
            return 1
        f0, f1 = 1, 1
        for i in range(1, len(s)):
            one_digit = int(s[i])
            two_digit = int(s[i-1:i+1])
            fi = 0
            if 0 < one_digit < 10:
                fi += f1 # f(i) = f(i-1) -> if we have only one choice one digit (can not get two digit) -> just get the same value as f(i-1)
            if 9 < two_digit < 27:
                fi += f0 # f(i) = f(i-2) + f(i-1) like fibonaxi, because we have two ways to choice: 1,2 or 12
            if two_digit in (0, 30, 40, 50, 60, 70, 80, 90):
                return 0
            f0 = f1
            f1 = fi
            
        return f1


if __name__ == "__main__":
    sol = Solution()
    print(sol.numDecodings("11276"))