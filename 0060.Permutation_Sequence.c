//100%RT

void GetFactorial(int* factorial, int n) {
    factorial[0] = 1;
    for (int i = 1; i <= n; i++) {
        factorial[i] = factorial[i - 1] * i;
    }
}
void GetIndexArray(int* factorial, int* index, int n, int k){
    for (int i = 0; i < n - 1; i++) {
        index[i] = k / factorial[n - i - 1];
        k = k % factorial[n - i - 1]; 
        printf("%d ",index[i]);
    }
}
void GetPermutation(int* index, char* perm, int n) {
    int used[n + 1];
    for (int i = 1; i <= n; i++) {
        used[i] = 0;
    }

    for (int i = 0; i < n - 1; i++) {
        int count = 0;
        for (int j = 1; j <= n; j++) {
            if (!used[j]) {
                if (count == index[i]) {
                    perm[i] = '0' + j;
                    used[j] = 1;
                    break;
                }
                count++;
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        if (!used[i]) {
            perm[n - 1] = '0' + i;
            break;
        }
    }

    perm[n] = '\0';
}
char* getPermutation(int n, int k) {
    char* perm = (char*)malloc((n + 1)* sizeof(char));
    int index [n];
    int factorial[n + 1]; // factorial[i] is factorial of i.

    GetFactorial(factorial, n);
    
    GetIndexArray(factorial, index, n, k - 1);

    GetPermutation(index, perm, n);
    return perm;
}
