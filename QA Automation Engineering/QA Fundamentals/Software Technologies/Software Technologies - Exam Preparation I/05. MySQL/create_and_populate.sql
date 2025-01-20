CREATE DATABASE IF NOT EXISTS `address_database`;
USE `address_database`;

CREATE TABLE `addresses` (
	street_number VARCHAR(20),
    street_name VARCHAR(80),
    area VARCHAR(80),
    town VARCHAR(80),
    district VARCHAR(80),
    country VARCHAR(50),
    continent VARCHAR(50),
    isCapital BOOLEAN
);

INSERT INTO addresses (street_number, street_name, area, town, district, country, continent, isCapital)
VALUES
    ('10', 'Main Street', 'Downtown', 'New York City', 'Manhattan', 'United States', 'North America', false),
    ('25A', 'Elm Avenue', 'West End', 'London', 'Westminster', 'United Kingdom', 'Europe', true),
    ('7', 'Rue de la Paix', 'Le Marais', 'Paris', 'Ile-de-France', 'France', 'Europe', true),
    ('1234', 'Oak Lane', 'Green Meadows', 'Los Angeles', 'California', 'United States', 'North America', false),
    ('42', 'High Street', 'City Center', 'Sydney', 'New South Wales', 'Australia', 'Australia & Oceania', true),
    ('56B', 'Maple Road', 'Northside', 'Toronto', 'Ontario', 'Canada', 'North America', false),
    ('9', 'Kaiserstrasse', 'Mitte', 'Berlin', 'Berlin', 'Germany', 'Europe', true),
    ('17', 'Plaza Mayor', 'Centro', 'Madrid', 'Madrid', 'Spain', 'Europe', true),
    ('3', 'Piazza San Marco', 'San Marco', 'Venice', 'Veneto', 'Italy', 'Europe', false),
    ('1001', 'Avenida Paulista', 'Jardins', 'Sao Paulo', 'Sao Paulo', 'Brazil', 'South America', false),
    ('8/15', 'Princes Street', 'New Town', 'Edinburgh', 'Edinburgh', 'United Kingdom', 'Europe', false),
    ('27', 'Koningsplein', 'Centrum', 'Amsterdam', 'North Holland', 'Netherlands', 'Europe', true),
    ('42A', 'Hauptstrasse', 'Mitte', 'Vienna', 'Vienna', 'Austria', 'Europe', true),
    ('100', 'Collins Street', 'CBD', 'Melbourne', 'Victoria', 'Australia', 'Australia & Oceania', false),
    ('123', 'Rua da Boavista', 'Baixa', 'Porto', 'Porto', 'Portugal', 'Europe', false),
    ('5', 'Knez Mihailova', 'Stari Grad', 'Belgrade', 'Belgrade', 'Serbia', 'Europe', true),
    ('9876', 'Ginza', 'Chuo', 'Tokyo', 'Tokyo', 'Japan', 'Asia', true),
    ('18', 'Connell Street', 'North City', 'Dublin', 'Dublin', 'Ireland', 'Europe', true),
    ('75C', 'Friedrichstrasse', 'Kreuzberg', 'Berlin', 'Berlin', 'Germany', 'Europe', true),
    ('22', 'Gran Vía', 'Malasana', 'Madrid', 'Madrid', 'Spain', 'Europe', true),
    ('1', 'First Street', 'Central', 'San Francisco', 'California', 'United States', 'North America', false),
    ('55', 'Broadway', 'Midtown', 'New York City', 'Manhattan', 'United States', 'North America', false);