class Cat:
    def __init__(self, breed, gender):
        self.breed = breed
        self.gender = gender
        self.lifespan = {
            "British Shorthair": {"m": 13, "f": 14},
            "Siamese": {"m": 15, "f": 16},
            "Persian": {"m": 14, "f": 15},
            "Ragdoll": {"m": 16, "f": 17},
            "American Shorthair": {"m": 12, "f": 13},
            "Siberian": {"m": 11, "f": 12}
        }

    def calculate_cat_months(self):
        if self.breed in self.lifespan and self.gender in self.lifespan[self.breed]:
            human_years = self.lifespan[self.breed][self.gender]
            human_months = human_years * 12
            cat_months = human_months // 6
            return f"{cat_months} cat months"
        else:
            return f"{self.breed} is invalid cat!"

def main():
    breed = input()
    gender = input()

    cat = Cat(breed, gender)
    result = cat.calculate_cat_months()
    print(result)

if __name__ == "__main__":
    main()
