#263ms




import pandas as pd

def delete_duplicate_emails(person: pd.DataFrame) -> None:
    # Step 1: Sort by id (ascending order)
    person.sort_values(by='id', inplace=True)

    # Step 2: Drop duplicates based on email column (keep first occurrence)
    person.drop_duplicates(subset=['email'], inplace=True)






#262ms






import pandas as pd

def delete_duplicate_emails(person: pd.DataFrame) -> None:
    person.sort_values('id' , inplace = True)
    person.drop_duplicates(subset=['email'], keep = 'first', inplace = True)
