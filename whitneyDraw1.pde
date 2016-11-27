private void whitneyDraw1(){ //draws a variety of whitney functions

  //stroke(LR,UD,160);
  background(#000F0D);
  //translate(width/2, height/2);

  for (int c = 0; c < NUM_LINES; c++){ //draws lines

    strokeWeight(2);
    if (key == 'a'){
    stroke(LR,UD,160);
		line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
  }
    else if (key == 'b'){
    stroke(168,UD,LR);
    line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;
  }

  else if (key == 'p'){
    strokeWeight(5);
    stroke(168,UD,LR);
    //point(w2x1(t+c*2), w2y1(t+c*2));
    //point((w2x1(t+c*2)) -10, (w2y1(t+c*2))-10);
    line(w3x1(-t+c*2), w3y1(-t+c*2) , w3x2(-t+c*2),  w3y2(-t+c*2)) ;
  }

  else  {
    //stroke(168,UD,LR);
    //line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2));
    stroke(LR,UD,160);
		//line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
    line(w3x1(-t+c*2), w3y1(-t+c*2) , w3x2(-t+c*2),  w3y2(-t+c*2)) ;
  }

}

t = t + 0.5 + Pulse*0.01;



}
