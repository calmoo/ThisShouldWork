void incrementLR(){

  while (LR < 150){
    LR = LR + 0.1;
  //   LR = LR + int(myVert);

    if (LR >150){
      LR = 1;
    }
    //println(LR);
    return;

  }
}
