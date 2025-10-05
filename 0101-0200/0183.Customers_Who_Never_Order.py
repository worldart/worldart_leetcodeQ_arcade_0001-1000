#290ms




import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    
    ids=~customers.id.isin(orders.customerId)
    name=list(customers.name.loc[ids])
    return pd.DataFrame(name,columns=['customers'])
    




#334ms




import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    df=customers[~customers['id'].isin(orders['customerId'])]
    return df[['name']].rename(columns={'name':'Customers'})








#334ms




import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    customers.rename(columns={"id": "customerId"}, inplace=True)
    order =customers.merge(orders,on="customerId",how="outer",indicator=True).query("_merge=='left_only'")
    order.rename(columns={"name":"Customers"},inplace=True) 
    return order[["Customers"]]






