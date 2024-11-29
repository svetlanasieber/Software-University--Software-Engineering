# objasnenie na range() function v for-loop
# for-loop s range() se izpolzva za da obhojda kolekcii lists s indexi
# da ni pokaje duljinata na dumata

# word = input()
# for index in range(len(word) -1, -1, -1):
#    print(index)

# tuk printira indecite, no nie iskame elementite
# word = input()
# reversed_word = ""

# for index in range(len(word) -1, -1, -1):
#    reversed_word += word[index]
#    print(word[index], end="") #na nov red s end=""
# print(reversed_word)

# reshenie bez for-loop vuobshte.
# tochno tozi variant e naj pythonskia
# njama smisul da vurtim cikli, kogato ne e nujno

# Предоставеният от вас фрагмент от код на Python чете дума от
# конзолата и отпечатва нейната обратна страна. Нека да го разбием:
#
# word = input(): Този ред чете низ от конзолата и го съхранява в променливата word.
#
# print(word[::-1]): Този ред използва нотацията на Python slice, за да обърне низ.
#
# [::-1] е парче, което започва от края към първия елемент и обръща низа.


word = input()
print(word[::-1])  # Lists Advanced shte se govori za tova. Vzemi stringa naobratno!!!
# tova e List slising
