void whitneyDraw1(){ //draws a variety of whitney functions

  float spc = 0.001;
  float tc = 0.0005;
  float r =200; //radius of rotation
  float a;
  int w = 80;

    if ((sceneIntervalCounter != 5) && (sceneIntervalCounter != 7)){
        background(defBackground);
        background (map(kickCounter,0,7,0,80),40,UD);
      }

    for (float c = 1; c < 50; c = c + 1){ //draws lines
      strokeWeight(2);

      switch(sceneIntervalCounter){

      case 0: // Whitney1

        stroke(LR,UD,160);
        pushMatrix();
      //  blendMode(ADD);
        translate(width/2, height/2);
        line(w1x1(-t + c*2), w1y1(-t +c*2) , w1x2(-t + c*2),  w1y2(-t + c*2)) ;
        popMatrix();
        break;

      case 1: //Whitney 2
        pushMatrix();
      //  blendMode(SUBTRACT);
      //  circleSystem();
        translate(width/2, height/2);
        stroke(168,UD,LR);
        line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;
        popMatrix();
        break;

      case 2: //Whitney 2 points
        pushMatrix();
        //blendMode(DIFFERENCE);
        translate(width/2, height/2);
        strokeWeight(5);
        stroke(168,UD,LR);
        point(w2x1(t+c*2), w2y1(t+c*2));
        point((w2x1(t+c*2)) -10, (w2y1(t+c*2))-10);
        popMatrix();
        break;



      case 3: //Whitney 3
        pushMatrix();
        translate(width/2, height/2);
        strokeWeight(2);
        stroke(120,UD,LR);
        line(w3x1((-t*tc)+(c *spc)), w3y1((-t*tc)+(c *spc)), w3x2((-t*tc)+(c *spc)),  w3y2((-t*tc)+(c *spc))) ;
        //point(w3x1((t+c)*50), w3y1((t+c)* 50)) ;
        popMatrix();
        break;


      case 4: // Whitney harmonix
        pushMatrix();
      //  blendMode(MULTIPLY);
        translate(width/2, height/2);
        noFill();
        strokeWeight(2);
        stroke(149,-LR,LR);
        ellipse((200+l)*cos(c*s*l),(200+l)*sin(c*s*l), w +5 + (c*4), w + 5  +(c*4) );
        line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
        popMatrix();
        break;


      case 5: // particleBloom
        particleSystem();
        break;


      case 6: // spinning fractal
        drawCircleBG(0,0,300);
        break;


      case 7:
        drawCircle(0,0,40);
        break;
      }
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
