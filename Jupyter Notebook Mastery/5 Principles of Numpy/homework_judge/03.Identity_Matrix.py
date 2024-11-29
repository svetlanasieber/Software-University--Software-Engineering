import numpy as np

def create_and_print_identity_matrix(N):
    identity_matrix = np.eye(N)
    return identity_matrix

N_example = 3
create_and_print_identity_matrix(N_example)