namespace DeskMarket.Common.Extensions
{
    using System.Security.Claims;

    public static class User
    {
        public static string? GetId(this ClaimsPrincipal user)
            => user.FindFirstValue(ClaimTypes.NameIdentifier);
    }
}
