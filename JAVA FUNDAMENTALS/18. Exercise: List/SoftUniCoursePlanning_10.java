import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

      
        String input = scanner.nextLine();
        while (!input.equals("course start")) {

            String[] commandParts = input.split(":");
            String commandName = commandParts[0];
            String lesson = commandParts[1];

            switch (commandName) {
                case "Add":
                    if (!lessons.contains(lesson)) {
                        lessons.add(lesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandParts[2]);
                    if (!lessons.contains(lesson)) {
                        lessons.add(index, lesson);
                    }
                    break;
                case "Remove":
                    lessons.remove(lesson);
                    lessons.remove(lesson + "-Exercise");
                    break;
                case "Swap":
                    String lesson2 = commandParts[2];
                    if (lessons.contains(lesson) && lessons.contains(lesson2)) {
                        int indexFirst = lessons.indexOf(lesson);
                        int indexSecond = lessons.indexOf(lesson2);

                        lessons.set(indexFirst, lesson2);
                        lessons.set(indexSecond, lesson);

                        String firstLessonExercise = lesson + "-Exercise";
                        String secondLessonExercise = lesson2 + "-Exercise";

                        if (lessons.contains(firstLessonExercise)) {
                            lessons.remove(firstLessonExercise);
                            lessons.add(indexSecond + 1, firstLessonExercise);
                        }

                        if (lessons.contains(secondLessonExercise)) {
                            lessons.remove(secondLessonExercise);
                            lessons.add(indexFirst + 1, secondLessonExercise);
                        }
                    }
                    break;
                case "Exercise":
                    String exerciseName = lesson + "-Exercise";
                    if (lessons.contains(lesson)) {
                        if (!lessons.contains(exerciseName)) {
                            int indexOfTheLesson = lessons.indexOf(lesson);
                            lessons.add(indexOfTheLesson + 1, exerciseName);
                        }
                    } else {
                        lessons.add(lesson);
                        lessons.add(exerciseName);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        int number = 1;
        for (String lesson : lessons) {
            System.out.println(number + "." + lesson);
            number++;
        }
    }
}
