#include <Stepper.h>

//Control de MOTOR a Pasos en Secuencia Normal (2 bobinas activadas por cada paso) para 4 estaciones

int motorPin1 = 8; // Pines del Motor
int motorPin2 = 9;
int motorPin3 = 10;
int motorPin4 = 11;
int deteccion = 120; // DelayTime determina la espera entre uno y otro paso
int delayTime1 = 100; // DelayTime1 determina la velocidad de giro entre uno y otro paso
int count = 0;
String tiempo = "";
String recibido;
boolean espera;

int stepCount = 0;


void setup_6()
{
  Serial.begin(9600);
  pinMode(motorPin1, OUTPUT); // Configuración de los Pines como salida digital
  pinMode(motorPin2, OUTPUT);
  pinMode(motorPin3, OUTPUT);
  pinMode(motorPin4, OUTPUT);
}

void loop_6()
{
  recibido = "";
  espera = true;
  //while (espera) {
    if (Serial.available()) {
      recibido = String("");
      while (Serial.available()) {
        recibido = recibido + char(Serial.read());
        delay(1);
      }
    }
    tiempo = recibido;
    if (tiempo != "") {
      espera = false;
    }
  //}
  recibido = "";

  for (int i = 0; i < tiempo.toInt(); i++) {
    // Aqui en el for es donde se manipulan los grados que se desean asignar al motor




    digitalWrite(motorPin1, HIGH); //cafe – A
    digitalWrite(motorPin2, HIGH); //negro – B
    digitalWrite(motorPin3, LOW); //morado – C
    digitalWrite(motorPin4, LOW); //naranja – D
    delay(deteccion); // Un micro segundo de espera

    digitalWrite(motorPin1, LOW);
    digitalWrite(motorPin2, HIGH);
    digitalWrite(motorPin3, HIGH);
    digitalWrite(motorPin4, LOW);
    delay(deteccion);
    digitalWrite(motorPin1, LOW);
    digitalWrite(motorPin2, LOW);
    digitalWrite(motorPin3, HIGH);
    digitalWrite(motorPin4, HIGH);
    delay(deteccion);
    digitalWrite(motorPin1, HIGH);
    digitalWrite(motorPin2, LOW);
    digitalWrite(motorPin3, LOW);
    digitalWrite(motorPin4, HIGH);
    delay(deteccion);
    if (Serial.available() > 0) {
      recibido = "";
      while (Serial.available()) {
        recibido = recibido + char(Serial.read());
        delay(1);
      }
      if (recibido.toInt() == 8) {
        break;
      }
    }
  }
  Serial.println("Termino");
  delay(500);


} //End For




//End Loop
