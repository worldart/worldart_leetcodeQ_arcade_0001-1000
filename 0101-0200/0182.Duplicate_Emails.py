#275ms






import pandas as pd


def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:
    results = pd.DataFrame()

    results = person.loc[person.duplicated(subset=["email"]), ["email"]]

    return results.drop_duplicates()





#281ms






import pandas as pd

def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:
    mask = person['email'].value_counts()
    counts = mask[mask > 1].index
    return pd.DataFrame({"Email":counts})
