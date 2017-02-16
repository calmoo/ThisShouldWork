
float charlie = 1;
void incrementUD(){

  if (UD <= 1){
    UD = 1;
     charlie = 1;
  }
  if (UD >= 170){
    UD = 170;
    charlie = -1;
  }
  //float conColour = constrain(colourNudge,0,170 - colourNudge);
  if (charlie == 1){
  UD += charlie  + colourNudge;
}
  if (charlie == -1){
    UD += charlie  - colourNudge;


}
}
