void oscEvent(OscMessage inp) {
  if(inp.checkAddrPattern("/myKick")==true){ //Kick Data
  float Kick = inp.get(0).floatValue();
  myKick = Kick;
  //println(Kick);
  return;
}

else if(inp.checkAddrPattern("/Delay")==true){ // HiHat Data
  float Delay = inp.get(0).floatValue();
  myVert =  map(Delay,0, 0.152,1,40);
  myDelay = map(Delay,0, 0.152,0,255);
  return;
}

else if(inp.checkAddrPattern("/Clap")==true ){ // Clap Data
  float Clap = inp.get(0).floatValue(); 
  if (Clap>0.1){
    myBG = 2;
    myTriColour = 255;
  }
  else if (Clap < 0.1){
    myBG = 0;
    myTriColour = 255;
    return;
  }

}
}