# Fishes Problem

## Problem Description

You're watching a beautiful river flow and notice plenty of fishes. The river flow splits into two parts:
- **Flow A**: Whirls any fish that enters so that the last fish to enter swims out first.
- **Flow B**: Follows a normal order where any fish swims through following the previous fishes.

You note each fish with its name and then a char: A or B. Your notes finish with "end" as the fish name. Your task is to read all the data about the fishes and output the two flows in the order in which the fishes will come out.

### Input

- Fish names followed by a character (A or B) indicating which flow they enter.
- Ends with the word "end".

### Output

- Print the fishes in **Flow A** in the order they will come out (last fish to enter comes out first).
- Print the fishes in **Flow B** in the order they will come out (first fish to enter comes out first).



**Explanation**

Nemo, Dory, Coral, Bubbles, and Finn go to Flow A. Marlin, Goldie, and Splash go to Flow B.
- Flow A: The last fish to enter (Finn) comes out first, followed by Bubbles, Coral, Dory, and Nemo.
- Flow B: The fishes come out in the order they entered (Marlin, Goldie, Splash).


<img width="799" alt="fisher_example1" src="https://github.com/svetlanasieber/Software-Engineering--Path-SoftUni/assets/135451084/7fd1dd80-f0c1-4d4a-9407-668e782e942c">
<img width="392" alt="3" src="https://github.com/svetlanasieber/Software-Engineering--Path-SoftUni/assets/135451084/8dc0ebf4-0831-419a-9ab2-e5ecd02a610f">
