import re


def extract_numbers(input_text):
    
    numbers = re.findall(r'\d+', input_text)
    return numbers


def main():
    extracted_numbers = []

  
    while True:
        line = input()
        if not line:
            break

        extracted_numbers.extend(extract_numbers(line))

    print(' '.join(extracted_numbers))


if __name__ == "__main__":
    main()
