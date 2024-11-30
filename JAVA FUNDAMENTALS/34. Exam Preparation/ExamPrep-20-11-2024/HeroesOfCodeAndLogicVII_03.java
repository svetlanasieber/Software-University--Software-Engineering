package ExamPrep;

import java.util.*;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        int numberOfHeroes = Integer.parseInt(scanner.nextLine());

       
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();

       
        for (int i = 1; i <= numberOfHeroes ; i++) {

            //"{hero name} {HP} {MP}"
            String [] heroData = scanner.nextLine().split("\\s+");
            String currentHeroName = heroData[0];
            int currentHitPoints = Integer.parseInt(heroData[1]);
            int currentManaPoints = Integer.parseInt(heroData[2]);

         
            if(currentHitPoints > 100){
                currentHitPoints = 100;
            }

            if(currentManaPoints > 200){
                currentManaPoints = 200;
            }

           
            List<Integer> currentHeroPoints = new ArrayList<>();
            //hit points -> index 0
            currentHeroPoints.add(currentHitPoints);
            //mana points -> index 1
            currentHeroPoints.add(currentManaPoints);
            heroes.put(currentHeroName, currentHeroPoints);

        }

        String command = scanner.nextLine();

        while (!command.equals("End")){
          
            String [] commandData = command.split(" - ");

         
            String currentCommand = commandData[0];
          
            String heroName = commandData[1];

            
            switch (currentCommand){
                case "CastSpell" -> {
                  
                    int neededMP = Integer.parseInt(commandData[2]);
                  
                    String spellName = commandData[3];
                 
                    int currentHeroMP = heroes.get(heroName).get(1);
                 
                    int manaPointsLeft = currentHeroMP - neededMP;

                  
                    if(manaPointsLeft >= 0){
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, manaPointsLeft);
                       
                        heroes.get(heroName).remove(1);
                        heroes.get(heroName).add(manaPointsLeft);
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                }
                case "TakeDamage" -> {

                    //TakeDamage – {hero name} – {damage} – {attacker}
                    int damage = Integer.parseInt(commandData[2]);
                    String attacker = commandData[3];
                  
                    int currentHeroHitPoint = heroes.get(heroName).get(0);
                   
                    int hitPointsLeft = currentHeroHitPoint - damage;

                   
                    if(hitPointsLeft > 0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, hitPointsLeft);
                        heroes.get(heroName).remove(0);
                        heroes.get(heroName).add(0, hitPointsLeft);

                    }else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroes.remove(heroName);
                    }

                }
                case "Recharge" -> {

                    //Recharge – {hero name} – {amount}
                    int amountMP = Integer.parseInt(commandData[2]);
                    int currentHeroMP = heroes.get(heroName).get(1);
                    int finalMP = amountMP + currentHeroMP;

                    if(finalMP > 200){
                        finalMP = 200;
                        amountMP = 200 - currentHeroMP;
                    }
                    heroes.get(heroName).remove(1);
                    heroes.get(heroName).add(finalMP);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amountMP);

                }
                case "Heal" ->{

                    //Heal – {hero name} – {amount}
                    int amountHP = Integer.parseInt(commandData[2]);
                    int currentHeroHP = heroes.get(heroName).get(0);
                    int finalHP = amountHP + currentHeroHP;

                    if(finalHP > 100){
                        finalHP = 100;
                        amountHP = 100 - currentHeroHP;
                    }

                    heroes.get(heroName).remove(0);
                    heroes.get(heroName).add(0, finalHP);
                    System.out.printf("%s healed for %d HP!%n", heroName, amountHP);

                }
            }


            command = scanner.nextLine();
        }


        heroes.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    System.out.printf("  HP: %d%n", entry.getValue().get(0));
                    System.out.printf("  MP: %d%n", entry.getValue().get(1));
                });







    }
}
