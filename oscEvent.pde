//Reads all incoming OSC data from Ableton and parses into global variables.

void oscEvent(OscMessage inp) {
  if (inp.checkAddrPattern("/myKick")==true) { //Kick Data
    int Pulse = inp.get(0).intValue();
    if (Pulse > 0) {
      kickCounter++;
      if (kickCounter > 7) {
        kickCounter = 0;
      }
    }
    return;
  } else if (inp.checkAddrPattern("/Delay")==true) { // HiHat Data\
    int Delay = inp.get(0).intValue();
    delayTrigger = Delay;
    return;
  } else if (inp.checkAddrPattern("/Clap")==true) { // Clap Data
    int Clap = inp.get(0).intValue();
    if (Clap > 0) {

      colourNudge = 10;
      clapCounter += sceneChangeFreq;
      sceneIntervalCounter = int(clapCounter);

      if (sceneIntervalCounter > 7) {
        clapCounter = 0;
        sceneIntervalCounter = 0;
      }
    } else {
      colourNudge = 0;
    }
    return;
  } else if (inp.checkAddrPattern("/Cutoff")==true) {
    float Cutoff = inp.get(0).floatValue();
    freqCutoff = Cutoff;
  }
}