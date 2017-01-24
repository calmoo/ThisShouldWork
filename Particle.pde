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
    pushMatrix();
    update();
    display();
    popMatrix();
  }

   void applyForce(PVector force) {
    velocity.div(2);
    acceleration.add(velocity);
 }
  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);
    lifespan -= 0.0;
  }

  void display() {
    pushMatrix();
    strokeWeight(5);
    stroke(particleColour);
    point(location.x,location.y);
    popMatrix();


  }

  boolean isDead(){
    if (location.x > width || location.x < 0 || location.y > height || location.y < 0){
      return true;
    }else{
      return false;
    }
  }
}
