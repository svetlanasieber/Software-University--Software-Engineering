using Newtonsoft.Json.Linq;
using RestSharp;
using System.Net;

namespace ApiTests
{
    [TestFixture]
    public class BookTests : IDisposable
    {
        private RestClient client;
        private string token;

        [SetUp]
        public void Setup()
        {
            client = new RestClient(GlobalConstants.BaseUrl);
            token = GlobalConstants.AuthenticateUser("john.doe@example.com", "password123");

            Assert.That(token, Is.Not.Null.Or.Empty, "Authentication token should not be null or empty");
        }

        [Test]
        public void Test_GetAllBooks()
        {
            var request = new RestRequest("book", Method.Get);

            var response = client.Execute(request);

            Assert.Multiple(() =>
            {
                Assert.That(response.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Expected status code OK (200)");
                Assert.That(response.Content, Is.Not.Empty, "Response content should not be empty");

                var books = JArray.Parse(response.Content);

                Assert.That(books.Type, Is.EqualTo(JTokenType.Array), "Expected response content to be a JSON array");
                Assert.That(books.Count, Is.GreaterThan(0), "Expected at least one book in the response");

                foreach (var book in books)
                {
                    Assert.That(book["title"]?.ToString(), Is.Not.Null.And.Not.Empty, "Book title should not be null or empty");
                    Assert.That(book["author"]?.ToString(), Is.Not.Null.And.Not.Empty, "Book author should not be null or empty");
                    Assert.That(book["description"]?.ToString(), Is.Not.Null.And.Not.Empty, "Book description should not be null or empty");
                    Assert.That(book["price"]?.ToString(), Is.Not.Null.And.Not.Empty, "Book price should not be null or empty");
                    Assert.That(book["pages"]?.ToString(), Is.Not.Null.And.Not.Empty, "Book pages should not be null or empty");
                    Assert.That(book["category"], Is.Not.Null, "Book category should not be null");
                }
            });
        }

        [Test]
        public void Test_GetBookByTitle()
        {
            var request = new RestRequest("book", Method.Get);

            var response = client.Execute(request);
            var expectedauthor = "F. Scott Fitzgerald";

            Assert.Multiple(() =>
            {
                Assert.That(response.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Expected status code OK (200)");
                Assert.That(response.Content, Is.Not.Empty, "Response content should not be empty");

                var books = JArray.Parse(response.Content);
                var book = books.FirstOrDefault(b => b["title"]?.ToString() == "The Great Gatsby");

                Assert.That(book, Is.Not.Null, "Book with title 'The Great Gatsby' not found");

                Assert.That(book["author"]?.ToString(), Is.EqualTo(expectedauthor), "Book author should match the expected value");

            });
        }

        [Test]
        public void Test_AddBook()
        {
            var getCategoriesRequest = new RestRequest("category", Method.Get);
            var getCategoriesResponse = client.Execute(getCategoriesRequest);


            Assert.Multiple(() =>
            {
                Assert.That(getCategoriesResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Get Categories status code OK should be (200)");
                Assert.That(getCategoriesResponse.Content, Is.Not.Empty, "Categories response content should not be empty");
            });

            var categories = JArray.Parse(getCategoriesResponse.Content);

            Assert.Multiple(() =>
            {
                Assert.That(categories.Type, Is.EqualTo(JTokenType.Array), "Expected response content to be a JSON array");
                Assert.That(categories.Count, Is.GreaterThan(0), "Expected at least one category in the response");
            });

            var category = categories.First();
            var categoryId = category["_id"]?.ToString();

            Assert.That(categoryId, Is.Not.Null.And.Not.Empty, "Category ID should not be null or empty");


            var addBookRequest = new RestRequest("book", Method.Post);
            addBookRequest.AddHeader("Authorization", $"Bearer {token}");

            var title = $"New Book Title {new Random().Next(999, 9999)}";
            var author = "New Author";
            var description = "A captivating new book description.";
            var price = 15.99;
            var pages = 250;

            addBookRequest.AddJsonBody(new
            {
                title,
                author,
                description,
                price,
                pages,
                category = categoryId
            });

            var addBookResponse = client.Execute(addBookRequest);


            Assert.Multiple(() =>
            {
                Assert.That(addBookResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Expected status code OK (200)");
                Assert.That(addBookResponse.Content, Is.Not.Empty, "Response content should not be empty");
            });

        }

        [Test]
        public void Test_UpdateBook()
        {
            var getRequest = new RestRequest("book", Method.Get);
            var getResponse = client.Execute(getRequest);

            Assert.That(getResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Expected status code OK (200)");
            Assert.That(getResponse.Content, Is.Not.Empty, "Response content should not be empty");

            var books = JArray.Parse(getResponse.Content);
            var bookToUpdate = books.FirstOrDefault(b => b["title"]?.ToString() == "The Catcher in the Rye");

            Assert.That(bookToUpdate, Is.Not.Null, "Book with title 'The Catcher in the Rye' not found");

            var bookId = bookToUpdate["_id"].ToString();

            var updateRequest = new RestRequest("book/{id}", Method.Put);
            updateRequest.AddHeader("Authorization", $"Bearer {token}");
            updateRequest.AddUrlSegment("id", bookId);
            updateRequest.AddJsonBody(new
            {
                title = "Updated Book Title",
                author = "Updated Author"
            });

            var updatedResponse = client.Execute(updateRequest);

            Assert.Multiple(() =>
            {
                Assert.That(updatedResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Expected status code OK (200)");
                Assert.That(updatedResponse.Content, Is.Not.Empty, "Response content should not be empty");
                var content = JObject.Parse(updatedResponse.Content);

                Assert.That(content["title"]?.ToString(), Is.EqualTo("Updated Book Title"), "Book name should match the updated value");
                Assert.That(content["author"]?.ToString(), Is.EqualTo("Updated Author"), "Book author should match the updated value");

            });
        }

        [Test]
        public void Test_DeleteBook()
        {
            var getRequest = new RestRequest("book", Method.Get);
            var getResponse = client.Execute(getRequest);

            Assert.That(getResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Expected status code OK (200)");
            Assert.That(getResponse.Content, Is.Not.Empty, "Response content should not be empty");

            var books = JArray.Parse(getResponse.Content);
            var bookToDelete = books.FirstOrDefault(b => b["title"]?.ToString() == "To Kill a Mockingbird");

            Assert.That(bookToDelete, Is.Not.Null, "Book with title 'To Kill a Mockingbird' not found");

            var bookId = bookToDelete["_id"].ToString();
            var deleteRequest = new RestRequest("book/{id}", Method.Delete);
            deleteRequest.AddHeader("Authorization", $"Bearer {token}");
            deleteRequest.AddUrlSegment("id", bookId);

            var deleteResponse = client.Execute(deleteRequest);

            Assert.Multiple(() =>
            {
                Assert.That(deleteResponse.StatusCode, Is.EqualTo(HttpStatusCode.OK), "Expected status code OK (200)");
                var verifyGetRequest = new RestRequest("book/{id}", Method.Get);
                verifyGetRequest.AddUrlSegment("id", bookId);

                var verifyGetResponse = client.Execute(verifyGetRequest);

                Assert.That(verifyGetResponse.Content, Is.Null.Or.EqualTo("null"), "Verify get response content should be empty");


            });

        }

        public void Dispose()
        {
            client?.Dispose();
        }
    }
}
