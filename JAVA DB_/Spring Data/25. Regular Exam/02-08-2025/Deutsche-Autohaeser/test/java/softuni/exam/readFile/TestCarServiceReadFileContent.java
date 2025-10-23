//package softuni.exam.readFile;
////TestCarServiceReadFileContent
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
//public class TestCarServiceReadFileContent {
//
//    @Autowired
//    public CarServiceImpl carService;
//
//     @Test
//    void readCarsFileContent() throws IOException {
//        String expected = """
//                [
//                  {
//                    "brand": "Hyundai",
//                    "model": "Veloster",
//                    "VIN": "QDYV4OEGWZSV79653",
//                    "mileage": 157163,
//                    "carType": "COUPE",
//                    "dealership": 1
//                  },
//                  {
//                    "brand": "Hyundai",
//                    "model": "Veloster",
//                    "VIN": "QDYV4OEGWZSV79653",
//                    "mileage": 157163,
//                    "carType": "COUPE",
//                    "dealership": 1
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Scala",
//                    "VIN": "I0QHZ8TNJBQA24ITV",
//                    "mileage": 212014,
//                    "carType": "HATCHBACK",
//                    "dealership": 18
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Arteon",
//                    "VIN": "8R7W1WGAAZHH737H4",
//                    "mileage": 38437,
//                    "carType": "SEDAN",
//                    "dealership": 16
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Kodiaq",
//                    "VIN": "QDBQEYETK896Z9PZ6",
//                    "mileage": 193030,
//                    "carType": "SUV",
//                    "dealership": 3
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "1er",
//                    "VIN": "0SVSZ1F916U3H5204",
//                    "mileage": 243387,
//                    "carType": "HATCHBACK",
//                    "dealership": 7
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Scirocco",
//                    "VIN": "Z3FTF3BMZXHV5587O",
//                    "mileage": 120509,
//                    "carType": "COUPE",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Superb",
//                    "VIN": "ISH3NSR6W4MVU4ICP",
//                    "mileage": 162856,
//                    "carType": "SEDAN",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Arteon",
//                    "VIN": "W1PTTO18GBF5OJB38",
//                    "mileage": 100603,
//                    "carType": "SEDAN",
//                    "dealership": 6
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Passat Variant",
//                    "VIN": "JMVYRMPD1LNKU3X3E",
//                    "mileage": 227142,
//                    "carType": "COMBI",
//                    "dealership": 2
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Scala",
//                    "VIN": "8LXEC9UB9XLT88CVI",
//                    "mileage": 30879,
//                    "carType": "HATCHBACK",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Stinger",
//                    "VIN": "015DZUEZ47SNAW9YD",
//                    "mileage": 186224,
//                    "carType": "COUPE",
//                    "dealership": 2
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "CLA Coupe",
//                    "VIN": "DKK5HFLIQ6U5BC8WS",
//                    "mileage": 68901,
//                    "carType": "COUPE",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "X5",
//                    "VIN": "F5RHB6B6RH16FD324",
//                    "mileage": 7038,
//                    "carType": "SUV",
//                    "dealership": 6
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Rapid Spaceback",
//                    "VIN": "RW5EDZAVT91WKAPQN",
//                    "mileage": 59591,
//                    "carType": "HATCHBACK",
//                    "dealership": 3
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Rapid Spaceback",
//                    "VIN": "LTR38TMEFCXKGI2A5",
//                    "mileage": 145344,
//                    "carType": "HATCHBACK",
//                    "dealership": 13
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Scala",
//                    "VIN": "7WZLWWN9N6DJKWIV5",
//                    "mileage": 36552,
//                    "carType": "HATCHBACK",
//                    "dealership": 12
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "5er Touring",
//                    "VIN": "61XZX0P4J7OC4I9D2",
//                    "mileage": 99461,
//                    "carType": "COMBI",
//                    "dealership": 11
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Optima",
//                    "VIN": "DK6B084NONBFDW1H4",
//                    "mileage": 56676,
//                    "carType": "SEDAN",
//                    "dealership": 11
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Octavia Combi",
//                    "VIN": "V01C3Q80IHVF6VQ67",
//                    "mileage": 232773,
//                    "carType": "COMBI",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "Hyundai",
//                    "model": "Elantra",
//                    "VIN": "2QXCCLAN5IYN9PSFV",
//                    "mileage": 216381,
//                    "carType": "SEDAN",
//                    "dealership": 10
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Passat Variant",
//                    "VIN": "AMPP3RLI42HLB2HZW",
//                    "mileage": 12521,
//                    "carType": "COMBI",
//                    "dealership": 17
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Scala",
//                    "VIN": "DEFTT2ZFG90RKPYEX",
//                    "mileage": 108421,
//                    "carType": "HATCHBACK",
//                    "dealership": 8
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Stinger",
//                    "VIN": "YET5VGHR7SR4CWGVN",
//                    "mileage": 133607,
//                    "carType": "COUPE",
//                    "dealership": 18
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Scirocco",
//                    "VIN": "5UOFRWW2SK89HNACE",
//                    "mileage": 97638,
//                    "carType": "COUPE",
//                    "dealership": 18
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Octavia Combi",
//                    "VIN": "9Z184FID7E29XIK6B",
//                    "mileage": 107237,
//                    "carType": "COMBI",
//                    "dealership": 2
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A3",
//                    "VIN": "BT9U7F8C0MJOT8DTV",
//                    "mileage": 20667,
//                    "carType": "HATCHBACK",
//                    "dealership": 9
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A6",
//                    "VIN": "TF86IDCI2Y97HURSZ",
//                    "mileage": 165283,
//                    "carType": "SEDAN",
//                    "dealership": 13
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Optima",
//                    "VIN": "YM61KWDUDORMCOXXB",
//                    "mileage": 61278,
//                    "carType": "SEDAN",
//                    "dealership": 16
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "GLC",
//                    "VIN": "L7OQQOYM0PSX32YJG",
//                    "mileage": 95229,
//                    "carType": "SUV",
//                    "dealership": 4
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A4 Avant",
//                    "VIN": "3XIUW4TCZC4EHMC4U",
//                    "mileage": 168551,
//                    "carType": "COMBI",
//                    "dealership": 18
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "A-Klasse",
//                    "VIN": "UNCL4BEGJNKECZRT6",
//                    "mileage": 93766,
//                    "carType": "HATCHBACK",
//                    "dealership": 12
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "308 SW",
//                    "VIN": "22T8ZAF0NZEMD0TKT",
//                    "mileage": 124009,
//                    "carType": "COMBI",
//                    "dealership": 8
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "3er",
//                    "VIN": "X0Q9SOM2OH4RZHDSG",
//                    "mileage": 141774,
//                    "carType": "SEDAN",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Scala",
//                    "VIN": "CVVSK4K1D2WRX6LO2",
//                    "mileage": 112987,
//                    "carType": "HATCHBACK",
//                    "dealership": 12
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Kuga",
//                    "VIN": "5RBK3QNP09X9HFGVM",
//                    "mileage": 151257,
//                    "carType": "SUV",
//                    "dealership": 12
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Tiguan",
//                    "VIN": "4QCRTZLPY4G3A5G6D",
//                    "mileage": 120441,
//                    "carType": "SUV",
//                    "dealership": 15
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "308 SW",
//                    "VIN": "CV3QPZDL73HFW1WPT",
//                    "mileage": 191640,
//                    "carType": "COMBI",
//                    "dealership": 5
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A6",
//                    "VIN": "BHST4P9L7RDO1BXJE",
//                    "mileage": 92311,
//                    "carType": "SEDAN",
//                    "dealership": 9
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Optima",
//                    "VIN": "5WDKWU1W9G2VZRK7O",
//                    "mileage": 134624,
//                    "carType": "SEDAN",
//                    "dealership": 16
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Golf",
//                    "VIN": "F0O6NJFUM44S6BB2H",
//                    "mileage": 186934,
//                    "carType": "HATCHBACK",
//                    "dealership": 7
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A3",
//                    "VIN": "YEKPF01IO5UPJBVBK",
//                    "mileage": 176004,
//                    "carType": "HATCHBACK",
//                    "dealership": 15
//                  },
//                  {
//                    "brand": "Hyundai",
//                    "model": "Veloster",
//                    "VIN": "K868GBJPPFEOCQWIH",
//                    "mileage": 161424,
//                    "carType": "COUPE",
//                    "dealership": 9
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Rapid Spaceback",
//                    "VIN": "UQ93JI1GLVM4V7FH8",
//                    "mileage": 83897,
//                    "carType": "HATCHBACK",
//                    "dealership": 4
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Mustang",
//                    "VIN": "O8Y4IVW0S5SU83CGM",
//                    "mileage": 46505,
//                    "carType": "COUPE",
//                    "dealership": 14
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Kodiaq",
//                    "VIN": "BU9R3NYOAHLYXOM5E",
//                    "mileage": 193941,
//                    "carType": "SUV",
//                    "dealership": 1
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "3008",
//                    "VIN": "TG0ZPIOS81WWTLM8T",
//                    "mileage": 223446,
//                    "carType": "SUV",
//                    "dealership": 7
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Optima",
//                    "VIN": "FH65IEN9DUWKHAR4M",
//                    "mileage": 84092,
//                    "carType": "SEDAN",
//                    "dealership": 13
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "5er Touring",
//                    "VIN": "SEQ5QD9A2VG04EHST",
//                    "mileage": 74783,
//                    "carType": "COMBI",
//                    "dealership": 6
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Kuga",
//                    "VIN": "41AH9A1OZGSRL2TWY",
//                    "mileage": 79089,
//                    "carType": "SUV",
//                    "dealership": 18
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Mondeo",
//                    "VIN": "27G17CX5163269JB0",
//                    "mileage": 218996,
//                    "carType": "SEDAN",
//                    "dealership": 17
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Rio",
//                    "VIN": "UY244SLQ72TUWMENY",
//                    "mileage": 237419,
//                    "carType": "HATCHBACK",
//                    "dealership": 14
//                  },
//                  {
//                    "brand": "Opel",
//                    "model": "Calibra",
//                    "VIN": "448470H5GWZNRD6J3",
//                    "mileage": 138750,
//                    "carType": "COUPE",
//                    "dealership": 1
//                  },
//                  {
//                    "brand": "Hyundai",
//                    "model": "i20",
//                    "VIN": "HIE1H0036V3EI4WB6",
//                    "mileage": 139465,
//                    "carType": "HATCHBACK",
//                    "dealership": 8
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "C-Klasse T-Modell",
//                    "VIN": "CNT3W7K8CG0LULKP6",
//                    "mileage": 171922,
//                    "carType": "COMBI",
//                    "dealership": 14
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "308 SW",
//                    "VIN": "4ENXROZT8F1PTZ5D9",
//                    "mileage": 83613,
//                    "carType": "COMBI",
//                    "dealership": 14
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A6",
//                    "VIN": "BCH9P5XCD74U4ORWA",
//                    "mileage": 6087,
//                    "carType": "SEDAN",
//                    "dealership": 10
//                  },
//                  {
//                    "brand": "Opel",
//                    "model": "Calibra",
//                    "VIN": "V0GW9TMCZXWY3N55X",
//                    "mileage": 29556,
//                    "carType": "COUPE",
//                    "dealership": 17
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "X6",
//                    "VIN": "UG2L97PD0X0MI10CG",
//                    "mileage": 113221,
//                    "carType": "COUPE",
//                    "dealership": 10
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "CLA Coupe",
//                    "VIN": "KH7XMESGX265DJLJZ",
//                    "mileage": 172312,
//                    "carType": "COUPE",
//                    "dealership": 15
//                  },
//                  {
//                    "brand": "Hyundai",
//                    "model": "Veloster",
//                    "VIN": "QLTOHI8UYTS1SGJ4L",
//                    "mileage": 208488,
//                    "carType": "COUPE",
//                    "dealership": 1
//                  },
//                  {
//                    "brand": "Hyundai",
//                    "model": "Tucson",
//                    "VIN": "S1KS40NTCTRINWV1X",
//                    "mileage": 183970,
//                    "carType": "SUV",
//                    "dealership": 2
//                  },
//                  {
//                    "brand": "Opel",
//                    "model": "Insignia",
//                    "VIN": "73XIOTD1LZXX2QBFW",
//                    "mileage": 47390,
//                    "carType": "SEDAN",
//                    "dealership": 3
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A3",
//                    "VIN": "CZJYG4X8U45J0N29K",
//                    "mileage": 237204,
//                    "carType": "HATCHBACK",
//                    "dealership": 16
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "RCZ",
//                    "VIN": "F292LPN6LQWUXXB4H",
//                    "mileage": 220475,
//                    "carType": "COUPE",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "Q3",
//                    "VIN": "BVFQ71QTDV9C4IIEL",
//                    "mileage": 161414,
//                    "carType": "SUV",
//                    "dealership": 9
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Scirocco",
//                    "VIN": "O230J2N1FT9O5UM07",
//                    "mileage": 214090,
//                    "carType": "COUPE",
//                    "dealership": 2
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "X5",
//                    "VIN": "H7GMY1RMG7Q5FRZ58",
//                    "mileage": 142638,
//                    "carType": "SUV",
//                    "dealership": 7
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "308 SW",
//                    "VIN": "4CBYBSEQLGAA3JSZ4",
//                    "mileage": 54243,
//                    "carType": "COMBI",
//                    "dealership": 13
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "A-Klasse",
//                    "VIN": "RDLFOVUUQMVBT4OIT",
//                    "mileage": 120929,
//                    "carType": "HATCHBACK",
//                    "dealership": 6
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "1er",
//                    "VIN": "GNTUHTXOG45I21PZW",
//                    "mileage": 160288,
//                    "carType": "HATCHBACK",
//                    "dealership": 2
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Passat Variant",
//                    "VIN": "72AOU6O1AFPHWLN45",
//                    "mileage": 97794,
//                    "carType": "COMBI",
//                    "dealership": 7
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Rio",
//                    "VIN": "U24HKPAM0U2AEX3BY",
//                    "mileage": 219699,
//                    "carType": "HATCHBACK",
//                    "dealership": 9
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "208",
//                    "VIN": "JGOTU718ZPJ1S72Z1",
//                    "mileage": 136838,
//                    "carType": "HATCHBACK",
//                    "dealership": 9
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "CLA Coupe",
//                    "VIN": "9ZWLPG2X0X9JDX9OS",
//                    "mileage": 153218,
//                    "carType": "COUPE",
//                    "dealership": 8
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Focus Turnier",
//                    "VIN": "6Y1039GP7I5NHE9E8",
//                    "mileage": 156943,
//                    "carType": "COMBI",
//                    "dealership": 2
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "508",
//                    "VIN": "DUWUSOFX349V1F42Z",
//                    "mileage": 232067,
//                    "carType": "SEDAN",
//                    "dealership": 18
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Focus Turnier",
//                    "VIN": "V4SPOHUC7EXIN9PE3",
//                    "mileage": 80545,
//                    "carType": "COMBI",
//                    "dealership": 4
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "X5",
//                    "VIN": "QN8XSVX2R88B0BVX5",
//                    "mileage": 224181,
//                    "carType": "SUV",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "C-Klasse T-Modell",
//                    "VIN": "NK779DAUE89R5RCVS",
//                    "mileage": 67725,
//                    "carType": "COMBI",
//                    "dealership": 8
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Tiguan",
//                    "VIN": "G2CJVMO6V3I9AUYYX",
//                    "mileage": 199147,
//                    "carType": "SUV",
//                    "dealership": 7
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Ceed SW",
//                    "VIN": "X9796BXILPSXP4V9C",
//                    "mileage": 156690,
//                    "carType": "COMBI",
//                    "dealership": 17
//                  },
//                  {
//                    "brand": "Mercedes-Benz",
//                    "model": "E-Klasse",
//                    "VIN": "UPKZALU0D8MXU3T0S",
//                    "mileage": 14449,
//                    "carType": "SEDAN",
//                    "dealership": 13
//                  },
//                  {
//                    "brand": "Peugeot",
//                    "model": "3008",
//                    "VIN": "QUA8E5SZ5YA5YXL67",
//                    "mileage": 238493,
//                    "carType": "SUV",
//                    "dealership": 14
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Passat Variant",
//                    "VIN": "0TSD8FTWPWUZ19W4M",
//                    "mileage": 58660,
//                    "carType": "COMBI",
//                    "dealership": 18
//                  },
//                  {
//                    "brand": "BMW",
//                    "model": "5er Touring",
//                    "VIN": "28TNA3G2HE8PVYIDU",
//                    "mileage": 33336,
//                    "carType": "COMBI",
//                    "dealership": 10
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Kuga",
//                    "VIN": "WDDZAN62E1SYV9APH",
//                    "mileage": 11308,
//                    "carType": "SUV",
//                    "dealership": 19
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Mondeo",
//                    "VIN": "Q57EVO553CQEKQNJW",
//                    "mileage": 50921,
//                    "carType": "SEDAN",
//                    "dealership": 12
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Scirocco",
//                    "VIN": "3OPD0T1AN4LQFM6UZ",
//                    "mileage": 170874,
//                    "carType": "COUPE",
//                    "dealership": 18
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A3",
//                    "VIN": "6FJKP247FRTWVU6MR",
//                    "mileage": 172551,
//                    "carType": "HATCHBACK",
//                    "dealership": 4
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Tiguan",
//                    "VIN": "5TWV3EXEMEJROMZO1",
//                    "mileage": 150118,
//                    "carType": "SUV",
//                    "dealership": 17
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Rapid Spaceback",
//                    "VIN": "0JIU0R1UUWFRERQ70",
//                    "mileage": 182829,
//                    "carType": "HATCHBACK",
//                    "dealership": 6
//                  },
//                  {
//                    "brand": "Skoda",
//                    "model": "Rapid Spaceback",
//                    "VIN": "H91Q1P8QVRISE1A3K",
//                    "mileage": 10002,
//                    "carType": "HATCHBACK",
//                    "dealership": 11
//                  },
//                  {
//                    "brand": "Opel",
//                    "model": "Grandland",
//                    "VIN": "ED0CFGRYCZJM5B9LP",
//                    "mileage": 194737,
//                    "carType": "SUV",
//                    "dealership": 10
//                  },
//                  {
//                    "brand": "Audi",
//                    "model": "A6",
//                    "VIN": "N2R70RHWMJAQMNIHO",
//                    "mileage": 138160,
//                    "carType": "SEDAN",
//                    "dealership": 14
//                  },
//                  {
//                    "brand": "Hyundai",
//                    "model": "i30 Kombi",
//                    "VIN": "YC5J72AUND66OYLPV",
//                    "mileage": 25989,
//                    "carType": "COMBI",
//                    "dealership": 3
//                  },
//                  {
//                    "brand": "Opel",
//                    "model": "Calibra",
//                    "VIN": "H3Z15A2HNCSI4WPPF",
//                    "mileage": 233761,
//                    "carType": "COUPE",
//                    "dealership": 14
//                  },
//                  {
//                    "brand": "Kia",
//                    "model": "Rio",
//                    "VIN": "EVKBWBI9J4MZ66DSC",
//                    "mileage": 17865,
//                    "carType": "HATCHBACK",
//                    "dealership": 5
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Tiguan",
//                    "VIN": "V7RKFGWRXEK0TIJ5N",
//                    "mileage": 121994,
//                    "carType": "SUV",
//                    "dealership": 14
//                  },
//                  {
//                    "brand": "Volkswagen",
//                    "model": "Scirocco",
//                    "VIN": "2DFTJ67C1L8AEUGII",
//                    "mileage": 33944,
//                    "carType": "COUPE",
//                    "dealership": 6
//                  },
//                  {
//                    "brand": "Ford",
//                    "model": "Mustang",
//                    "VIN": "IUC19OZX9XMCB08CQ",
//                    "mileage": 31138,
//                    "carType": "COUPE",
//                    "dealership": 2
//                  }
//                ]""";
//
//        String actual = carService.readCarsFileContent();
//
//        Assertions.assertEquals(expected, actual);
//    }
//}