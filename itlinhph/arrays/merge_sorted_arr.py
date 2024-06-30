# https://leetcode.com/problems/merge-sorted-array/

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        p1 = m - 1
        p2 = n - 1
        cur = len(nums1) - 1
        while p2 >= 0:
            if p1 >= 0 and nums1[p1] > nums2[p2]:
                nums1[cur] = nums1[p1]
                p1 -= 1
            else:
                nums1[cur] = nums2[p2]
                p2 -= 1
            cur -= 1
        
        return nums1
    
if __name__ == "__main__":
    sol = Solution()

    print(sol.merge(nums1=[2,0], m=1, nums2=[1], n=1))
    
    assert sol.merge(nums1=[1,2,3,4,0,0], m=3, nums2=[2,5,6], n=3) == [1,2,2,3,5,6]
    assert sol.merge(nums1=[2,0], m=1, nums2=[1], n=1) == [1,2]