import numpy as np

def create_and_print_consecutive_array(start, end):
    consecutive_array = np.arange(start, end+1)
    return consecutive_array

start_example = 2
end_example = 5
create_and_print_consecutive_array(start_example, end_example)