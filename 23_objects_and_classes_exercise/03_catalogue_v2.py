class Catalogue:
    def __init__(self, name):
        self.name = name
        self.products = []

    def add_product(self, product_name):
        self.products.append(product_name)

    def get_by_letter(self, first_letter):
        new_list = []
        for names in self.products:
            if names[0] == first_letter:
                new_list.append(names)
        return new_list

    def __repr__(self):
        self.products.sort()
        result = f"Items in the {self.name} catalogue:\n"
        result += "\n".join(self.products)
        return result


catalogue = Catalogue("Furniture")
catalogue.add_product("Sofa")
catalogue.add_product("Mirror")
catalogue.add_product("Desk")
catalogue.add_product("Chair")
catalogue.add_product("Carpet")
print(catalogue.get_by_letter("C"))
print(catalogue)
