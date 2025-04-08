#28.2% run time

class Solution(object):
	def longestValidParentheses(self, s):
		"""
		:type s: str
		:rtype: int
		"""
		m = l = r = 0
		for e in s:
			if e=='(':
				l+=1
			else:
				r+=1
			if l==r:
				m = max(m,r+l)
			elif r>l:
				l=r=0
		l=r=0
		for e in s[::-1]:
			if e==')':
				r+=1
			else: 
				l+=1
			if l==r: 
				m=max(m,r+l)
			elif l>r:
				l=r=0
		return m
