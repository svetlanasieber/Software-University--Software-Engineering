using System;
using System.IO;
using System.Xml.Linq;
using System.Text.Json;
using System.Collections.Generic;
using System.Linq;
using XmlToJson.Models;
using System.Xml;

namespace XmlToJson
{
    class Program
    {
        static void Main(string[] args)
        {
            bool validChoice = false;

            while (!validChoice)
            {
                Console.WriteLine("Which XML file would you like to parse? (devices/vehicles)");
                string? choice = Console.ReadLine();

                if (string.IsNullOrWhiteSpace(choice))
                {
                    Console.WriteLine("No input provided. Please enter 'devices' or 'vehicles'.");
                    continue;
                }

                choice = choice.ToLower();
                switch (choice)
                {
                    case "devices":
                        ParseAndDisplayDevices();
                        validChoice = true;
                        break;
                    case "vehicles":
                        ParseAndDisplayVehicles();
                        validChoice = true;
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Please enter 'devices' or 'vehicles'.");
                        break;
                }
            }
        }

        private static void ParseAndDisplayDevices()
        {
            string xmlFilePath = Path.Combine("Datasets", "Devices.xml");
            try
            {
                var devices = ParseDevicesXml(xmlFilePath);
                var json = JsonSerializer.Serialize(devices, new JsonSerializerOptions { WriteIndented = true });
                Console.WriteLine(json);
            }
            catch (Exception e)
            {
                HandleError(e);
            }
        }

        private static void ParseAndDisplayVehicles()
        {
            string xmlFilePath = Path.Combine("Datasets", "Vehicles.xml");
            try
            {
                var vehicles = ParseVehiclesXml(xmlFilePath);
                var json = JsonSerializer.Serialize(vehicles, new JsonSerializerOptions { WriteIndented = true });
                Console.WriteLine(json);
            }
            catch (Exception e)
            {
                HandleError(e);
            }
        }

        private static Devices ParseDevicesXml(string filePath)
        {
            var xDocument = XDocument.Load(filePath);
            var devicesElement = xDocument.Element("devices");

            if (devicesElement == null)
            {
                throw new InvalidOperationException("The devices element is missing in the XML document.");
            }

            var devices = new Devices
            {
                DeviceList = devicesElement.Elements("device")
                    .Select(d => new Device
                    {
                        Type = d.Element("type")?.Value ?? string.Empty,
                        Brand = d.Element("brand")?.Value ?? string.Empty,
                        Specs = d.Element("specs")?.Value ?? string.Empty,
                        Price = int.TryParse(d.Element("price")?.Value, out int price) ? price : 0
                    })
                    .ToList()
            };

          
            foreach (var device in devices.DeviceList)
            {
                device.Validate();
            }

            return devices;
        }

        private static Vehicles ParseVehiclesXml(string filePath)
        {
            var xDocument = XDocument.Load(filePath);
            var vehiclesElement = xDocument.Element("vehicles");

            if (vehiclesElement == null)
            {
                throw new InvalidOperationException("The vehicles element is missing in the XML document.");
            }

            var vehicles = new Vehicles
            {
                VehicleList = vehiclesElement.Elements("vehicle")
                    .Select(v => new Vehicle
                    {
                        Type = v.Element("type")?.Value ?? string.Empty,
                        Model = v.Element("model")?.Value ?? string.Empty,
                        Specs = v.Element("specs")?.Value ?? string.Empty,
                        Color = v.Element("color")?.Value ?? string.Empty                       
                    })
                    .ToList()
            };

         
            foreach (var vehicle in vehicles.VehicleList)
            {
                vehicle.Validate();
            }

            return vehicles;
        }

        private static void HandleError(Exception e)
        {
            if (e is XmlException)
            {
                Console.WriteLine($"XML Parsing Error: {e.Message}");
            }
            else
            {
                Console.WriteLine($"An unexpected error occurred: {e.Message}");
            }
        }
    }
}
