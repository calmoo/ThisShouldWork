class Circle {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float lifespan;

  Circle(PVector l) {
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
    checkEdges();
    popMatrix();
  }

  void applyForce(PVector force) {
    //velocity.add(force);
    acceleration = force;
    acceleration.mult(0);
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
    fill(120,0,0);
    stroke(255,0,0);
    ellipse(location.x,location.y,100,100);
    popMatrix();


  }

  void checkEdges() {
    if (location.x  > width) {
      location.x = width ;
      velocity.x *= -1;
      } else if (location.x  < 0) {
        velocity.x *= -1;
        location.x = 0;
      }

      if (location.y  > height) {
        // Even though we said we shouldn't touch location and velocity directly, there are some exceptions.
        // Here we are doing so as a quick and easy way to reverse the direction of our object when it reaches the edge.
        velocity.y *= -1;
        location.y = height;
      }
      else if (location.y  < 0){
        velocity.y *= -1;
        location.y = 0;
      }
    }

  }
