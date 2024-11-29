# Deep Space 

## Problem Description

You're a space observer in a deep space station called Deep Space One. As such, you receive data from complex equipment that scans the space and detects various objects.

### Input

The input is presented in a matrix where every element represents part of the visible field. The matrix is defined by several strings consisting of a combination of the characters below until you read the word "end":

- Uppercase letters: `O B A F G K M L T Y` (representing star types)
- Digits `1..9` (representing the number of planets in a segment)
- `#` (representing expected asteroids)
- `$` (representing expected comets)
- `.` (representing empty segments)

Immediately after the "end" there will be a single word consisting of one or more characters from above. Each character from this word indicates the characters in the matrix that must be replaced with `+`.

### Output

The final output must include:

1. **Total number of stars detected in the initial matrix**, followed by the number of stars for each type in alphabetical order.
2. **Total number of planets detected** in the initial matrix.
3. **Total number of asteroids and comets** from the initial matrix.
4. **The new matrix** after applying the replacement.

### Hints

- The input is guaranteed to be correct.
- Sum the number of planets in each segment (e.g., segments `1` and `9` result in a total of `10` planets).





<img width="812" alt="deep_space_1_2" src="https://github.com/svetlanasieber/Software-Engineering--Path-SoftUni/assets/135451084/f85897d9-6c96-495b-aca9-b5b8bd2a2439">


<img width="442" alt="deep_space_3" src="https://github.com/svetlanasieber/Software-Engineering--Path-SoftUni/assets/135451084/c72dd32d-29d1-435e-94e2-8c1a3b67481a">
