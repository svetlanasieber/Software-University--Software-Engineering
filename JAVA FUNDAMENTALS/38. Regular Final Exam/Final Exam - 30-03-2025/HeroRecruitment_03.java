package FinalExam_30_03_2025;

import java.util.*;

public class HeroRecruitment_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroes = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "Enroll":
                    if (heroes.containsKey(heroName)) {
                        System.out.println(heroName + " is already enrolled.");
                    } else {
                        heroes.put(heroName, new ArrayList<>());
                    }
                    break;

                case "Learn":
                    String spellName = tokens[2];
                    if (!heroes.containsKey(heroName)) {
                        System.out.println(heroName + " doesn't exist.");
                    } else if (heroes.get(heroName).contains(spellName)) {
                        System.out.println(heroName + " has already learnt " + spellName + ".");
                    } else {
                        heroes.get(heroName).add(spellName);
                    }
                    break;

                case "Unlearn":
                    spellName = tokens[2];
                    if (!heroes.containsKey(heroName)) {
                        System.out.println(heroName + " doesn't exist.");
                    } else if (!heroes.get(heroName).contains(spellName)) {
                        System.out.println(heroName + " doesn't know " + spellName + ".");
                    } else {
                        heroes.get(heroName).remove(spellName);
                    }
                    break;
            }
        }

        System.out.println("Heroes:");
        heroes.forEach((hero, spells) -> {
            System.out.print("== " + hero + ": ");
            if (!spells.isEmpty()) {
                System.out.print(String.join(", ", spells));
            }
            System.out.println();
        });
    }
}

