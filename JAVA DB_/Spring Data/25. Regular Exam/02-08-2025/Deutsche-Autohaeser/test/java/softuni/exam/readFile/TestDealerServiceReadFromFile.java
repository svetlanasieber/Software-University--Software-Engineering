//package softuni.exam.readFile;
////TestDealerServiceReadFromFile
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//
//import java.io.IOException;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestDealerServiceReadFromFile {
//
//    @Autowired
//    private DealerServiceImpl dealerService;
//
//    @Test
//    void readDealersFromFile() throws IOException {
//        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<dealers>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>176858.79</average_monthly_turnover>\n" +
//                "        <birthday>1989-01-01</birthday>\n" +
//                "        <first_name>Drake</first_name>\n" +
//                "        <last_name>Hawthorne</last_name>\n" +
//                "        <salary>207615.71</salary>\n" +
//                "        <offering_car_id>50</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>300.79</average_monthly_turnover>\n" +
//                "        <birthday>1989-01-01</birthday>\n" +
//                "        <first_name>Drake</first_name>\n" +
//                "        <last_name>Hawthorne</last_name>\n" +
//                "        <salary>207615.71</salary>\n" +
//                "        <offering_car_id>50</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>176858.79</average_monthly_turnover>\n" +
//                "        <birthday>1989-01-01</birthday>\n" +
//                "        <first_name>Drake</first_name>\n" +
//                "        <last_name>Hawthorne</last_name>\n" +
//                "        <salary>207615.71</salary>\n" +
//                "        <offering_car_id>50</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>55537.43</average_monthly_turnover>\n" +
//                "        <birthday>1966-11-03</birthday>\n" +
//                "        <first_name>Elena</first_name>\n" +
//                "        <last_name>Sullivan</last_name>\n" +
//                "        <salary>98319.24</salary>\n" +
//                "        <offering_car_id>91</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>105443.87</average_monthly_turnover>\n" +
//                "        <birthday>1954-09-02</birthday>\n" +
//                "        <first_name>Cassandra</first_name>\n" +
//                "        <last_name>Bellamy</last_name>\n" +
//                "        <salary>1499.52</salary>\n" +
//                "        <offering_car_id>28</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>72795.68</average_monthly_turnover>\n" +
//                "        <birthday>1993-08-14</birthday>\n" +
//                "        <first_name>Victor</first_name>\n" +
//                "        <last_name>Adams</last_name>\n" +
//                "        <salary>316456.16</salary>\n" +
//                "        <offering_car_id>42</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>105443.87</average_monthly_turnover>\n" +
//                "        <birthday>1954-09-02</birthday>\n" +
//                "        <first_name>Cassandra</first_name>\n" +
//                "        <last_name>Bellamy</last_name>\n" +
//                "        <salary>111076.52</salary>\n" +
//                "        <offering_car_id>28</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>106936.42</average_monthly_turnover>\n" +
//                "        <birthday>1959-06-03</birthday>\n" +
//                "        <first_name>Nathaniel</first_name>\n" +
//                "        <last_name>Reynolds</last_name>\n" +
//                "        <salary>101754.41</salary>\n" +
//                "        <offering_car_id>16</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>241603.8</average_monthly_turnover>\n" +
//                "        <birthday>1958-09-04</birthday>\n" +
//                "        <first_name>Serena</first_name>\n" +
//                "        <last_name>Chandler</last_name>\n" +
//                "        <salary>98328.09</salary>\n" +
//                "        <offering_car_id>16</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>153446.68</average_monthly_turnover>\n" +
//                "        <birthday>1951-03-10</birthday>\n" +
//                "        <first_name>Gabriel</first_name>\n" +
//                "        <last_name>Fletcher</last_name>\n" +
//                "        <salary>62358.41</salary>\n" +
//                "        <offering_car_id>54</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>244764.96</average_monthly_turnover>\n" +
//                "        <birthday>1989-05-24</birthday>\n" +
//                "        <first_name>Lorelei</first_name>\n" +
//                "        <last_name>Blackwell</last_name>\n" +
//                "        <salary>153955.54</salary>\n" +
//                "        <offering_car_id>36</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>183403.7</average_monthly_turnover>\n" +
//                "        <birthday>1983-04-12</birthday>\n" +
//                "        <first_name>Sebastian</first_name>\n" +
//                "        <last_name>Maxwell</last_name>\n" +
//                "        <salary>54559.97</salary>\n" +
//                "        <offering_car_id>23</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>150617.05</average_monthly_turnover>\n" +
//                "        <birthday>1980-07-26</birthday>\n" +
//                "        <first_name>Aurora</first_name>\n" +
//                "        <last_name>Hamilton</last_name>\n" +
//                "        <salary>211196.44</salary>\n" +
//                "        <offering_car_id>74</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>16667.34</average_monthly_turnover>\n" +
//                "        <birthday>1960-01-02</birthday>\n" +
//                "        <first_name>Julian</first_name>\n" +
//                "        <last_name>Whitaker</last_name>\n" +
//                "        <salary>66661.49</salary>\n" +
//                "        <offering_car_id>64</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>121317.97</average_monthly_turnover>\n" +
//                "        <birthday>1976-04-03</birthday>\n" +
//                "        <first_name>Genevieve</first_name>\n" +
//                "        <last_name>Archer</last_name>\n" +
//                "        <salary>67686.33</salary>\n" +
//                "        <offering_car_id>18</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>148528.89</average_monthly_turnover>\n" +
//                "        <birthday>1958-04-26</birthday>\n" +
//                "        <first_name>Elias</first_name>\n" +
//                "        <last_name>Donovan</last_name>\n" +
//                "        <salary>288559.38</salary>\n" +
//                "        <offering_car_id>42</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>55643.78</average_monthly_turnover>\n" +
//                "        <birthday>1986-07-15</birthday>\n" +
//                "        <first_name>Isadora</first_name>\n" +
//                "        <last_name>Fitzgerald</last_name>\n" +
//                "        <salary>334024.69</salary>\n" +
//                "        <offering_car_id>64</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>209054.25</average_monthly_turnover>\n" +
//                "        <birthday>1988-05-03</birthday>\n" +
//                "        <first_name>Lysander</first_name>\n" +
//                "        <last_name>Spencer</last_name>\n" +
//                "        <salary>108576.5</salary>\n" +
//                "        <offering_car_id>78</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>34635.09</average_monthly_turnover>\n" +
//                "        <birthday>1995-08-14</birthday>\n" +
//                "        <first_name>Astrid</first_name>\n" +
//                "        <last_name>Webster</last_name>\n" +
//                "        <salary>104422.67</salary>\n" +
//                "        <offering_car_id>87</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>83542.93</average_monthly_turnover>\n" +
//                "        <birthday>1980-12-10</birthday>\n" +
//                "        <first_name>Leander</first_name>\n" +
//                "        <last_name>Valentine</last_name>\n" +
//                "        <salary>377608.72</salary>\n" +
//                "        <offering_car_id>91</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>22836.19</average_monthly_turnover>\n" +
//                "        <birthday>1980-01-16</birthday>\n" +
//                "        <first_name>Helena</first_name>\n" +
//                "        <last_name>Bishop</last_name>\n" +
//                "        <salary>294111.44</salary>\n" +
//                "        <offering_car_id>80</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>31049.67</average_monthly_turnover>\n" +
//                "        <birthday>1966-05-05</birthday>\n" +
//                "        <first_name>Dorian</first_name>\n" +
//                "        <last_name>Sawyer</last_name>\n" +
//                "        <salary>161438.11</salary>\n" +
//                "        <offering_car_id>77</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "    <dealer>\n" +
//                "        <average_monthly_turnover>20537.9</average_monthly_turnover>\n" +
//                "        <birthday>1957-09-04</birthday>\n" +
//                "        <first_name>Vivienne</first_name>\n" +
//                "        <last_name>Griffin</last_name>\n" +
//                "        <salary>252195.46</salary>\n" +
//                "        <offering_car_id>24</offering_car_id>\n" +
//                "    </dealer>\n" +
//                "</dealers>";
//
//        String actual = dealerService.readDealersFromFile().replaceAll("\\r", "");
//
//        Assertions.assertEquals(expected, actual.replaceAll("\\r", ""));
//    }
//}