char opcionSerial = -1;

void setup() {
  Serial.begin(9600);
}

void loop() {
  if (Serial.available() > 0) {
    opcionSerial = Serial.read();
    switch (opcionSerial) {
        setup_1();
      case '1' :
        do {
          opcionSerial = Serial.read();
          loop_1();
        } while (opcionSerial != '0');
        break;
      case '2' :
        //Setup práctica 2
        setup_2();
        do {
          opcionSerial = Serial.read();
          loop_2();
        } while (opcionSerial != '0');
        //Cerramos Setup práctica 2
        closeLoop_2();
        break;
      case '3' :
        //Setup práctica 3
        setup_3();
        do {
          opcionSerial = Serial.read();
          loop_3();
        } while (opcionSerial != '0');
        //Cerramos Setup práctica 3
        closeLoop_3();
        break;
      case '4' :
        setup_4();
        do {
          opcionSerial = Serial.read();
          loop_4();
        } while (opcionSerial != '0');
        break;
      case '5':
        setup_5();
        do {
          opcionSerial = Serial.read();
          loop_5();
        } while (opcionSerial != '0');
        break;
       case '6':
        setup_6();
        do {
          opcionSerial = Serial.read();
          loop_6();
        } while (opcionSerial != '0');
       break;
       case '7':
       setup_7();
       do {
        opcionSerial = Serial.read();
        loop_7();
       } while (opcionSerial != '0');
       break;
    }
    //Serial.println("Sale del ciclo ...");
  }
}

