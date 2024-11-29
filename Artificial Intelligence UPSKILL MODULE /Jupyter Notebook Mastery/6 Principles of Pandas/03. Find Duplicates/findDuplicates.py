import pandas as pd


N = 4  
sequence_of_integers = [3, 4, 5, 6]

series = pd.Series(sequence_of_integers)
has_duplicates = series.duplicated().any()

print(has_duplicates)
