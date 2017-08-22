#include <LiquidCrystal.h>

LiquidCrystal lcd2(13, 12, 5, 4, 3, 2);
String cadena2;

/*PRACTICA SENSOR MOVIMIENTO*/

void setup_1() {
  Serial.begin(9600);
  pinMode(10, INPUT);
  lcd2.begin(16, 2);
  lcd2.clear();
}

void loop_1() {
  if (digitalRead(6)) {
    Serial.println("Movimiento");
    cadena2 = "Movimiento";
      delay(1);
  } else {
    Serial.println("No Movimiento");
    cadena2 = "No Movimiento";
    delay(1);
  }
  /******************************************/
  while (Serial.available() > 0) {
    char car = Serial.read();
    cadena2 += car;
  }


  lcd2.clear();
  lcd2.setCursor(16, 0);
  //  lcd.autoscroll();
  int cont = 0;

  for (int i = 0; i < cadena2.length(); i++) {
    lcd2.print(cadena2.charAt(i));
    delay(3);
    if (++cont == cadena2.length()) {
      cont = 0;
      lcd2.clear();
      lcd2.setCursor(16, 0);
      lcd2.autoscroll();

    }
  }

  //}
  lcd2.clear();
  delay(1);
  cadena2 = "";
}
