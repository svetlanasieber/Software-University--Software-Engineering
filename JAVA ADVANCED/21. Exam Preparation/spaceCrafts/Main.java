package spaceCrafts;

public class Main {

    public static void main(String[] args) {

        LaunchPad kennedySC = new LaunchPad("Kennedy Space Center", 3);
        LaunchPad capeCanaveralAFS = new LaunchPad("Cape Canaveral Air Force Station", 5);
   
        Spacecraft galileo = new Spacecraft("Galileo", "Orbiter", "Europa", "study Jupiter and its mysterious moons", 223);
        Spacecraft cassini = new Spacecraft("Cassini-Huygens", "Orbiter", "Saturn", "analyze the composition and atmosphere of Saturn", 2523);
        Spacecraft magellan = new Spacecraft("Magellan", "Orbiter", "Venus", "image the entire surface of Venus", 3445);
        Spacecraft huygens = new Spacecraft("Huygens", "Atmospheric Probe/Lander", "Titan", "provide a detailed study of Titan's atmosphere", 318);
        Spacecraft voyager1 = new Spacecraft("Voyager-1", "Multiple Flybys", "Outer Solar System", "chart the edge of interstellar space", 733);
        
        kennedySC.addSpacecraft(galileo);
        kennedySC.addSpacecraft(cassini);
        kennedySC.addSpacecraft(magellan);
        kennedySC.addSpacecraft(huygens); //This launchpad is at full capacity!


        capeCanaveralAFS.addSpacecraft(voyager1);
        kennedySC.getSpacecraftsByMissionType("Orbiter").forEach(spacecraft -> System.out.println(spacecraft.getName()));
  
        capeCanaveralAFS.getSpacecraftsByMissionType("Multiple Flybys").forEach(spacecraft -> System.out.println(spacecraft.getName()));

        System.out.println(capeCanaveralAFS.removeSpacecraft("Voyager-1")); //true


       
        System.out.println(capeCanaveralAFS.getCount()); 
        System.out.println(galileo);

        System.out.println(kennedySC.getHeaviestSpacecraft()); 
        System.out.println(kennedySC.getStatistics());
        System.out.println(capeCanaveralAFS.getStatistics());



    }
}
