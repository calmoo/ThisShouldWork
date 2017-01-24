float sq = 1.5;
boolean countUp = true;
int rectRot = 0;
float cntr = 2;
float delta = 0;


void drawCircle(float x,float y, float d){
//background(0);
//x  background(0);
  rectRot+= 4;
  float col = map(cntr,1.7,2.8,0,255);
  pushMatrix();
  translate(width/2, height/2);
  rotate((rectRot*0.2)*TWO_PI/360);
  stroke(col, 120, col,20);
  strokeWeight(1);
  noFill();

  //ellipse(x,y,d,d);
  //rect(x,y,d,d);
  stroke(255,50);
  strokeWeight(3);
  rect(x ,y ,200,200);
  popMatrix();
  if (d>20){

    drawCircle(x+d /cntr, y, d/cntr);
    drawCircle(x-d /cntr,y,d/cntr);
    if (key == 'p'){

      drawCircle(x,y+d/2,d/2);
      drawCircle(x,y-d/2,d/2);
    }

}
}
