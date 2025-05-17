#include <WiFi.h>
#include <WiFiClient.h>
#include <WebServer.h>
#include <uri/UriBraces.h>
using namespace std;

#define LED0 19
#define LED1 18
#define LED2 5
#define LED3 17
#define LED4 16
#define LED5 4
#define LED6 0
#define LED7 2
#define LED8 15
#define LED9 13

#define TEMP_ADC 33

#define BTN_PIN 27

#define TARGET_TEMP 55

#define WIFI_SSID "Wokwi-GUEST"
#define WIFI_PASSWORD ""

float cTemp;
bool btnStatus = true;

WebServer server(80);
float getTemperature(int analogValue);

void ledBarSetup()
{
  pinMode(LED0, OUTPUT);
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
  pinMode(LED4, OUTPUT);
  pinMode(LED5, OUTPUT);
  pinMode(LED6, OUTPUT);
  pinMode(LED7, OUTPUT);
  pinMode(LED8, OUTPUT);
  pinMode(LED9, OUTPUT);
}
void temperatureSetup()
{
  pinMode(TEMP_ADC, INPUT);
}

void btnSetup()
{
  pinMode(BTN_PIN, INPUT);
}
void sendHtml() {
  char text[100];
  String response = R"(
    <!DOCTYPE html>
<html>
  <head>
    <title>Sous-vide Monitoring Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
      html { font-family: sans-serif; text-align: center; }
      body { display: flex; flex-direction: column; align-items: center; }
      h1 { margin-bottom: 1.2em; }
      h2 { margin: 0; margin-bottom: 0.5em; }
      .container { display: flex; flex-direction: column; align-items: center; }
      .row { display: flex; flex-direction: row; align-items: center; margin-bottom: 1em; }
      .btn { border: none; padding: 0.5em 1em; font-size: 2em; text-decoration: none; color: white; }
      .btn.on { background-color: green; }
      .btn.off { background-color: red; }
      .TEXT { font-size: 40px; margin-left: 1em; }
      .red { color: red; }
    </style>
  </head>

  <body>
    <h1>Sous-vide Current Status</h1>

    <div class="container">
      <div class="row">
        <h2>Current Temperature</h2>
        <p id="currentTemperature" class="TEXT">Curr_Temp</p>
      </div>
      <div class="row">
        <h2>Target Temperature</h2>
        <p id="targetTemperature" class="TEXT">Target_Temp</p>
      </div>
      <div class="row">
        <h2>Button</h2>
        <a id="toggleButton" href="/toggle" class="btn">Toggle</a>
      </div>
    </div>

    <script>
    
      const currentTemperature = parseFloat(document.getElementById('currentTemperature').textContent);
      const targetTemperature = parseFloat(document.getElementById('targetTemperature').textContent);

     
      if (currentTemperature > targetTemperature) {
        document.getElementById('currentTemperature').classList.add('red');
      }

   
      const isOn = btn_status; 

  
      const toggleButton = document.getElementById('toggleButton');

    
      if (isOn) {
        toggleButton.textContent = 'Turn Off';
        toggleButton.classList.add('on');
        toggleButton.classList.remove('off');
      } else {
        toggleButton.textContent = 'Turn On';
        toggleButton.classList.add('off');
        toggleButton.classList.remove('on');
      }
    </script>
  </body>
</html>
  )";
  response.replace("Curr_Temp", String(getTemperature(analogRead(TEMP_ADC))));
  response.replace("Target_Temp", String(TARGET_TEMP));
  response.replace("btn_status", btnStatus ? "true" : "false");
  server.send(200, "text/html", response);
}
void toggleButton()
{ 
  btnStatus = !btnStatus;
  sendHtml();

}
void wifiSetup()
{
  int retries = 0;
  unsigned long startTime =
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to WiFi ");
  Serial.print(WIFI_SSID);
  // Wait for connection
  startTime = millis();
  while (WiFi.status() != WL_CONNECTED && retries < 3) {
    if (millis() - startTime > 10000) {  
      Serial.println("Connection Timeout. Retrying...");
      retries++;
      WiFi.disconnect();
      WiFi.begin(WIFI_SSID, WIFI_PASSWORD); 
      startTime = millis();  
    }
    delay(500);
  }
  if (WiFi.status() == WL_CONNECTED) {
    Serial.println("Connected to WiFi!");
    Serial.print("IP Address: ");
    Serial.println(WiFi.localIP());
  } else {
    Serial.println("Failed to connect to WiFi. Please check your settings.");

  }
  server.on("/", sendHtml);
  server.on("/toggle", toggleButton);
  server.begin();

}

void setup() {

  ledBarSetup();
  temperatureSetup();
  btnSetup();
  wifiSetup();
  Serial.begin(115200);
}
void alarm()
{
  digitalWrite(LED0, HIGH);
  digitalWrite(LED1, HIGH);
  digitalWrite(LED2, HIGH);
  digitalWrite(LED3, HIGH);
  digitalWrite(LED4, HIGH);
  digitalWrite(LED5, HIGH);
  digitalWrite(LED6, HIGH);
  digitalWrite(LED7, HIGH);
  digitalWrite(LED8, HIGH);
  digitalWrite(LED9, HIGH);
  delay(1000);
  digitalWrite(LED0, LOW);
  digitalWrite(LED1, LOW);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, LOW);
  digitalWrite(LED4, LOW);
  digitalWrite(LED5, LOW);
  digitalWrite(LED6, LOW);
  digitalWrite(LED7, LOW);
  digitalWrite(LED8, LOW);
  digitalWrite(LED9, LOW);
  delay(1000);
}

void setLedBar(float currentTemerature, float targetTemperature)
{
  Serial.println(currentTemerature);
  if (currentTemerature - 20 < targetTemperature)
    digitalWrite(LED0, LOW);
  else digitalWrite(LED0, HIGH);
  if (currentTemerature - 15 < targetTemperature)
    digitalWrite(LED1, LOW);
  else digitalWrite(LED1, HIGH);
  if (currentTemerature - 10 < targetTemperature)
    digitalWrite(LED2, LOW);
  else digitalWrite(LED2, HIGH);
  if (currentTemerature - 5 < targetTemperature)
    digitalWrite(LED3, LOW);
  else digitalWrite(LED3, HIGH);
  if (currentTemerature < targetTemperature)
    digitalWrite(LED4, LOW);
  else digitalWrite(LED4, HIGH);
  if (currentTemerature + 5 < targetTemperature)
    digitalWrite(LED5, LOW);
  else digitalWrite(LED5, HIGH);
  if (currentTemerature + 10 < targetTemperature)
    digitalWrite(LED6, LOW);
  else digitalWrite(LED6, HIGH);
  if (currentTemerature + 15 < targetTemperature)
    digitalWrite(LED7, LOW);
  else digitalWrite(LED7, HIGH);
  if (currentTemerature + 20 < targetTemperature)
    digitalWrite(LED8, LOW);
  else digitalWrite(LED8, HIGH);
  if (currentTemerature + 25 < targetTemperature)
    digitalWrite(LED9, LOW);
  else digitalWrite(LED9, HIGH);


}
float getTemperature(int analogValue)
{
  float BETA = 3950;
  float celsius = 1 / (log(1 / (4095.0 / analogValue - 1)) / BETA + 1.0 / 298.15) - 273.15;
  return celsius;
}
bool readButton()
{
  return btnStatus&digitalRead(BTN_PIN);
}
void turnOffLedBar()
{
  digitalWrite(LED0, LOW);
  digitalWrite(LED1, LOW);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, LOW);
  digitalWrite(LED4, LOW);
  digitalWrite(LED5, LOW);
  digitalWrite(LED6, LOW);
  digitalWrite(LED7, LOW);
  digitalWrite(LED8, LOW);
  digitalWrite(LED9, LOW);
}
void loop() {
  server.handleClient();
  cTemp = getTemperature(analogRead(TEMP_ADC));
  if (readButton()) {
    if (cTemp > 75.0)
      alarm();
    else
      setLedBar(cTemp, TARGET_TEMP);
  }
  else
    turnOffLedBar();

  delay(10); 
}
