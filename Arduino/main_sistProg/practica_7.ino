#include <math.h>
#include <LiquidCrystal.h>

LiquidCrystal lcd3(13, 12, 5, 4, 3, 2);
String cadena3;
String num;

const int Rc = 10000; //valor de la resistencia
const int Vcc = 5;
const int SensorPIN = A0;
 
float A = 1.11492089e-3;
float B = 2.372075385e-4;
float C = 6.954079529e-8;
 
float K = 2.5; //factor de disipacion en mW/C
 
void setup_7()
{
  Serial.begin(9600);
  lcd3.begin(16, 2);
  lcd3.clear();
}
 
void loop_7() 
{
  float raw = analogRead(SensorPIN);
  float V =  raw / 1024 * Vcc;
 
  float R = (Rc * V ) / (Vcc - V);
  
 
  float logR  = log(R);
  float R_th = 1.0 / (A + B * logR + C * logR * logR * logR );
 
  float kelvin = R_th - V*V/(K * R)*1000;
  float celsius = kelvin - 273.15;
 
  Serial.print("T = ");
  Serial.print(celsius);
  Serial.print("C\n");

  String temp = "T :";
  num = celsius;
  String cel = "C";
  cadena3 = temp + num + cel;
  
  delay(1);
/****************************************************************/
  while (Serial.available() > 0) {
    char car = Serial.read();
    cadena3 += car;
  }


  lcd3.clear();
  lcd3.setCursor(16, 0);
  //  lcd.autoscroll();
  int cont = 0;

  for (int i = 0; i < cadena3.length(); i++) {
    lcd3.print(cadena3.charAt(i));
    delay(300);
    if (++cont == cadena3.length()) {
      cont = 0;
      lcd3.clear();
      lcd3.setCursor(16, 0);
      lcd3.autoscroll();

    }
  }

  //}
  lcd3.clear();
  delay(500);
  cadena3 = "";


  
}
