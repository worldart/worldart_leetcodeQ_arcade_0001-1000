#325ms





import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    #First, we merge the employee and department dataframes 
    #using an inner join (default for merge)
    merged_df = employee.merge(department, left_on = 'departmentId', right_on = 'id')

    #Second, we rename the columns 
    #and take only the department, employee, and salary columns
    merged_df = merged_df.rename(columns = {'name_x': 'Employee', 'name_y': 'Department', 'salary': 'Salary'})[['Department', 'Employee', 'Salary']]
    
    return merged_df[merged_df['Salary'] == merged_df.groupby('Department')['Salary'].transform(max)]





#310ms




import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    merged_tbl = pd.merge(employee, department, how = 'right', left_on = 'departmentId', right_on = 'id')
    
    merged_tbl['rank'] = merged_tbl.groupby(by = 'name_y')['salary'].rank(method =   'dense', ascending=False)

    merged_tbl = merged_tbl[merged_tbl['rank'] == 1].rename(columns = {
            "name_y" : "Department",
            "name_x" : "Employee",
            "salary" : "Salary"
        })[['Department', 'Employee', 'Salary']]

    return merged_tbl
    
