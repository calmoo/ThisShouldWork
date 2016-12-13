void whitneyDraw1(){ //draws a variety of whitney functions
  float spc = 0.001;
  float tc = 0.0005;

  float r =200; //radius of rotation
  float a;

   //speed of rotation
  int w = 80;
  //stroke(LR,UD,160);
  background(#000F0D);
  //translate(width/2, height/2);

  for (float c = 1; c < 20; c = c + 1){ //draws lines

    strokeWeight(2);
    if (key == 'q'){ // Whitney1
    stroke(LR,UD,160);
		line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
  }
    else if (key == 'w'){ //Whitney 2
    stroke(168,UD,LR);
    line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;
  }

  else if (key == 'e'){ //Whitney 2 points
    strokeWeight(5);
    stroke(168,UD,LR);
    point(w2x1(t+c*2), w2y1(t+c*2));
    point((w2x1(t+c*2)) -10, (w2y1(t+c*2))-10);

  }

  else if (key == 'r'){ //Whitney 3
    strokeWeight(2);
    stroke(120,UD,LR);
    line(w3x1((-t*tc)+(c *spc)), w3y1((-t*tc)+(c *spc)), w3x2((-t*tc)+(c *spc)),  w3y2((-t*tc)+(c *spc))) ;
    //point(w3x1((t+c)*50), w3y1((t+c)* 50)) ;
  }

  else if (key == 't'){ // Whitney harmonix
    noFill();
    strokeWeight(2);
    stroke(149,UD,LR);
    //troke(184,124,82);
    ellipse(200*cos(c*s*l),200*sin(c*s*l), w +5 + (c*4), w + 5  +(c*4) );
  }





  else  {
    stroke(168,UD,LR);
    line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2));
    stroke(LR,UD,160);
		line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;


  }

}
//+ Pulse*0.01;
l = l + s;
t = t + 1;


}
