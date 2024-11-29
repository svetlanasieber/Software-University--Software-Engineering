#include <WiFi.h>
#include <WebServer.h>


const char* ssid = "Wokwi-GUEST";
const char* password = "";

WebServer server(80);  

void handleAllRequests() {
  String message = "URI Requested: ";
  message += server.uri();  // Get the requested URI


  if (server.uri() == "/") {
    server.send(200, "text/html", "<h1>Welcome to the ESP32 Web Server</h1>");
  } else if (server.uri() == "/info") {
    server.send(200, "text/html", "<h1>Information Page</h1>");
  } else {
    message += "\nHandled in generic function";
    server.send(200, "text/plain", message);
  }
}

void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password); 

  while (WiFi.status() != WL_CONNECTED) {  /
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.print("Web server is running at http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");


  server.onNotFound(handleAllRequests);

  server.begin();  
}

void loop() {
  server.handleClient();  
}
