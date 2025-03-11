package com.example.advquerying;



import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ShampooService shampooService;

    private final IngredientService ingredientService;

    @Autowired
    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService){
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        /*Ex1. */
        /*String size = scanner.nextLine();*/

        /*for (Shampoo shampoo: this.shampooService.findByBrand("Silk Comb")) {
            System.out.println(shampoo.getId());
        }*/
        /*for (Shampoo shampoo: this.shampooService.findByBrandAndSize("Cotton Fresh", size)) {
            System.out.println(shampoo);
        }*/
        /* Ex1.*/
        /* for (Shampoo shampoo: this.shampooService.findBySize(size)) {
            System.out.println(shampoo);

        }*/


       /* Ex2 */
        /* String size = scanner.nextLine();
        long labelId = Long.parseLong(scanner.nextLine());

        for (Shampoo shampoo: this.shampooService.findBySizeOrLabelId(size, labelId)) {
            System.out.println(shampoo);

        }*/

       /* Ex3 */
        /*String price = scanner.nextLine();
        for (Shampoo shampoo: this.shampooService.findWithPriceGreaterThan(price)) {
            System.out.println(shampoo);

        }*/



        /* Ex4 */
        /* String name = scanner.nextLine();

        for (Ingredient ingredient : this.ingredientService.selectByName(name)) {
            System.out.println(ingredient.getName());
        }*/

        /* Ex5 */
        /* String nextLine = scanner.nextLine();

        List<String> ingredients = new ArrayList<>();

        while (!nextLine.isBlank()){
            ingredients.add(nextLine);

            nextLine = scanner.nextLine();
        }
        for (Ingredient ingredient : this.ingredientService.selectByNames(ingredients)) {
            System.out.println(ingredient.getName());
        }*/

        /* Ex6.*/
        /*String price = scanner.nextLine();


        System.out.println(this.shampooService.countWithPriceLowerThan(price));*/


        /* Ex7.*/
        /*String nextLine = scanner.nextLine();

        List<String> ingredients = new ArrayList<>();

        while (!nextLine.isBlank()){
            ingredients.add(nextLine);

            nextLine = scanner.nextLine();
        }

        for (Shampoo shampoo: this.shampooService.findByIngredient(ingredients)) {
            System.out.println(shampoo);

        }*/



        /* Ex8.*/
        /*int count = Integer.parseInt(scanner.nextLine());

        for (Shampoo shampoo: this.shampooService.findWithIngredientCountLessThan(count)) {
            System.out.println(shampoo);

        }*/

        /* Ex9.*/
        /* String name = scanner.nextLine();

        this.ingredientService.deleteByName(name);*/

        /* Ex10.*/
        /*this.ingredientService.updatePrice();*/

        /* Ex11.*/

        /*String nextLine = scanner.nextLine();
        List<String> names = new ArrayList<>();
        while (!nextLine.isBlank()){
            names.add(nextLine);

            nextLine = scanner.nextLine();
        }

        this.ingredientService.updatePriceByName(names);*/



}

}
