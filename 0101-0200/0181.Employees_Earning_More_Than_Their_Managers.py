#277ms




import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
    df = employee.merge(
        right = employee,
        how = 'inner',
        left_on = 'managerId',
        right_on = 'id'
    )
    emp = df[df['salary_x'] > df['salary_y']]['name_x']
    return pd.DataFrame({'Employee':emp})






#290ms






import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
    df=employee.merge(employee,left_on='managerId', right_on='id', how='left',suffixes=['_e','_m'])
    df=df.loc[df['salary_e']>df['salary_m'],['name_e']]
    return df.rename({'name_e':'Employee'},axis=1)
