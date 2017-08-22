#include <LiquidCrystal.h>

LiquidCrystal lcd1(13, 12, 5, 4, 3, 2);
String cadena1;
/*PRACTICA DE COLORES*/

const int pinLed = 13;
const int pinFoto = 9;

void setup_2() {
  Serial.begin(9600);
  pinMode(pinLed, OUTPUT);
  pinMode(pinFoto, INPUT);
  lcd1.begin(16, 2);
  lcd1.clear();
}

void loop_2() { 
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

  //}
  lcd1.clear();
  delay(1);
  cadena1 = "";
}

void closeLoop_2() {
  digitalWrite(pinLed, LOW);
}

