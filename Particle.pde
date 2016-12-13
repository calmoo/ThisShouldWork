class Particle {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float lifespan;

  Particle(PVector l) {
    location = l.get();
    acceleration = new PVector(0,0);
     //float theta = map(noise(xoff,yoff),0,1,0,TWO_PI);

    velocity = new PVector(random(-0.5,0.5),random(-0.5,0.5));
    //velocity = new PVector(cos(theta),sin(theta));
    lifespan = 255.0;
  }

  void run(){
    update();
    display();
  }

   void applyForce(PVector force) {
  // Newton’s second law, but with force accumulation.
  // We now add each force to acceleration, one at a time.
    acceleration.add(force);
 }
  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);
    lifespan -= 0.0;
  }

  void display() {
    strokeWeight(5);
    stroke(0);
    //fill(255);

    point(location.x,location.y);

  }

  boolean isDead(){
    if (location.x > width || location.x < 0 || location.y > height || location.y < 0){
      return true;
    }else{
      return false;
    }
  }
}
