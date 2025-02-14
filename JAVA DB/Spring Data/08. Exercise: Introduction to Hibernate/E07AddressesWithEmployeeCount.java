import entities.Address;

public class E07AddressesWithEmployeeCount {
    public static void main(String[] args) {
        Connector.createEntityManager()
                .createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(Address::printGeneralInformation);
    }
}