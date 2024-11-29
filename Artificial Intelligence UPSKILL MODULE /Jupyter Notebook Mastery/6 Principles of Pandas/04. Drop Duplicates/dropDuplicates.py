import pandas as pd

N = 3 

sequence_of_integers = [-100, 100, -100]
series = pd.Series(sequence_of_integers)
unique_series = series.drop_duplicates()

print(unique_series)
