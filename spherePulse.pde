void spherePulse(){
  if (myKick > 0.01){ //&& //millis() - time >= wait){
    for (int i = 0; i < 60; i++){
    Pulse = i;
    }
      //time = millis();
    }
    else if (myKick < 0.01){
      for (int i = 60; i > 0; i--){
      Pulse = i;
      }
    }
    return;

  }
