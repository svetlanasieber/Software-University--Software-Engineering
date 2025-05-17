#include <WiFi.h>
#include <WebServer.h>

const char* ssid = "Wokwi-GUEST";
const char* password = "";

WebServer server(80);  




float cTemp;
bool btnStatus = true;
void setup() {
    WiFi.begin(ssid, password);  

  while (WiFi.status() != WL_CONNECTED) {  
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.print("Web server is running at http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");


  server.onNotFound(handleAllRequests);

  server.begin();  


  pinMode(18, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(17, OUTPUT);
  pinMode(16, OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(0,OUTPUT);
  

  pinMode(25, INPUT);


  pinMode(27, INPUT);
  Serial.begin(115200);
  Serial.println("Hello, ESP32!");
}
void alarm()
{
  digitalWrite(18, HIGH);
  digitalWrite(5, HIGH);
  digitalWrite(17, HIGH);
  digitalWrite(16, HIGH);
  digitalWrite(4, HIGH);
  digitalWrite(0, HIGH);
  delay(1000);
  digitalWrite(18, LOW);
  digitalWrite(5, LOW);
  digitalWrite(17, LOW);
  digitalWrite(16, LOW);
  digitalWrite(4, LOW);
  digitalWrite(0, LOW);
  delay(1000);
}

void setLedBar(int currentTemerature, int targetTemperature)
{
  if(currentTemerature + 10 < targetTemperature) 
    digitalWrite(18, LOW);
  else digitalWrite(18, HIGH);
  if(currentTemerature + 5 < targetTemperature) 
    digitalWrite(5, LOW);
  else digitalWrite(5, HIGH);
  if(currentTemerature < targetTemperature) 
    digitalWrite(17, LOW);
  else digitalWrite(17, HIGH);
  if(currentTemerature -5 < targetTemperature) 
    digitalWrite(16, LOW);
  else digitalWrite(16, HIGH);
  if(currentTemerature -10 < targetTemperature) 
    digitalWrite(4, LOW);
  else digitalWrite(4, HIGH);
  if(currentTemerature -15 < targetTemperature) 
    digitalWrite(0, LOW);
  else digitalWrite(0, HIGH);

}
float getTemperature(int analogValue)
{
  float BETA = 3950; 
  float celsius = 1 / (log(1 / (4095.0 / analogValue - 1)) / BETA + 1.0 / 298.15) - 273.15;
  return celsius;
}
/*void setBtnStatus()
{
  if(digitalRead(27)==LOW) btnStatus = true;
  else btnStatus = true;
  Serial.println(btnStatus);
}*/

void handleAllRequests() {
  String message = "URI Requested: ";
  message += server.uri(); 

  if (server.uri() == "/") {
    server.send(200, "text/html", "<h1>Welcome to the ESP32 Web Server</h1>");
  } else if (server.uri() == "/info") {
    server.send(200, "text/html", String(getTemperature(analogRead(25))));
  } else {
    message += "\nHandled in generic function";
    server.send(200, "text/plain", message);
  }
}
void loop() {


 
  if(btnStatus){
  
  cTemp = getTemperature(analogRead(25));
 
  if(cTemp > 75.0) alarm();
  else setLedBar(cTemp, 55);
  }

  server.handleClient();  

  delay(10); 
}
