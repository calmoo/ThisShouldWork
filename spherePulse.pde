void spherePulse(){
  if (myKick > 0.01){ //&& //millis() - time >= wait){
    while (Pulse < 20){
      Pulse = Pulse + 0.1;
    }
      //time = millis();
    }
    else if (myKick < 0.01){
      while (Pulse > 1){
        Pulse = Pulse - 0.1;
      }
    }
    return;

  }
