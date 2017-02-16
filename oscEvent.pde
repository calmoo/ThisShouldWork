//Reads all incoming OSC data from Ableton and parses into global variables.

void oscEvent(OscMessage inp) {
  if (inp.checkAddrPattern("/myKick")==true){ //Kick Data
  float Pulse = inp.get(0).floatValue();
  if (Pulse > 0){
  kickCounter++;
  if (kickCounter > 7){
    kickCounter = 0;
  }
  //println(kickCounter);
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
  println(Clap);
  colourNudge = Clap * 30;
  println(colourNudge);
  if (Clap > 0){
   // colourNudge = 50;
    clapCounter += sceneChangeFreq;
    sceneIntervalCounter = int(clapCounter);
  //  println(clapCounter);

  //  println(clapCounter);

    if (sceneIntervalCounter > 7){
      clapCounter = 0;
      sceneIntervalCounter = 0;
    }
  }
  return;

}

}
