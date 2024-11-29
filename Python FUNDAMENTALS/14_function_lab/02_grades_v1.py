def grade_in_words(grade):
    result = ""
    if grade < 2:
        pass
    elif grade < 3:
        result = "Fail"
    elif grade < 3.5:
        result = "Poor"
    elif grade < 4.5:
        result = "Good"
    elif grade < 5.5:
        result = "Very Good"
    elif grade <= 6:
        result = "Excellent"
    return result


grade_value = float(input())
print(grade_in_words(grade_value))
