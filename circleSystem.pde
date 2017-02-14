void circleSystem(){


  //particles.add(new Particle(new PVector(width/2, height/2)));
    circles.add(new Circle(new PVector(random(width/3, width), random(height/3,height))));
  for (int i = 0; i < circles.size(); i++) {
    xoff += 0;
    yoff += 0;
    Circle c = circles.get(i);
    c.run();
    if (c.isDead()) {
      circles.remove(i);
    }
    if (Pulse > 0.02) {
      //PVector wind = new PVector(random(-0.1,0.1),random(-0.1,0.1));
      PVector wind = new PVector(0,0.2);
      //  PVector wind = new PVector(random(-1,1),random(1,-1));
      wind.rotate(cntr);
      c.applyForce(wind);
      particleColour = 255;
      particleBG = 0;
    }
    else if (Pulse < 0.02) {
      particleColour = 150;
      particleBG = 0;
    }
  }

}
