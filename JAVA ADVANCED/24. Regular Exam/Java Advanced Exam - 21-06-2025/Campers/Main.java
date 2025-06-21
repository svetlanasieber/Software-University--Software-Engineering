package campers;

public class Main {
    public static void main(String[] args) {


        Campsite rila = new Campsite("Rila", 2);
        Campsite pirin = new Campsite("Pirin", 1);
        Campsite vitosha = new Campsite("Vitosha", 0);


        Camper elena = new Camper("Elena", 30, 5, true, 80);
        Camper ivan = new Camper("Ivan", 25, 2, true, 50);
        Camper petar = new Camper("Petar", 20, 1, false, 20);
        Camper diana = new Camper("Diana", 28, 3, false, 100);
        Camper sofia = new Camper("Sofia", 35, 10, true, 200);
        Camper emil = new Camper("Emil", 40, 10, false, 150);

        System.out.println(rila.addCamper(elena));
        System.out.println(rila.addCamper(ivan));
        System.out.println(rila.addCamper(petar));
        System.out.println(pirin.addCamper(diana));
        System.out.println(pirin.addCamper(sofia));
        System.out.println(vitosha.addCamper(emil));
        System.out.println(vitosha.removeCamper("Emilia"));
        System.out.println(vitosha.removeCamper("Diana"));
        System.out.println(rila.getCamper("Elena"));
        System.out.println(rila.getCampersWithPersonalTents());
        System.out.println(pirin.getMostExperiencedCamper());
        System.out.println(rila.getReport());
        System.out.println(pirin.getReport());
        System.out.println(vitosha.getReport());
    }
}
