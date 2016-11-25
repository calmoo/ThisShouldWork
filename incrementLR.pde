void incrementLR(){

  while (LR < 110){
    LR = LR + 0.1;
    LR = LR + int(myVert);
    
    if (LR >110){
      LR = 1;
    }
    //println(LR);
    return;

  }
}