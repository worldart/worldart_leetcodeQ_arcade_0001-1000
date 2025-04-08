//0ms


int mySqrt(int x) {
    /* 
    =================================================
    Deriving the equation for the numerical approach
    =================================================
    m = dy/dx = (y - y') / (x - x'), where y' = 0
    ==> Newton's method latches on to the new x by finding the solution of a tangent line.
    f'(x) = f(x) / (x - x')
    x' = x - f(x) / f'(x)
    
    =================================================
    Rewriting the f(x) for solving sqrt(a)
    =================================================
    y = sqrt(x) ==> same as solving y^2 - x = 0, where x = a (a constant input provided)
    Re-write to x^2 - a = 0 = f(x)
    f'(x) = 2x
    f(x) = x^2 - a
    
    Finally, x' = x - (x * x - a) / 2x, where x' is the "new" x
     */
    if (!x) return 0;

    float a = (float)x;
    float prev = (float)x / 2.0; // Half of x is a good starting point
    float curr;
    float diff = 1.0;
    float eps = 1e-2; // 1e-2 is good enough

    while (diff > eps)
    {
        curr = prev - (prev * prev - a) / (prev * 2);
        diff = fabs(curr - prev); // Note here, fabs() instead of abs(), which is only for int's
        prev = curr;
    }
    
    // For truncation - Special for the test cases, it actually forces to a less accurate solution.
    int prevInt = (int)prev;
    if (prevInt > x / prevInt) --prevInt;
    return prevInt;
}
