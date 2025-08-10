package harvesters.core;

public interface Controller {

    String addField(String fieldType, String fieldName, int crops);

    String addHarvester(String fieldName, String harvesterType, String harvesterName);

    String goHarvesting(String fieldName);

    String getStatistics();
}
