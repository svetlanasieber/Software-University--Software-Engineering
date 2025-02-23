using Newtonsoft.Json.Linq;
using RestSharp;
using System.Net;

namespace ApiTests
{
    [TestFixture]
    public class BookCategoryTests : IDisposable
    {
        private RestClient client;
        private string token;

        [SetUp]
        public void Setup()
        {
            client = new RestClient(GlobalConstants.BaseUrl);
            token = GlobalConstants.AuthenticateUser("john.doe@example.com", "password123");

            Assert.That(token, Is.Not.Null.Or.Empty, "Token not retrieved successfully.");
        }

        [Test]
        public void Test_BookCategoryLifecycle()
        {
            // Step 1: Create a new book category
            var createNewCategoryRequest = new RestRequest($"/category", Method.Post);
            createNewCategoryRequest.AddHeader("Authorization", $"Bearer {token}");

            createNewCategoryRequest.AddJsonBody(new
            {
                title = "Fictional Literature",
            });

            var createNewCategoryResponse = client.Execute(createNewCategoryRequest);

            Assert.That(createNewCategoryResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Failed to create the category.");

            var createdCategory = JObject.Parse(createNewCategoryResponse.Content);
            var categoryId = createdCategory["_id"]?.ToString();

            Assert.That(categoryId, Is.Not.Null.Or.Empty, "Category ID was not generated correctly.");

            // Step 2: Retrieve all book categories
            var getAllCategoriesRequest = new RestRequest($"/category", Method.Get);
            var getAllCategoriesResponse = client.Execute(getAllCategoriesRequest);

            Assert.Multiple(() =>
            {
                Assert.That(getAllCategoriesResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Unable to retrieve categories.");
                Assert.That(getAllCategoriesResponse.Content, Is.Not.Null.Or.Empty, "No categories data retrieved.");

                var categories = JArray.Parse(getAllCategoriesResponse.Content);

                Assert.That(categories.Type, Is.EqualTo(JTokenType.Array), "Categories are not in array format.");
                Assert.That(categories.Count, Is.GreaterThan(0), "No categories available.");
                Assert.That(categories.Any(c => c["_id"]?.ToString() == categoryId), Is.True, "Created category not found in the list.");
            });

            // Step 3: Update the category title
            var updatedCategory = new { title = "Updated Fictional Literature" };
            var updateCategoryRequest = new RestRequest($"category/{categoryId}", Method.Put);
            updateCategoryRequest.AddHeader("Authorization", $"Bearer {token}");
            updateCategoryRequest.AddJsonBody(updatedCategory);

            var updateCategoryResponse = client.Execute(updateCategoryRequest);
            Assert.That(updateCategoryResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Category update failed.");

            // Step 4: Verify the updated category
            var getUpdatedRequest = new RestRequest($"/category/{categoryId}", Method.Get);
            getUpdatedRequest.AddHeader("Authorization", $"Bearer {token}");

            var getUpdatedResponse = client.Execute(getUpdatedRequest);
            Assert.That(getUpdatedResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Failed to fetch the updated category.");

            var updatedCategoryDetails = JObject.Parse(getUpdatedResponse.Content);
            Assert.Multiple(() =>
            {
                Assert.That(updatedCategoryDetails["title"]?.ToString(), Is.EqualTo(updatedCategory.title), "Category title not updated correctly.");
            });

            // Step 5: Delete the category
            var deleteCategoryRequest = new RestRequest($"/category/{categoryId}", Method.Delete);
            deleteCategoryRequest.AddHeader("Authorization", $"Bearer {token}");

            var deleteCategoryResponse = client.Execute(deleteCategoryRequest);
            Assert.That(deleteCategoryResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Failed to delete the category.");

            // Step 6: Verify the deleted category cannot be found
            var getDeletedRequest = new RestRequest($"/category/{categoryId}", Method.Get);

            var getDeletedResponse = client.Execute(getDeletedRequest);

            Assert.That(getDeletedResponse.Content, Is.EqualTo("null"), "Deleted category still exists.");
        }

        public void Dispose()
        {
            client?.Dispose();
        }
    }
}
