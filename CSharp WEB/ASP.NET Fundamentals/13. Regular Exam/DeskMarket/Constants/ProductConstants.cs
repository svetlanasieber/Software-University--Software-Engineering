namespace DeskMarket.Constants
{
    public class ProductConstants
    {
        //ProductName 
        public const int ProductNameMinLength = 2;
        public const int ProductNameMaxLength = 60;

        public const string ProductNameNameLengthErrorMessage =
            "ProductName must be between {2} and {1} characters long!";

        //Description 
        public const int DescriptionMinLength = 10;
        public const int DescriptionMaxLength = 250;
        public const string DescriptionLengthErrorMessage = "Description must be between {2} and {1} characters long!";

        //Price
        public const double PriceRangeLowestValue = 1.00;
        public const double PriceRangeHighestValue = 3000.00;
        public const string PriceRangeErrorMessage = "Price must be in the range from 1.00 to 3000.00";

        //DateTime
        public const string DateTimeFormat = "dd-MM-yyyy";
        public const string DateTimeErrorMessage = "Invalid DateTime format. The format must be - dd-MM-yyyy";
    }
}
