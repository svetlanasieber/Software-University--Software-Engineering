package campers;

import java.util.ArrayList;
import java.util.List;

public class Campsite {
    private String name;
    private int availableTents;
    private List<Camper> campers;
    
    public Campsite(String name, int availableTents) {
        this.name = name;
        this.availableTents = availableTents;
        this.campers = new ArrayList<>();
    }
    
    public String addCamper(Camper camper) {
        if (camper.getHasTent()) {
            campers.add(camper);
            return "Camper " + camper.getName() + " joined the campsite.";
        } else {
            if (camper.getBudget() < 30) {
                return camper.getName() + " cannot afford to rent a tent.";
            }
            if (availableTents <= 0) {
                return "No available tents at " + name + ".";
            }

            campers.add(camper);
            availableTents--;
            return "Camper " + camper.getName() + " joined the campsite.";
        }
    }
    
    public boolean removeCamper(String name) {
        for (int i = 0; i < campers.size(); i++) {
            if (campers.get(i).getName().equals(name)) {
                Camper removedCamper = campers.remove(i);
                if (!removedCamper.getHasTent()) {
                    availableTents++;
                }
                return true;
            }
        }
        return false;
    }
    
    public String getMostExperiencedCamper() {
        if (campers.isEmpty()) {
            return "There are no campers at " + name + ".";
        }
        
        Camper mostExperienced = campers.get(0);
        for (Camper camper : campers) {
            if (camper.getExperienceLevel() > mostExperienced.getExperienceLevel()) {
                mostExperienced = camper;
            }
        }
        
        return mostExperienced.getName() + " has the most camping experience with " + 
               mostExperienced.getExperienceLevel() + " trips.";
    }
    
    public Camper getCamper(String name) {
        for (Camper camper : campers) {
            if (camper.getName().equals(name)) {
                return camper;
            }
        }
        return null;
    }
    
    public int getCount() {
        return campers.size();
    }
    
    public String getCampersWithPersonalTents() {
        if (campers.isEmpty()) {
            return "No campers currently at " + name + ".";
        }
        
        List<String> campersWithTents = new ArrayList<>();
        for (Camper camper : campers) {
            if (camper.getHasTent()) {
                campersWithTents.add(camper.getName());
            }
        }
        
        if (campersWithTents.isEmpty()) {
            return "No campers currently at " + name + ".";
        }
        
        return "Campers with their own tents: " + String.join(", ", campersWithTents);
    }
    
    public String getReport() {
        if (campers.isEmpty()) {
            return "There are no campers at " + name + ".";
        }
        
        StringBuilder report = new StringBuilder();
        report.append("Campsite ").append(name).append(" hosts the following campers:\n");
        
        for (int i = 0; i < campers.size(); i++) {
            Camper camper = campers.get(i);
            report.append(i + 1).append(". ")
                  .append(camper.getName())
                  .append(" with ")
                  .append(camper.getExperienceLevel())
                  .append(" camping trips.");
            if (i < campers.size() - 1) {
                report.append("\n");
            }
        }
        
        return report.toString();
    }
} 
