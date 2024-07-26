# https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

class Solution(object):
    def numberOfSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        # "aabcabc" aabccab
        l, r = 0, 0
        # make a hashmap to keeptrack the number of a,b,c
        count_abc = {
            "a": 0,
            "b": 0,
            "c":0
        }
        result = 0
        if len(s) == 0:
            return 0
        count_abc[s[0]] = 1
        # use slide windows to check enough characters in windows, if not move right pointer till enough character in hashmap
        # then calculate the number of substring after right windows = len(s) - right pointer
        while l < len(s): 
            if count_abc["a"] and count_abc["b"] and count_abc["c"]:
                result += len(s) - r
                count_abc[s[l]] -= 1
                l +=1
            elif r == len(s) - 1:
                count_abc[s[l]] -= 1
                l +=1
            else:
                r +=1
                count_abc[s[r]] += 1

        return result

if __name__ == "__main__":
    sol = Solution()
    assert sol.numberOfSubstrings("abcabc") == 10
    assert sol.numberOfSubstrings("aaacb") == 3
    assert sol.numberOfSubstrings("abc") == 1