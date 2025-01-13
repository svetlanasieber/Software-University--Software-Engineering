def resolve_conditional(expression):

    expression = expression.replace(" ", "")

    def evaluate_expression(expr):

        if expr in ['t', 'f']:
            return 't' if expr == 't' else 'f'
        elif expr.isdigit():
            return expr


        depth = 0
        main_question_mark = -1
        main_colon = -1
        for i, char in enumerate(expr):
            if char == '?':
                if depth == 0:
                    main_question_mark = i
                depth += 1
            elif char == ':':
                depth -= 1
                if depth == 0:
                    main_colon = i
                    break


        condition = expr[:main_question_mark]
        true_part = expr[main_question_mark + 1:main_colon]
        false_part = expr[main_colon + 1:]


        if evaluate_expression(condition) == 't':
            return evaluate_expression(true_part)
        else:
            return evaluate_expression(false_part)


    return evaluate_expression(expression)

if __name__ == "__main__":
    input_expression = input()
    result = resolve_conditional(input_expression)
    print(result)
