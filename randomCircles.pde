void randomCircles() {

  if (delayTrigger == 1) {
  	pushMatrix();
    triangleShape();
    popMatrix();
    for (int i = 0; i < 100; i++) {
      stroke(LR, UD, 160,random(150));
      strokeWeight(10);
      point(random(0, width), random(0, height));
    }
  }
}