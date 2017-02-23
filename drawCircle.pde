float sq = 1.5;
boolean countUp = true;
int rectRot = 0;
float cntr = 2;
float delta = 0;


void drawCircle(float x, float y, float d) {



  pushMatrix();

  translate(width/2, height/2);
  rotate((rectRot*1)*TWO_PI/360);
  strokeWeight(1);
  noFill();
  stroke(128, LR, UD, 40);
  strokeWeight(3);
  rect(x, y, 200, 200);

  popMatrix();

  if (d>20) {

    drawCircle(x+d /cntr, y, d/cntr);
    drawCircle(x-d /cntr, y, d/cntr);

    if (key == 'p') {

      drawCircle(x, y+d/2, d/2);
      drawCircle(x, y-d/2, d/2);
    }
  }
}