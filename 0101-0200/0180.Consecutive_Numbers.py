#377ms





import pandas as pd

def consecutive_numbers(logs: pd.DataFrame) -> pd.DataFrame:
    
    logs['var'] = logs.num.rolling(window=3).var()

    return pd.DataFrame(data = {'ConsecutiveNums' : logs.query('var == 0').num.unique()})






#258ms






import pandas as pd

def consecutive_numbers(logs: pd.DataFrame) -> pd.DataFrame:
    back_num = None
    num_of_dub = 0
    res =[]
    for i in logs['num']:
        if i == back_num:
            num_of_dub += 1
            back_num = i
            if num_of_dub == 3:
                res.append(i)

        else:
            back_num = i
            num_of_dub = 1

    res = set(res)
    res = list(res)
    res.sort()
    res_df = pd.DataFrame(dict(ConsecutiveNums=res) )
    return res_df
    
