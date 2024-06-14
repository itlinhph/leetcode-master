# Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 1
        for right in range(1, len(nums)):
            if nums[right] == nums[right - 1]:
                continue
            nums[left] = nums[right]
            left += 1

        return left
    

if __name__ == "__main__":
    a = Solution()
    arr = [1,1,2]
    k = a.removeDuplicates(arr)
    print(k, arr) # [1,2]
    assert k == 2
    
    arr = [0,0,1,1,1,2,2,3,3,4]
    k = a.removeDuplicates(arr)
    print(k, arr) # [0,1,2,3,4]
    assert k == 5