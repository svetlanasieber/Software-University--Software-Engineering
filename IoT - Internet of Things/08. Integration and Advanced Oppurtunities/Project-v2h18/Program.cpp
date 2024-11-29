#include <Adafruit_MPU6050.h>
#include <Adafruit_Sensor.h>
#include <Wire.h>

Adafruit_MPU6050 mpu1;
Adafruit_MPU6050 mpu2;

void setup(void) {
  Serial.begin(115200);
  uint32_t deviceId = 1;
  uint8_t address = 0x68;

  if (!mpu1.begin(address,&Wire,deviceId)) {
    Serial.println("Failed to find MPU6050 chip");
    while (1) {
      delay(10);
    }
  }
  
  Serial.println("MPU6050 1 Found!");
  // set accelometer range to +-8G
  mpu1.setAccelerometerRange(MPU6050_RANGE_8_G);

  //set gyro range to +- 500 deg/s
  mpu1.setGyroRange(MPU6050_RANGE_500_DEG);

  //set filter bandwith to 21 Hz
  mpu1.setFilterBandwidth(MPU6050_BAND_21_HZ);

  deviceId = 2;
  address = 0x69;

  if (!mpu2.begin(address,&Wire,deviceId)) {
    Serial.println("Failed to find MPU6050 chip");
    while (1) {
      delay(10);
    }
  }
 
  Serial.println("MPU6050 2 Found!");
// set accelometer range to +-8G
  mpu2.setAccelerometerRange(MPU6050_RANGE_8_G);

  //set gyro range to +- 500 deg/s
  mpu2.setGyroRange(MPU6050_RANGE_500_DEG);

  //set filter bandwith to 21 Hz
  mpu2.setFilterBandwidth(MPU6050_BAND_21_HZ);

  
  delay(100);

}
void getSensor1Data()
{
  //Get new sensor events with the readings
  sensors_event_t a1, g1, temp1;
  mpu1.getEvent(&a1, &g1, &temp1);
  

  //Print out the values
  Serial.print("Acceleration 1 x: ");
  Serial.print(a1.acceleration.x);
  Serial.print(", Y: ");
  Serial.print(a1.acceleration.y);
  Serial.print(", Z: ");
  Serial.print(a1.acceleration.z);
  Serial.println(" m/s^2");

  Serial.print("Rotation 1 x: ");
  Serial.print(g1.gyro.x);
  Serial.print(", Y: ");
  Serial.print(g1.gyro.y);
  Serial.print(", Z: ");
  Serial.print(g1.gyro.z);
  Serial.println(" rad/s");

  Serial.print("Temperature 1: ");
  Serial.print(temp1.temperature);
  Serial.println(" degC");

  Serial.println();
}

void getSensor2Data()
{
  //Get new sensor events with the readings
  sensors_event_t a2, g2, temp2;
  mpu2.getEvent(&a2, &g2, &temp2);
  

  //Print out the values
  Serial.print("Acceleration 2 x: ");
  Serial.print(a2.acceleration.x);
  Serial.print(", Y: ");
  Serial.print(a2.acceleration.y);
  Serial.print(", Z: ");
  Serial.print(a2.acceleration.z);
  Serial.println(" m/s^2");

  Serial.print("Rotation 2 x: ");
  Serial.print(g2.gyro.x);
  Serial.print(", Y: ");
  Serial.print(g2.gyro.y);
  Serial.print(", Z: ");
  Serial.print(g2.gyro.z);
  Serial.println(" rad/s");

  Serial.print("Temperature 2: ");
  Serial.print(temp2.temperature);
  Serial.println(" degC");

  Serial.println();
}

void loop() {
  getSensor1Data();
  delay(500);
  getSensor2Data();
  delay(500);

}
