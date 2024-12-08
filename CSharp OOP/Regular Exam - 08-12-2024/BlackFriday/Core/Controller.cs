using System;
using System.Linq;

using BlackFriday.Core.Contracts;
using BlackFriday.Models;

namespace BlackFriday.Core
{
    public class Controller : IController
    {
        private readonly Application application;

        public Controller()
        {
            application = new Application();
        }

        public string RegisterUser(string userName, string email, bool hasDataAccess)
        {
            if (application.Users.Exists(userName))
            {
                return $"{userName} is already registered.";
            }

            if (application.Users.Models.Any(u => u.Email == email))
            {
                return $"{email} is already used by another user.";
            }

            if (hasDataAccess)
            {
                var adminCount = application.Users.Models.Count(u => u.HasDataAccess);
                if (adminCount >= 2)
                {
                    return "The number of application administrators is limited.";
                }

                var admin = new Admin(userName, email);
                application.Users.AddNew(admin);
                return $"Admin {userName} is successfully registered with data access.";
            }

            var client = new Client(userName, email);
            application.Users.AddNew(client);
            return $"Client {userName} is successfully registered.";
        }

        public string AddProduct(string productType, string productName, string userName, double basePrice)
        {
            if (!application.Users.Exists(userName) || !application.Users.GetByName(userName).HasDataAccess)
            {
                return $"{userName} has no data access.";
            }

            if (application.Products.Exists(productName))
            {
                return $"{productName} already exists in the application.";
            }

            Product product = productType switch
            {
                "Item" => new Item(productName, basePrice),
                "Service" => new Service(productName, basePrice),
                _ => null
            };

            if (product == null)
            {
                return $"{productType} is not a valid type for the application.";
            }

            application.Products.AddNew(product);
            return $"{productType}: {productName} is added in the application. Price: {basePrice:F2}";
        }

        public string UpdateProductPrice(string productName, string userName, double newPriceValue)
        {
            if (!application.Products.Exists(productName))
            {
                return $"{productName} does not exist in the application.";
            }

            if (!application.Users.Exists(userName) || !application.Users.GetByName(userName).HasDataAccess)
            {
                return $"{userName} has no data access.";
            }

            var product = application.Products.GetByName(productName);
            var oldPrice = product.BasePrice;
            product.UpdatePrice(newPriceValue);
            return $"{productName} -> Price is updated: {oldPrice:F2} -> {newPriceValue:F2}";
        }

        public string PurchaseProduct(string userName, string productName, bool blackFridayFlag)
        {
            if (!application.Users.Exists(userName) || application.Users.GetByName(userName).HasDataAccess)
            {
                return $"{userName} has no authorization for this functionality.";
            }

            if (!application.Products.Exists(productName))
            {
                return $"{productName} does not exist in the application.";
            }

            var product = application.Products.GetByName(productName);
            if (product.IsSold)
            {
                return $"{productName} is out of stock.";
            }

            var client = (Client)application.Users.GetByName(userName);
            client.PurchaseProduct(productName, blackFridayFlag);
            product.ToggleStatus();

            var price = blackFridayFlag ? product.BlackFridayPrice : product.BasePrice;
            return $"{userName} purchased {productName}. Price: {price:F2}";
        }

        public string RefreshSalesList(string userName)
        {
            if (!application.Users.Exists(userName) || !application.Users.GetByName(userName).HasDataAccess)
            {
                return $"{userName} has no data access.";
            }

            var updatedProductsCount = application.Products.Models.Count(p => p.IsSold);
            foreach (var product in application.Products.Models.Where(p => p.IsSold))
            {
                product.ToggleStatus();
            }

            return $"{updatedProductsCount} products are listed again.";
        }

        public string ApplicationReport()
        {
            var admins = application.Users.Models
                .Where(u => u.HasDataAccess)
                .OrderBy(u => u.UserName);

            var clients = application.Users.Models
                .Where(u => !u.HasDataAccess)
                .OrderBy(u => u.UserName);

            var report = "Application administration:\n";
            report += string.Join("\n", admins.Select(a => a.ToString()));

            report += "\nClients:\n";
            foreach (var client in clients)
            {
                report += client.ToString();
                var clientPurchases = ((Client)client).Purchases
                    .Where(p => p.Value)
                    .Select(p => p.Key);

                if (clientPurchases.Any())
                {
                    report += $"\n-Black Friday Purchases: {clientPurchases.Count()}\n";
                    report += string.Join("\n", clientPurchases.Select(p => $"--{p}"));
                }

                report += "\n";
            }

            return report.TrimEnd();
        }
    }
}
