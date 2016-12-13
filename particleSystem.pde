void particleSystem(){

//particles.add(new Particle(new PVector(random(width), random(height))));
particles.add(new Particle(new PVector(width/2, height/2)));
  //particles.add(new Particle(new PVector(cos(theta), sin(theta))));
  for (int i = 0; i < particles.size(); i++) {
    xoff += 0;
    yoff += 0;
    Particle p = particles.get(i);
    p.run();
    if (p.isDead()) {
      particles.remove(i);
      println("Dead");
    }
    if (mousePressed) {
      PVector wind = new PVector(random(-0.5,0.5),random(-0.5,0.5));
      p.applyForce(wind);
    }
  }
}
