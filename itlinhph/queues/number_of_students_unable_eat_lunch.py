# https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

class Solution(object):
    def countStudents(self, students, sandwiches):
        """
        :type students: List[int]
        :type sandwiches: List[int]
        :rtype: int
        """

        # because the order of students is not important
        # so we just calculate the number of students 0 and students 1 then assign them into the sandwiches queue
        student0 = students.count(0)
        student1 = len(students) - student0
        for item in sandwiches:
            if item == 0:
                if student0 > 0:
                    student0 -=1
                else:
                    break
            else:
                if student1 > 0:
                    student1 -=1
                else:
                    break
        return student1 or student0

    
if __name__ == "__main__":
    sol = Solution()
    print(sol.countStudents(students=[1,1,0,0], sandwiches=[0,1,0,1]))
    assert sol.countStudents(students=[1,1,0,0], sandwiches=[0,1,0,1]) == 0
    assert sol.countStudents(students=[1,1,1,0,0,1], sandwiches=[1,0,0,0,1,1]) == 3
    assert sol.countStudents(students=[1,1,1,1], sandwiches=[1,1,0,1]) == 2