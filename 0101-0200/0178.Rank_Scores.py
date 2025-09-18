#281ms







import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:

    scores["rank"] = scores.score.rank(
                     method = "dense",ascending=False)

    return scores.sort_values("rank").iloc[:,[1,2]]
    






#288ms







import pandas as pd

def order_scores(df: pd.DataFrame) -> pd.DataFrame:
    df['rank']=df['score'].rank(method='dense',ascending=False)
    columns=['score','rank']
    df=df[columns]
    return df.sort_values('rank')
    
