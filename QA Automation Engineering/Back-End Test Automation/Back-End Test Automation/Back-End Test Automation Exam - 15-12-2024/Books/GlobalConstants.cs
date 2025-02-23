using System.Net;
using Newtonsoft.Json.Linq;
using RestSharp;
using NUnit.Framework;

namespace ApiTests
{
    public static class GlobalConstants
    {
        public const string BaseUrl = "http://localhost:5000/api";

        public static string AuthenticateUser(string email, string password)
        {
            var authClient = new RestClient(BaseUrl);
            var request = new RestRequest("user/login", Method.Post);
            request.AddJsonBody(new { email, password });

            var response = authClient.Execute(request);

            if (response.StatusCode != HttpStatusCode.OK)
            {
                Assert.Fail($"Authentication failed with status code: {response.StatusCode}, " +
                    $"content: {response.Content}");
            }

            var content = JObject.Parse(response.Content);
            return content["token"]?.ToString();
        }
    }
}
