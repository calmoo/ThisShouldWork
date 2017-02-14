void circleSystem(){


  //particles.add(new Particle(new PVector(width/2, height/2)));

  for (int i = 0; i < 8; i++) {
    circles.add(new Circle(new PVector(random(width*0.25, width*0.75), random(height*0.25,height*0.75))));
    Circle c = circles.get(i);
    c.run();
    /*if (c.isDead()) {
     circles.remove(i);
    }*/

  if (keyPressed) {
      //PVector wind = new PVector(random(-0.1,0.1),random(-0.1,0.1));
      PVector wind = new PVector(random(-0.5,0.5),random(-0.5,0.5));
      //  PVector wind = new PVector(random(-1,1),random(1,-1));

      c.applyForce(wind);

  }

}
}
