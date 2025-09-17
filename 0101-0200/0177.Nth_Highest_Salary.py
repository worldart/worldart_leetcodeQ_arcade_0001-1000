#260ms





import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    unique_salaries = employee['salary'].drop_duplicates().sort_values(ascending=False)
    return pd.DataFrame({f'getNthHighestSalary({N})': [unique_salaries.iloc[N-1]]}) if (N <= len(unique_salaries) )& (N>0) else pd.DataFrame({f'getNthHighestSalary({N})': [None]})















