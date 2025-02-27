namespace DeskMarket.Data.Models.Constraints
{
    public static class ModelConstraints
    {
        public static class ProductConstraints
        {
            public const int NameMaxLength = 60;

            public const int DescriptionMaxLength = 250;

            public const int ImageUrlMaxLength = 2_000;

            public const double PriceMinValue = 1;

            public const double PriceMaxValue = 3_000;
        }

        public static class CategoryConstraints
        {
            public const int NameMaxLength = 20;
        }
    }
}
