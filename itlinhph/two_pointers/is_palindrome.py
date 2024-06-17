class Solution:
    def isPalindrome(self, s: str) -> bool:
        # use two pointers to validate string
        left, right = 0, len(s) - 1
        while left < right:
            while left < right and not s[left].isalnum():
                left += 1
            while left < right and not s[right].isalnum():
                right -= 1
            if s[left].lower() != s[right].lower():
                return False
            left  += 1
            right -= 1

        return True


if __name__ == "__main__":
    slist = ["Was it a car or a cat I saw", "tab a cat", "A man, a plan, a canal: Panama", "0P"]

    sol = Solution()
    assert sol.isPalindrome(slist[0]) is True
    assert sol.isPalindrome(slist[1]) is False
    assert sol.isPalindrome(slist[2]) is True
    assert sol.isPalindrome(slist[3]) is False