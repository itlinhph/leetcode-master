class Solution:
    def isPalindrome(self, s: str) -> bool:
        # standalize string
        new_s = ""
        for char in s:
            if char.isalpha() or (ord('0') <= ord(char) <= ord('9')):
                new_s += char.lower()
        # use two pointers to validate string
        right = len(new_s) - 1
        for left in range(0, len(new_s)//2):
            if new_s[left] != new_s[right]:
                return False
            left += 1
            right -=1

        return True


if __name__ == "__main__":
    slist = ["Was it a car or a cat I saw", "tab a cat", "A man, a plan, a canal: Panama", "0P"]

    sol = Solution()
    print(sol.isPalindrome(slist[3]))
    assert sol.isPalindrome(slist[0]) is True
    assert sol.isPalindrome(slist[1]) is False
    assert sol.isPalindrome(slist[2]) is True