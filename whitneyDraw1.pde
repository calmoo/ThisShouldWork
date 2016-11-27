private void whitneyDraw1(){ //draws a variety of whitney functions

  //stroke(LR,UD,160);
  background(#000F0D);
  //translate(width/2, height/2);

  for (int c = 0; c < NUM_LINES; c++){ //draws lines

    strokeWeight(2);
    if (key == 'a'){ // Whitney1
    stroke(LR,UD,160);
		line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
  }
    else if (key == 'b'){ //Whitney 2
    stroke(168,UD,LR);
    line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;
  }

  else if (key == 'p'){ //Whitney 2 points
    strokeWeight(5);
    stroke(168,UD,LR);
    point(w2x1(t+c*2), w2y1(t+c*2));
    point((w2x1(t+c*2)) -10, (w2y1(t+c*2))-10);

  }

  else if (key == 'y'){ //Whitney 3
    strokeWeight(3);
    stroke(120,UD,LR);
    //line(w3x1(-t+c), w3y1(-t+c) , w3x2(-t+c),  w3y2(-t+c)) ;
    point(w3x1(t+(c*0.001)), w3y1(t+(c*0.001))) ;
  }

  else  {
    stroke(168,UD,LR);
    line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2));
    stroke(LR,UD,160);
		line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;


  }

}

t = t + 0.0001; //+ Pulse*0.01;



}
