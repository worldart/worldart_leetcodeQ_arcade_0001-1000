#277ms






import pandas as pd

def rising_temperature(weather: pd.DataFrame) -> pd.DataFrame:
    weather.sort_values(by='recordDate', inplace=True)
    return weather[
        (weather.temperature.diff() > 0)
      & (weather.recordDate.diff().dt.days == 1)
    ][['id']]







#281ms






import pandas as pd

def rising_temperature(weather: pd.DataFrame) -> pd.DataFrame:
    weather.sort_values("recordDate", inplace=True)
    weather["temp_diff"] = weather["temperature"].diff()
    weather["prev_day"] = weather["recordDate"].shift(1)

    weather["has_prev_day"] = (weather["recordDate"] - weather["prev_day"])== pd.Timedelta(days=1)

    return weather[(weather["has_prev_day"]) & (weather["temp_diff"] > 0)][["id"]]
