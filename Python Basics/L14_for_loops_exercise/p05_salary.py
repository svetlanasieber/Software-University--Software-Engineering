# Според отворения сайт в таба се налагат следните глоби:
# •	"Facebook" -> 150 лв.
# •	"Instagram" -> 100 лв.
# •	"Reddit" -> 50 лв.

# От конзолата се четат два реда:
# •	Брой отворени табове в браузъра n - цяло число в интервала [1...10]
# •	Заплата - число в интервала [500...1500]

# След това n – на брой пъти се чете име на уебсайт – текст

# Изход
# •	Ако по време на проверката заплатата стане по-малка или равна на 0 лева, на конзолата се изписва
# "You have lost your salary." и програмата приключва.
# •	В противен случай след проверката на конзолата се изписва остатъкът от заплатата (да се изпише като цяло число).

# Read the number of opened tabs and initial salary from the input
n_tabs = int(input())
salary = int(input())

# Loop through each tab to check the website
for _ in range(n_tabs):
    website = input()
    if website == "Facebook":
        salary -= 150
    elif website == "Instagram":
        salary -= 100
    elif website == "Reddit":
        salary -= 50

    # Check if the salary is zero or negative, and if so, print a message and terminate the program
    if salary <= 0:
        print("You have lost your salary.")
        break
else:  # This will execute only if the loop wasn't broken (i.e., salary > 0)
    print(salary)

# Ето как работи кодът:
#
# Отчитаме броя на разделите и първоначалната заплата.
# Преминаваме през цикъл, като прочитаме уебсайта, отворен във всеки раздел.
# Изваждаме глобата от заплатата в зависимост от уебсайта.
# Проверяваме дали заплатата е станала нула или отрицателна.
# Ако е така, отпечатваме съобщение и излизаме от цикъла.
# Ако цикълът завърши без прекъсване (което означава, че заплатата все още е положителна),
# отпечатваме останалата заплата.