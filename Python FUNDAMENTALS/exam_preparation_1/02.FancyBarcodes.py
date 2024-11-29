import re

barcodes_count = int(input())
barcode_pattern = r'(@#+)([A-Z][A-Za-z0-9]{4,}[A-Z])'

for _ in range(barcodes_count):
    sequence = input()
    match = re.search(barcode_pattern, sequence)

    if match:
        barcode = match.group(2)
        extract_digits = r'(\d+)'
        product_group_match = re.findall(extract_digits, barcode)

        if product_group_match:
            product_group = ''
            for digit_match in product_group_match:
                product_group += digit_match
            print(f'Product group: {product_group}')
        else:
            print('Product group: 00')

    else:
        print('Invalid barcode')