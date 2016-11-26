private void whitneyDraw2(){

  stroke(168,UD,LR);
  //background(#000F0D);


  for (int c = 0; c < 10; c++){ //draws lines

    strokeWeight(2);
		line(w2x1(-t+c*2), w2y1(-t+c*2) , w2x2(-t+c*2),  w2y2(-t+c*2)) ;

}

t++; // 1 + Pulse*0.1;



}
