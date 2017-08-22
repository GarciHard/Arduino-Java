//#include <LiquidCrystal.h>
//
//LiquidCrystal lcd1(13, 12, 5, 4, 3, 2);
//String cadena1;
//String cadena2;
///*PRACTICA DE COLORES*/
//
//const int pinLed = 13;
//const int pinFoto = 9;
//
//void setup() {
//  Serial.begin(9600);
//  pinMode(pinLed, OUTPUT);
//  pinMode(pinFoto, INPUT);
//  lcd1.begin(16, 2);
//  lcd1.clear();
//}
//
//void loop() { 
//  digitalWrite(pinLed, HIGH);
//  int inFoto = analogRead(A0);
//  //float valorFoto = inFoto * (5.0 / 1023.0);
//  if (inFoto >= 700 && inFoto <= 900) {
//    Serial.println("Blanco");
//    cadena1 = "Blanco";
//    
//    
//    float voltFoto = inFoto * (5 / 1023);
//    float lumenes = ((long) inFoto * 1000 * 10) / ((long) 15 * 10 * (1024 - inFoto));
//    int lumenesRound = (int) lumenes;
//
//    cadena2 = lumenesRound;
//    
//  } else if (inFoto >= 650 && inFoto <= 699) {
//    Serial.println("Amarillo");
//    cadena1 = "Amarillo";
//  } else if (inFoto >= 500 && inFoto <= 549) {
//    Serial.println("Rojo");
//    cadena1 = "Rojo";
//  } else if (inFoto >= 400 && inFoto <= 449) {
//    Serial.println("Verde");
//    cadena1 = "Verde";
//  } else if (inFoto >= 350 && inFoto <= 399) {
//    Serial.println("Azul");
//    cadena1 = "Azul";
//  } else if (inFoto >= 0 && inFoto <= 200) {
//    Serial.println("Negro");
//    cadena1 = "Negro";
//  } else {
//    Serial.println("NA");
//    cadena1 = "NA";
//  }
//  //Serial.println(inFoto);
//  delay(1);    
//  /**********************************************/
//  
//  while (Serial.available() > 0) {
//    char car = Serial.read();
//    cadena1 += car;
//  }
//
//
//  lcd1.clear();
//  lcd1.setCursor(16, 0);
//  //  lcd.autoscroll();
//  int cont = 0;
//
//  for (int i = 0; i < cadena1.length(); i++) {
//    lcd1.print(cadena1.charAt(i));
//    delay(300);
//    if (++cont == cadena1.length()) {
//      cont = 0;
//      lcd1.clear();
//      lcd1.setCursor(16, 0);
//      lcd1.autoscroll();
//
//    }
//  }
///////
//  lcd1.clear();
//  lcd1.setCursor(16, 1);
//  //  lcd.autoscroll();
//  int cont1 = 0;
//  for (int i = 0; i < cadena2.length(); i++) {
//    lcd1.print(cadena2.charAt(i));
//    delay(300);
//    if (++cont1 == cadena2.length()) {
//      cont1 = 0;
//      lcd1.clear();
//      lcd1.setCursor(16, 1);
//      lcd1.autoscroll();
//
//    }
//  }
//  
///////
//  //}
//  lcd1.clear();
//  delay(1);
//  cadena1 = "";
//  cadena2 = "";
//}
//
///*void closeLoop_2() {
//  digitalWrite(pinLed, LOW);
//}*/



#include <stdio.h>
#include <math.h>

int analogPin=1;   // Which pin will be the input of the Voltage-Divider

float Vin=5.0;     // [V]        Supply voltage in the Voltage-Divider
float Raux=10000;  // [ohm]      Secondary resistor in the Voltage-Divider
float R0=10000;    // [ohm]      NTC nominal value at 25ºC
float T0=293.15;   // [K] (25ºC)

float Vout=0.0;    // [V]        Voltage given by the Voltage-Divider
float Rout=0.0;    // [ohm]      Current NTC resistance

float T1=273;      // [K]        Temperature at first testing point
float T2=373;      // [K]        Temperature at second testing point
float RT1=19750;   // [ohms]     Resistance at 273K (0ºC)
float RT2=2150;    // [ohms]     Resistance at 373K (100ºC)

float beta=0.0;    // [K]        Beta parameter
float Rinf=0.0;    // [ohm]      Rinf parameter
float TempK=0.0;   // [K]        Temperature output in Kelvin
float TempC=0.0;   // [ºC]       Temperature output in Celsius
/*********************/

#include <LiquidCrystal.h>

LiquidCrystal lcd1(13, 12, 5, 4, 3, 2);
String cadena1;
String cadena2;
/*PRACTICA DE COLORES*/

const int pinLed = 13;
const int pinFoto = 9;

void setup() {
  Serial.begin(9600);
/******************//******************/  
  //Input pin configuration
  pinMode(analogPin, INPUT);

  //Global parameters calculation
  beta=(log(RT1/RT2))/((1/T1)-(1/T2));
  Rinf=R0*exp(-beta/T0);
/******************//******************/
  
  pinMode(pinLed, OUTPUT);
  pinMode(pinFoto, INPUT);
  lcd1.begin(16, 2);
  lcd1.clear();
}

void loop() { 
  digitalWrite(pinLed, HIGH);
  int inFoto = analogRead(A0);
  //float valorFoto = inFoto * (5.0 / 1023.0);
  if (inFoto >= 700 && inFoto <= 900) {
    Serial.println("Blanco");
    cadena1 = "Blanco";  
  } else if (inFoto >= 650 && inFoto <= 699) {
    Serial.println("Amarillo");
    cadena1 = "Amarillo";
  } else if (inFoto >= 500 && inFoto <= 549) {
    Serial.println("Rojo");
    cadena1 = "Rojo";
  } else if (inFoto >= 400 && inFoto <= 449) {
    Serial.println("Verde");
    cadena1 = "Verde";
  } else if (inFoto >= 350 && inFoto <= 399) {
    Serial.println("Azul");
    cadena1 = "Azul";
  } else if (inFoto >= 0 && inFoto <= 200) {
    Serial.println("Negro");
    cadena1 = "Negro";
  } else {
    Serial.println("NA");
    cadena1 = "NA";
  }
  //Serial.println(inFoto);
  delay(1);    
  /**********************************************/
  
  while (Serial.available() > 0) {
    char car = Serial.read();
    cadena1 += car;
  }


  lcd1.clear();
  lcd1.setCursor(16, 0);
  //  lcd.autoscroll();
  int cont = 0;

  for (int i = 0; i < cadena1.length(); i++) {
    lcd1.print(cadena1.charAt(i));
    delay(300);
    if (++cont == cadena1.length()) {
      cont = 0;
      lcd1.clear();
      lcd1.setCursor(16, 0);
      lcd1.autoscroll();

    }
  }
////////////////////////////////////////////
//Current NTC resistance value calculation (through Vout)
Vout=Vin*((float)(analogRead(analogPin))/1024.0);
Rout=(Raux*Vout/(Vin-Vout));

//Temperature calculation
TempK=(beta/log(Rout/Rinf));
TempC=TempK-273.15;

//Data population
/*Serial.print(TempC);
Serial.print(" ºC (");
Serial.print(TempK);
Serial.println(" K)");*/
String a = (String)TempC;
String b = " ºC (";
String c = (String)TempK;
String d = " K)";

cadena2 = a + b + c + d;
//delay(1000);

  lcd1.clear();
  lcd1.setCursor(16, 1);
  //  lcd.autoscroll();
  int cont1 = 0;
  for (int i = 0; i < cadena2.length(); i++) {
    lcd1.print(cadena2.charAt(i));
    delay(300);
    if (++cont1 == cadena2.length()) {
      cont1 = 0;
      lcd1.clear();
      lcd1.setCursor(16, 1);
      lcd1.autoscroll();

    }
  }
  
////////////////////////////////////////////
  //}
  lcd1.clear();
  delay(1);
  cadena1 = "";
  cadena2 = "";
}

/*void closeLoop_2() {
  digitalWrite(pinLed, LOW);
}*/

