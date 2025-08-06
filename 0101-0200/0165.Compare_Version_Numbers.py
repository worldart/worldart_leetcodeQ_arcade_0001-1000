#0ms





class Solution(object):
    def compareVersion(self, version1, version2):
        v1 = list(map(int, version1.split('.')))
        v2 = list(map(int, version2.split('.')))

        while len(v1) < len(v2):
            v1.append(0)
        while len(v2) < len(v1):
            v2.append(0)

        for a, b in zip(v1, v2):
            if a < b:
                return -1
            elif a > b:
                return 1

        return 0





#0ms





class Solution:
  def compareVersion(self, version1: str, version2: str) -> int:
    arr1 = version1.split(".") 
    arr2 = version2.split(".") 
    n = len(arr1)
    m = len(arr2)
    arr1 = [int(i) for i in arr1]
    arr2 = [int(i) for i in arr2]
    if n>m:
      for i in range(m, n):
         arr2.append(0)
    elif m>n:
      for i in range(n, m):
         arr1.append(0)
    
    for i in range(len(arr1)):
      if arr1[i]>arr2[i]:
         return 1
      elif arr2[i]>arr1[i]:
         return -1
    return 0
