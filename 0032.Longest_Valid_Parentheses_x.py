#60.64% run time

class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """

        # longest valid string 

        #  0 1 2 3  4  5  6  7
        #  ( ) ) (  (  (  )  )

        # # st=[]

        # # st.append(-1)
        #           3
        # #st -->   2

        st=[]
        # keep track of indices 

        st.append(-1)
        maxlen = 0
        for idx,char in enumerate(s):
            # cases open ( and close ) encountered ::
            # close braces -->? pop from stack , then cases: st empty and not empty 

            if char == '(':
                st.append(idx)
            else:
                st.pop()

                if not st:
                    st.append(idx)
                else:
                    # calculate maxlen 
                    maxlen = max(maxlen , idx - st[-1])

        print(maxlen)
        return maxlen 
