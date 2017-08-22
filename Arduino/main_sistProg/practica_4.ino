#include <Servo.h>

Servo myservo;
int angulo;
String charValue;

void setup_4() {
  Serial.begin(9600);
  Serial.println("Introduzca valor entre 0 y 100%");
  myservo.attach(7);
}

void loop_4() {
  
  while (Serial.available() > 0) {
    int charEntrada = Serial.read();
    if (isDigit(charEntrada)) {
      charValue += (char)charEntrada;
    }
    Serial.println(charValue);
    Serial.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
  }

  angulo = (charValue.toInt() * 180) / 100;
  Serial.print("El valor introducido genera un angulo de:");
  Serial.println(angulo);
  myservo.write(angulo);
  delay(500);
  charValue = "";
}
