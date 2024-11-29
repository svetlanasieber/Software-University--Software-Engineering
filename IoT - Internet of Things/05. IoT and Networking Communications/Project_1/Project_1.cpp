#include <WiFi.h>

String networks[3];

void setup() {
  Serial.begin(115200);

  networks[0] = "test1";
  networks[1] = "Wokwi-GUEST";
  networks[2] = "Wokwi-GUEST1";





  WiFi.mode(WIFI_STA);
  WiFi.disconnect();  // Disconnect any existing connection
  Serial.println("Setup done");
}

void loop() {
  Serial.println("Scan start");

  
  int n = WiFi.scanNetworks();
  Serial.println("Scan done");
  if (n == 0) {
    Serial.println("No networks found");
  } else {
    Serial.print(n);
    Serial.println(" networks found");
    for (int i = 0; i < n; ++i) {
    
      Serial.print(i + 1);
      Serial.print(": ");
      Serial.print(WiFi.SSID(i));
      Serial.print(" (");
      Serial.print(WiFi.RSSI(i));
      Serial.print(" dBm)");
      Serial.print(" Ch:");
      Serial.print(WiFi.channel(i));
      Serial.print(" Enc:");
  
      byte encryptionType = WiFi.encryptionType(i);
      switch (encryptionType) {
        case WIFI_AUTH_OPEN:
          Serial.println("Open");
          break;
        case WIFI_AUTH_WEP:
          Serial.println("WEP");
          break;
        case WIFI_AUTH_WPA_PSK:
          Serial.println("WPA_PSK");
          break;
        case WIFI_AUTH_WPA2_PSK:
          Serial.println("WPA2_PSK");
          break;
        case WIFI_AUTH_WPA_WPA2_PSK:
          Serial.println("WPA/WPA2_PSK");
          break;
        case WIFI_AUTH_WPA2_ENTERPRISE:
          Serial.println("WPA2_ENTERPRISE");
          break;
        default:
          Serial.println("Unknown");
      }
      delay(10); 
     

      for(int index = 0; index < 3; index++)
      {
        Serial.println("Current network: "+ networks[index]);
        if(networks[index].equals(WiFi.SSID(i)))
        {
          Serial.println("Network found!");
          WiFi.begin(WiFi.SSID(i),"");
          while(WiFi.status()!=WL_CONNECTED)
          {
            Serial.println(".");
            delay(100);
          }
        }
      }


    }
  }
  Serial.println("");
  // Wait a bit before scanning again
  delay(5000);
}
