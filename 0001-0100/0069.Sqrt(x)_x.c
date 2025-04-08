//0ms

int mySqrt(int x) {
    if (x < 1) return 0;
    else if (x == 1) return 1;
    
    int l = 1;
    int r = x;
    int mid;
    while (l < r)
    {
        mid = l + ((r - l) >> 1);
        if (mid < x / mid) l = mid;
        else if (mid > x / mid) r = mid;
        else return mid;

        // For convergence at l + 1 = r; iterating between l and r
        if (r - l == 1)
        {
            return l;
        }
    }
    return 0;
}
