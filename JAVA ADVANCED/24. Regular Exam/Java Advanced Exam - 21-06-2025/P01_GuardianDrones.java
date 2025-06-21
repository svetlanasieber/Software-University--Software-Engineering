import java.util.*;

public class P01_GuardianDrones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> drones = new LinkedHashMap<>();
        drones.put("Sentinel-X", 100);
        drones.put("Viper-MKII", 85);
        drones.put("Aegis-7", 75);
        drones.put("Striker-R", 65);
        drones.put("Titan-Core", 55);


        String[] partsInput = scanner.nextLine().split(" ");

        Deque<Integer> mechanicalParts = new ArrayDeque<>();

        for (String part : partsInput) {
            mechanicalParts.push(Integer.parseInt(part));
        }


        String[] cellsInput = scanner.nextLine().split(" ");

        Queue<Integer> powerCells = new ArrayDeque<>();

        for (String cell : cellsInput) {
            powerCells.offer(Integer.parseInt(cell));
        }


        List<String> assembledDrones = new ArrayList<>();

        Set<String> builtDrones = new HashSet<>();


        while (!mechanicalParts.isEmpty() && !powerCells.isEmpty() && assembledDrones.size() < 5) {

            while (!powerCells.isEmpty() && powerCells.peek() <= 0) {
                powerCells.poll();
            }

            if (powerCells.isEmpty()) {
                break;
            }

            int mechanicalPart = mechanicalParts.pop();
            int powerCell = powerCells.poll();
            int totalPower = mechanicalPart + powerCell;

            boolean droneBuilt = false;

            for (Map.Entry<String, Integer> drone : drones.entrySet()) {
                if (drone.getValue() == totalPower && !builtDrones.contains(drone.getKey())) {

                    assembledDrones.add(drone.getKey());
                    builtDrones.add(drone.getKey());
                    droneBuilt = true;
                    break;
                }
            }

            if (!droneBuilt) {

                String suitableDrone = null;
                int suitablePower = 0;

                for (Map.Entry<String, Integer> drone : drones.entrySet()) {
                    if (drone.getValue() < totalPower &&
                            drone.getValue() > suitablePower &&
                            !builtDrones.contains(drone.getKey())) {
                        suitableDrone = drone.getKey();
                        suitablePower = drone.getValue();
                    }
                }

                if (suitableDrone != null) {

                    assembledDrones.add(suitableDrone);
                    builtDrones.add(suitableDrone);
                    int newPowerLevel = powerCell - 30;
                    if (newPowerLevel > 0) {
                        powerCells.offer(newPowerLevel);
                    }
                } else {
                    int newPowerLevel = powerCell - 1;
                    if (newPowerLevel > 0) {
                        powerCells.offer(newPowerLevel);
                    }
                }
            }
        }


        if (assembledDrones.size() == 5) {
            System.out.println("Mission Accomplished! All Guardian Drones activated!");
        } else {
            System.out.println("Mission Failed! Some drones were not built.");
        }

        if (!assembledDrones.isEmpty()) {
            System.out.println("Assembled Drones: " + String.join(", ", assembledDrones));
        }


        if (!mechanicalParts.isEmpty()) {
            List<String> partsList = new ArrayList<>();
            while (!mechanicalParts.isEmpty()) {
                partsList.add(mechanicalParts.pop().toString());
            }
            System.out.println("Mechanical Parts: " + String.join(", ", partsList));
        }


        if (!powerCells.isEmpty()) {
            List<String> cellsList = new ArrayList<>();
            while (!powerCells.isEmpty()) {
                int cell = powerCells.poll();
                if (cell > 0) {
                    cellsList.add(String.valueOf(cell));
                }
            }
            if (!cellsList.isEmpty()) {
                System.out.println("Power Cells: " + String.join(", ", cellsList));
            }
        }

        scanner.close();
    }
}
