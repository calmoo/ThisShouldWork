
void drawCircleBG(float x,float y, float d){
//background(0);
//x  background(0);
  rectRot+= 4;
  float col = map(cntr,1.7,2.8,0,255);
  float fractal = map(mouseX,0,width,0.001,0.1);
  pushMatrix();
  translate(width/2, height/2);
  rotate((rectRot*fractal)*TWO_PI/360);
  //stroke(col, 120, col,60);
  stroke(149,UD,LR,60);
  strokeWeight(1);
  noFill();

  ellipse(x,y,d,d);
  //rect(x,y,d,d);
  //stroke(255,80);
//  strokeWeight(3);
  //rect(x ,y ,200,200);
  popMatrix();
  if (d>20){

    drawCircleBG(x+d /cntr, y, d/cntr);
    drawCircleBG(x-d /cntr,y,d/cntr);
    if (key == 'p'){

      drawCircleBG(x,y+d/2,d/2);
      drawCircleBG(x,y-d/2,d/2);
    }

}
}
