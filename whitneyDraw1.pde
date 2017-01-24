void whitneyDraw1(){ //draws a variety of whitney functions
  float spc = 0.001;
  float tc = 0.0005;

  float r =200; //radius of rotation
  float a;
  int w = 80;



  background(#000F0D);
  for (float c = 1; c < 20; c = c + 1){ //draws lines

    strokeWeight(2);
    if (key == 'q'){ // Whitney1

      stroke(LR,UD,160);
      pushMatrix();
      translate(width/2, height/2);
      line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
      popMatrix();
    }
    else if (key == 'w'){ //Whitney 2
      pushMatrix();
      translate(width/2, height/2);
      stroke(168,UD,LR);
      line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;
      popMatrix();
    }

    else if (key == 'e'){ //Whitney 2 points
      pushMatrix();
      translate(width/2, height/2);
      strokeWeight(5);
      stroke(168,UD,LR);
      point(w2x1(t+c*2), w2y1(t+c*2));
      point((w2x1(t+c*2)) -10, (w2y1(t+c*2))-10);
      popMatrix();

    }

    else if (key == 'r'){ //Whitney 3
      pushMatrix();
      translate(width/2, height/2);
      strokeWeight(2);
      stroke(120,UD,LR);
      line(w3x1((-t*tc)+(c *spc)), w3y1((-t*tc)+(c *spc)), w3x2((-t*tc)+(c *spc)),  w3y2((-t*tc)+(c *spc))) ;
      //point(w3x1((t+c)*50), w3y1((t+c)* 50)) ;
      popMatrix();
    }

    else if (key == 't'){ // Whitney harmonix
      pushMatrix();
      translate(width/2, height/2);
      noFill();
      strokeWeight(2);
      stroke(149,UD,LR);
      //troke(184,124,82);
      ellipse((200+l)*cos(c*s*l),(200+l)*sin(c*s*l), w +5 + (c*4), w + 5  +(c*4) );
      popMatrix();
    }

    else if (key =='y'){
      //background(#000F0D);
      particleSystem();

      //println(Pulse);
    }
  /*  else if (key == 'u'){
      pushMatrix();
      translate(width/2, height/2);
      //  pushMatrix();
      drawCircle(0,0,2);
      popMatrix();

    }

    else   {
      break;
      /*stroke(168,UD,LR);
      line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2));
      stroke(LR,UD,160);
      line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
*/

}



  if(Pulse > 0.02){
    l = l + s;
    t = t  + 2;
  }
  else{
    l = l + s;
    t = t + 0.5;
  }
}
