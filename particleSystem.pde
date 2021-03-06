void particleSystem() {


  particles.add(new Particle(new PVector(width/2, height/2)));

  for (int i = 0; i < particles.size(); i++) {
    xoff += 0;
    yoff += 0;
    Particle p = particles.get(i);
    p.run();
    if (p.isDead()) {
      particles.remove(i);
    }
    if (Pulse > 0) {
      //PVector wind = new PVector(random(-0.1,0.1),random(-0.1,0.1));
      PVector wind = new PVector(0, 0.2);
      //  PVector wind = new PVector(random(-1,1),random(1,-1));
      wind.rotate(cntr);
      p.applyForce(wind);
      particleColour = 255;
      particleBG = 0;
    } else if (Pulse < 0.02) {
      particleColour = 150;
      particleBG = 0;
    }
  }
}