class Solution:
    def isPalindrome(self, s: str) -> bool:
        right = len(s) - 1
        for left in range(0, len(s)//2):
            if s[left] != s[right]:
                return False
            left += 1
            right -=1

        return True


if __name__ == "__main__":
    slist = ["Was it a car or a cat I saw", "tab a cat", "A man, a plan, a canal: Panama"]

    sol = Solution()
    for i, s in enumerate(slist):
        new_s = ""
        for char in s:
            if char.isalpha():
                new_s += char.lower()
        slist[i] = new_s
    assert sol.isPalindrome(slist[0]) is True
    assert sol.isPalindrome(slist[1]) is False
    assert sol.isPalindrome(slist[2]) is True