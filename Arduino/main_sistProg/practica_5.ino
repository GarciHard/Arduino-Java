/*#include <LiquidCrystal.h>

  //LiquidCrystal lcd (1, 2, 4, 5, 6, 7);
  LiquidCrystal lcd(13, 12, 5, 4, 3, 2);
  String cadena;

  void setup_5() {
  Serial.begin(9600);
  lcd.begin(16, 2);
  lcd.clear();
  }

  void loop_5() {

  cadena = "";
  while (Serial.available() > 0) {
    char car = Serial.read();
    cadena += car;
  }

  lcd.clear();
  lcd.setCursor(16, 0);
  int cont = 0;

  for (int i = 0; i < cadena.length(); i++) {
    lcd.print(cadena.charAt(i));
    delay(300);
    if (++cont == cadena.length()) {
      cont = 0;
      lcd.clear();
      lcd.setCursor(16, 0);
      lcd.autoscroll();

    }
  }

  lcd.clear();
  delay(500);

  /*
    if (Serial.available()) {
    delay(1500);

    cadena = "";
    while (Serial.available() > 0) {
      char car = Serial.read();
      cadena += car;
    }
    if (cadena.length() > 1) {
      lcd.clear();
      lcd.setCursor(0,0);

      lcd.print("Num car");
      lcd.setCursor(8,0);
      lcd.println(cadena.length());

      delay(1500);

      lcd.clear();
      lcd.setCursor(16,0);
      lcd.autoscroll();
      int cont = 0;
      // Comienza la imprecion de los datos
        for(int i = 0;i<cadena.length();i++){
          lcd.print(cadena.charAt(i));
          delay(150);
          if(++cont == 16){
            cont = 0;
            lcd.clear();
            lcd.setCursor(16,0);
            lcd.autoscroll();
          }
        }
        delay(300);
    }
    }*/
//}




#include <LiquidCrystal.h>
//LiquidCrystal lcd(13, 12, 5, 4, 3, 2);
//LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
LiquidCrystal lcd(13, 12, 5, 4, 3, 2);

byte incomingByte;

String cadena;

void setup_5() {
  Serial.begin(9600);
  lcd.begin(16, 2);
  lcd.clear();
}

void loop_5() {
  //if (Serial.available()) {
    //incomingByte = Serial.read();
    //analogWrite(12, int(incomingByte));
  //}

  cadena = "";
  while (Serial.available() > 0) {
    char car = Serial.read();
    cadena += car;
  }


  lcd.clear();
  lcd.setCursor(16, 0);
  //  lcd.autoscroll();
  int cont = 0;

  for (int i = 0; i < cadena.length(); i++) {
    lcd.print(cadena.charAt(i));
    delay(300);
    if (++cont == cadena.length()) {
      cont = 0;
      lcd.clear();
      lcd.setCursor(16, 0);
      lcd.autoscroll();

    }
  }

  //}
  lcd.clear();
  delay(500);
  cadena = "";
}
//}//ifcadenalength>1
//ifserialavailable
//}
