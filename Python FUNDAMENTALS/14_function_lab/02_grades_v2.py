def grade_to_words(grade):
    result = None
    if 2.00 <= grade <= 2.99:  # grade < 3
        result = "Fail"
    elif 3.00 <= grade <= 3.49:
        result = "Poor"
    elif 3.50 <= grade <= 4.49:
        result = "Good"
    elif 4.50 <= grade <= 5.49:
        result = "Very Good"
    elif 5.50 <= grade <= 6.00:
        result = "Excellent"
    return result


grade_data = float(input())
print(grade_to_words(grade_data))
