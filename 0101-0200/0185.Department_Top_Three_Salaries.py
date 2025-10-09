#349ms





import pandas as pd

def top_three_salaries(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    df = pd.merge(employee,department,left_on='departmentId',right_on='id',how = 'left',suffixes = ('_emp','_dep'))
    df['rank'] = df.groupby('departmentId')['salary'].rank(method = 'dense',ascending = False)
    return df[df['rank']<= 3][['name_dep','name_emp','salary']].rename(columns = {'name_dep':'Department','name_emp':'Employee','salary':'Salary'})








#366ms







import pandas as pd

def top_three_salaries(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    df = employee[employee.groupby('departmentId')['salary'].rank(method='dense', ascending=False) <=3]
    #df = employee[employee['rank'] <4]
    df = df.merge(department, left_on='departmentId', right_on='id')
    df = df.rename(columns = {'name_y':'Department', 'name_x': 'Employee', 'salary_x': 'Salary'})
    return df[['Department','Employee', 'salary']]

    top_salary = employee[employee.groupby('departmentId').salary.rank(method='dense', ascending=False) <= 3]
