namespace DeskMarket.Common.Constants
{
    public static class ModelValidation
    {
        public static class Common
        {
            public const string LengthError = "{0} length should be between {2} and {1} characters long!";

            public const string RequiredError = "The {0} field is required!";

            public const string PriceError = "{0} value should be between {1} and {2}!";
        }

        public static class ProductValidation 
        {
            public const int NameMinLength = 2;
            public const int NameMaxLength = 60;

            public const int DescriptionMinLength = 10;
            public const int DescriptionMaxLength = 250;

            public const double PriceMinValue = 1;
            public const double PriceMaxValue = 3_000;

            public const int ImageUrlMinLength = 5;
            public const int ImageUrlMaxLength = 2_000;
        }
    }
}
