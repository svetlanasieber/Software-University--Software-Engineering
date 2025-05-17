#include <WiFi.h>
#include <WebServer.h>

const char* ssid = "Wokwi-GUEST";
const char* password = "";

WebServer server(80);

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


const char* validUsername = "admin";
const char* validPassword = "admin";


void handleRoot() {
  if (!isAuthenticated()) {
    server.send(200, "text/html", login_html);
  } else {
    server.send(200, "text/html", main_html);
  }
}


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


bool isAuthenticated() {

  return false;
}

void setup() {

  Serial.begin(115200);

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());

  server.on("/", handleRoot);
  server.on("/login", handleLogin);

  server.begin();
}

void loop() {
  server.handleClient();
}
