class MainClass:
    @staticmethod
    def Main():
        command = input()

        bestPlayer = ""
        bestScore = 0

        while command != "END":
            playerName = command
            count_of_goals = int(input())

            if count_of_goals > bestScore:
                bestScore = count_of_goals
                bestPlayer = playerName

            if count_of_goals >= 10:
                break

            command = input()

        print(f"{bestPlayer} is the best player!")

        if bestScore >= 3:
            print(f"He has scored {bestScore} goals and made a hat-trick !!!")
        else:
            print(f"He has scored {bestScore} goals.")


MainClass.Main()
