#	Брой страници в текущата книга – цяло число в интервала [1…1000]
#	Страници, които прочита за 1 час – цяло число в интервала [1…1000]
#	Броят на дните, за които трябва да прочете книгата – цяло число в интервала [1…1000]

# колко часа на ден трябва да отделя, за да прочете необходимата литература.
# Да се отпечата на конзолата броят часове hours_per_day, които Жоро трябва да отделя за четене всеки ден.

number_of_book_pages = int(input())
pages_per_hour = int(input())
numbers_of_days = int(input())

# Трябва да разберем, колко часа са му необходими за да прочете цялата книга
needed_hours_to_read_a_book = number_of_book_pages / pages_per_hour
hours_per_day = needed_hours_to_read_a_book / numbers_of_days

print(int(hours_per_day))
