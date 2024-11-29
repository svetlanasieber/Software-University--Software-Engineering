#include <WiFi.h>
#include <WebServer.h>

// Replace with your network credentials
const char* ssid = "Wokwi-GUEST";
const char* password = "";

// Create WebServer object on port 80
WebServer server(80);

// HTML and JavaScript for the login page
const char login_html[] PROGMEM = R"rawliteral(
<!DOCTYPE HTML><html>
<head>
  <title>Login</title>
  <script>
    function submitCredentials() {
      var xhr = new XMLHttpRequest();
      var url = "/login";
      xhr.open("POST", url, true);
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
          var response = JSON.parse(xhr.responseText);
          if(response.success){
            window.location.href = "/";
          } else {
            alert("Login Failed");
          }
        }
      };
      var username = document.getElementById("username").value;
      var password = document.getElementById("password").value;
      var data = "username=" + username + "&password=" + password;
      xhr.send(data);
    }
  </script>
</head>
<body>
  <h2>Login</h2>
  <input type="text" id="username" placeholder="Username">
  <input type="password" id="password" placeholder="Password">
  <button onclick="submitCredentials()">Login</button>
</body>
</html>
)rawliteral";

// HTML for the main page
const char main_html[] PROGMEM = R"rawliteral(
<!DOCTYPE HTML><html>
<head>
  <title>Control Panel</title>
</head>
<body>
  <h1>Welcome to the Control Panel</h1>
  <p>Secure access granted.</p>
</body>
</html>
)rawliteral";

// Hardcoded credentials for simplicity
const char* validUsername = "admin";
const char* validPassword = "admin";

// Function to handle root route
void handleRoot() {
  if (!isAuthenticated()) {
    server.send(200, "text/html", login_html);
  } else {
    server.send(200, "text/html", main_html);
  }
}

// Function to handle login route
void handleLogin() {
  if (server.method() == HTTP_POST) {
    String username = server.arg("username");
    String password = server.arg("password");
    if (username == validUsername && password == validPassword) {
      server.send(200, "application/json", "{\"success\":true}");
    } else {
      server.send(200, "application/json", "{\"success\":false}");
    }
  }
}

// Function to check if the user is authenticated
bool isAuthenticated() {
  // For simplicity, we're not implementing session management here.
  // In a real application, you would check a session or token.
  return false;
}

void setup() {
  // Start serial communication
  Serial.begin(115200);

  // Connect to Wi-Fi
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());

  // Define routes
  server.on("/", handleRoot);
  server.on("/login", handleLogin);

  // Start server
  server.begin();
}

void loop() {
  server.handleClient();
}
