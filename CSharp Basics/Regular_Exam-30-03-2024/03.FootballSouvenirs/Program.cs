        string country = Console.ReadLine();
        string souvenir = Console.ReadLine();
        int quantity = int.Parse(Console.ReadLine());

        double price = 0;
        bool isValidCountry = true;
        bool isValidStock = true;

        switch (country)
        {
            case "Argentina":
                switch (souvenir)
                {
                    case "flags": price = 3.25; break;
                    case "caps": price = 7.20; break;
                    case "posters": price = 5.10; break;
                    case "stickers": price = 1.25; break;
                    default: isValidStock = false; break;
                }
                break;
            case "Brazil":
                switch (souvenir)
                {
                    case "flags": price = 4.20; break;
                    case "caps": price = 8.50; break;
                    case "posters": price = 5.35; break;
                    case "stickers": price = 1.20; break;
                    default: isValidStock = false; break;
                }
                break;
            case "Croatia":
                switch (souvenir)
                {
                    case "flags": price = 2.75; break;
                    case "caps": price = 6.90; break;
                    case "posters": price = 4.95; break;
                    case "stickers": price = 1.10; break;
                    default: isValidStock = false; break;
                }
                break;
            case "Denmark":
                switch (souvenir)
                {
                    case "flags": price = 3.10; break;
                    case "caps": price = 6.50; break;
                    case "posters": price = 4.80; break;
                    case "stickers": price = 0.90; break;
                    default: isValidStock = false; break;
                }
                break;
            default:
                isValidCountry = false;
                break;
        }

        if (isValidCountry && isValidStock)
        {
            double totalPrice = price * quantity;
            Console.WriteLine($"Pepi bought {quantity} {souvenir} of {country} for {totalPrice:F2} lv.");
        }
        else if (!isValidCountry)
        {
            Console.WriteLine("Invalid country!");
        }
        else
        {
            Console.WriteLine("Invalid stock!");
        }

