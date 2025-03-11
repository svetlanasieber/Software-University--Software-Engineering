package bg.softuni.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AddressDTO address = new AddressDTO("BG", "Varna");
        PersonDTO person = new PersonDTO(
                    null,
                    "Last",
                    11,
                    address,
                    true,
                    Date.from(Instant.now())
            );

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
//                .setDateFormat("YYYY-MM-dd")
                .serializeNulls()
                .create();

        String json = gson.toJson(List.of(person));
        System.out.println(json);

        PersonDTO[] inputPerson = gson.fromJson("""
                [
                  {
                    "firstName": null,
                    "age": 11,
                    "address": {
                      "country": "BG",
                      "city": "Varna"
                    }
                  }
                ]
                """, PersonDTO[].class);

        System.out.println(inputPerson[0]);
    }
}
