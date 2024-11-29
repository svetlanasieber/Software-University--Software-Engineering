float cTemp;
bool btnStatus = true;
void setup() {
  // put your setup code here, to run once:

  //LED bar initialization
  pinMode(18, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(17, OUTPUT);
  pinMode(16, OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(0,OUTPUT);
  
  //NTC init
  pinMode(25, INPUT);

  //Button init
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
  float BETA = 3950; // should match the Beta Coefficient of the thermistor
  float celsius = 1 / (log(1 / (4095.0 / analogValue - 1)) / BETA + 1.0 / 298.15) - 273.15;
  return celsius;
}
/*void setBtnStatus()
{
  if(digitalRead(27)==LOW) btnStatus = true;
  else btnStatus = true;
  Serial.println(btnStatus);
}*/
void loop() {
  //setBtnStatus();
  if(btnStatus){
  
  cTemp = getTemperature(analogRead(25));
 
  if(cTemp > 75.0) alarm();
  else setLedBar(cTemp, 55);
  }
  // put your main code here, to run repeatedly:
  delay(10); // this speeds up the simulation
}
