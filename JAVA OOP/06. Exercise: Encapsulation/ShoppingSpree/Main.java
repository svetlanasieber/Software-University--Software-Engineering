package ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int counter = 0;
        List<Person> personList = new ArrayList<>();
        List<Product> productsList = new ArrayList<>();

        List<Person> resultList = new ArrayList<>();
        while (!line.equals("END")) {

            counter++;
            if (counter == 1) {
                String namesLine = line;
                personList = fillListWithPersons(line);

                line = scanner.nextLine();
                productsList = fillListWithProducts(line);

                counter++;
                line = scanner.nextLine();
                continue;
            }
            String personName = line.split("\\s+")[0];
            String productName = line.split("\\s+")[1];

            Person person = personList.stream().filter(e -> e.getName().equals(personName)).collect(Collectors.toList()).get(0);
            Product product = productsList.stream().filter(e -> e.getName().equals(productName)).collect(Collectors.toList()).get(0);

            person.buyProduct(product);
            line = scanner.nextLine();
        }

        // Output:
        for (Person person : personList) {
            if (!person.getProducts().isEmpty()) {
                System.out.printf("%s - ", person.getName());

                printProductListEls(person.getProducts());
            } else {
                System.out.printf("%s – Nothing bought\n", person.getName());
            }
        }
    }

    private static void printProductListEls(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.print(products.get(i).getName());
            if (i + 1 < products.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static List<Product> fillListWithProducts(String line) {
        List<String> productsInLine = Arrays.stream(line.split(";")).collect(Collectors.toList());

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < productsInLine.size(); i++) {
            String name = productsInLine.get(i).split("=")[0];
            double cost = Double.parseDouble(productsInLine.get(i).split("=")[1]);
            productList.add(new Product(name, cost));
        }
        return productList;
    }

    private static List<Person> fillListWithPersons(String line) {
        List<String> personsInLine = Arrays.stream(line.split(";")).collect(Collectors.toList());

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < personsInLine.size(); i++) {
            String name = personsInLine.get(i).split("=")[0];
            double money = Double.parseDouble(personsInLine.get(i).split("=")[1]);
            personList.add(new Person(name, money));
        }
        return personList;
    }
}
