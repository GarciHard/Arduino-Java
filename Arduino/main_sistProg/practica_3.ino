/*PRACTICA DE LUMENES*/

const int led = 13;
const int foto = 9;

void setup_3() {
  Serial.begin(9600);
  pinMode(led, OUTPUT);
  pinMode(foto, INPUT);
}

void loop_3() {
  digitalWrite(led, HIGH);
  int inFoto = analogRead(A0);
  float voltFoto = inFoto * (5 / 1023);
  float lumenes = ((long) inFoto * 1000 * 10) / ((long) 15 * 10 * (1024 - inFoto));
  int lumenesRound = (int) lumenes;
  Serial.println(lumenesRound);
  delay(500);    
}

void closeLoop_3() {
  digitalWrite(led, LOW);
}
