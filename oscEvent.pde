//Reads all incoming OSC data from Ableton and parses into global variables.

void oscEvent(OscMessage inp) {
  if (inp.checkAddrPattern("/myKick")==true){ //Kick Data
  float Kick = inp.get(0).floatValue();
  Pulse = Kick;
  if (Pulse > 0){
  kickCounter++;
  if (kickCounter > 7){
    kickCounter = 0;
  }
  println(kickCounter);
}
  return;
}

else if (inp.checkAddrPattern("/Delay")==true){ // HiHat Data
  float Delay = inp.get(0).floatValue();
  myVert =  map(Delay,0, 0.152,1,40);
  myDelay = map(Delay,0, 0.152,0,255);
  return;
}

else if (inp.checkAddrPattern("/Clap")==true){ // Clap Data
  float Clap = inp.get(0).floatValue();
  return;

  }

}
