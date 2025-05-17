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

#define TEMP_ADC 25

#define BTN_PIN 27

#define TARGET_TEMP 47

float cTemp;
bool btnStatus = true;

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
void setup() {

  ledBarSetup();
  temperatureSetup();
  btnSetup();
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
  return digitalRead(BTN_PIN);
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
