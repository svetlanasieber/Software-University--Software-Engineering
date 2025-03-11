package bg.softuni.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        PersonDTO personDTO = new PersonDTO("First", "Last", 12, false);
        ObjectMapper objectMapper = new ObjectMapper();

        String encoded = objectMapper.writeValueAsString(personDTO);

        System.out.println(encoded);

        String rawJson = """
                {"firstName":"First","age":12,"deleted":false}
                """;

        PersonDTO parsed = objectMapper.readValue(rawJson, PersonDTO.class);

        System.out.println(parsed);
    }
}
