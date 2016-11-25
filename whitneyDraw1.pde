void whitneyDraw(){
background(#000F0D);
  stroke(LR,UD,160);
  strokeWeight(4);
  translate(width/2, height/2);

  for (int c = 0; c < NUM_LINES; c++){ //draws lines

		line(x1(-t+c*2), y1(-t+c*2) , x2(-t+c*2),  y2(-t+c*2)) ;

}

t += 1 + Pulse*0.1;



}
