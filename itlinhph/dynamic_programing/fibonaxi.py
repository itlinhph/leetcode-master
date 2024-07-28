class Solution():
    def fibo_dp(self, n):
        f0, f1 = 0, 1
        for _ in range(1,n):
            tmp = f1
            f1 +=f0
            f0 = tmp
        return f1
    
    def fibo_memorization(self, n, cache={}):
        if n in (0,1):
            return n
        if n in cache:
            return cache[n]
        fn = self.fibo_memorization(n-1, cache=cache) + self.fibo_memorization(n-2, cache=cache)
        cache[n] = fn
        return fn
        
    
if __name__ == "__main__":
    sol = Solution()
    print(sol.fibo_dp(6))
