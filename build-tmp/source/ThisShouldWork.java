import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import oscP5.*; 
import netP5.*; 
import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ThisShouldWork extends PApplet {

ControlFrame cf;
boolean paused = false;

public void settings() {
  size(1400, 800, P3D);
}
public void setup() {


  particles = new ArrayList<Particle>();



  
  frameRate(60);
  osc = new OscP5(this, 8000);
  osc.properties().setRemoteAddress("127.0.0.1", 8000 );
  remote = new NetAddress( "127.0.0.1", 8000 );
  cf = new ControlFrame(this, 600, 200, "Controls");
}

public void draw() {


  pushMatrix();

  camera(panAmount, tiltAmount, (height/2.0f) / tan(PI*30.0f / 180.0f), width/2.0f, height/2.0f, 0, 0, 1, 0);
  rectRot++;
  keyPressed();
  incrementLR();
  incrementUD();
  whitneyDraw1();
  ptm.run();
  popMatrix();
  pushMatrix();
  randomCircles();
  popMatrix();
  if (paused == true){
    println("paused");
  }
  else if (paused == false){
    println("unpaused");
  }
}

public void keyPressed() {
  if ((key == 'x' || key == 'X') && (paused == false)){
    paused = true;
  }
   if ((key == 'x' || key == 'X') && (paused == true)) {
    paused = false;
  }
}


public void mousePressed() {
  clapCounter += sceneChangeFreq;
  sceneIntervalCounter = PApplet.parseInt(clapCounter);

  if (sceneIntervalCounter > 7) {
    clapCounter = 0;
    sceneIntervalCounter = 0;
  }
}
// allows GUI to be controlled from a seperate window to the visuals.
// taken from https://github.com/sojamo/controlp5/issues/17

class ControlFrame extends PApplet {

  int w, h;
  PApplet parent;
  ControlP5 cp5;
  float sceneChangeFreq;

  public ControlFrame(PApplet _parent, int _w, int _h, String _name) {
    super();   
    parent = _parent;
    w=_w;
    h=_h;
    PApplet.runSketch(new String[]{this.getClass().getName()}, this);
  }
  public void settings() {

    size(w, h, P2D);
  }

  public void setup() {
    background(0);
    this.surface.setSize(w, h);
    cp5 = new ControlP5(this);
    cp5.addSlider("sceneChangeFreq")
      .setPosition(100, 50)
      .setWidth(400)
      .setRange(0, 1)
      .setValue(0.125f)
      .setNumberOfTickMarks(5)
      .setSliderMode(Slider.FLEXIBLE)
      .plugTo(parent, "sceneChangeFreq");
    ;
  }
}
float panAmount = 0;
float tiltAmount = 0;
float alpha = 4;
float beta = 4;


class PanTiltMover {

  public void run() {
    if (sceneIntervalCounter <= 3) {
      cameraPan();
    } else if (sceneIntervalCounter >=4) {
      cameraTilt();
      if (sceneIntervalCounter == 5) {
        panAmount = width/2;
        tiltAmount = height/2;
      }
    }
  }


  public void cameraPan() {
    if (panAmount < 0) {
      alpha = 4;
    } else if (panAmount > width) {
      alpha = -4;
    }
    panAmount += alpha;
  }

  public void cameraTilt() {
    if (tiltAmount < 0) {
      beta = 4;
    } else if (tiltAmount > height) {
      beta = -4;
    }
    tiltAmount += beta;
  }
}
class Particle {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float lifespan;

  Particle(PVector l) {
    location = l.get();
    acceleration = new PVector(0, 0);


    velocity = new PVector(random(-0.5f, 0.5f), random(-0.5f, 0.5f));

    lifespan = 255.0f;
  }

  public void run() {
    pushMatrix();
    update();
    display();
    popMatrix();
  }

  public void applyForce(PVector force) {
    velocity.div(2);
    acceleration.add(velocity);
  }
  public void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);
    lifespan -= 0.0f;
  }

  public void display() {

    pushMatrix();
    strokeWeight(7);
    //stroke(0);
    stroke(126, LR, UD);
    point(location.x, location.y);
    popMatrix();
  }

  public boolean isDead() {
    if (location.x > width || location.x < 0 || location.y > height || location.y < 0) {
      return true;
    } else {
      return false;
    }
  }
}




ArrayList<Particle> particles;

ControlP5 cp5;
OscP5 osc;
NetAddress remote;
Slider abc;
RadioButton r;

int delayTrigger = 0;

float test;
float myKick;
float myDelay;
float myVert=0;
int Delay = 0;
float freqCutoff = 0.37f;
float colourNudge = 0;
int particleColour = 0;
int particleBG = 0;
float UD = 1;
float LR = 1;
float Pulse = 0;
float t = 0;
float l = 1;
float Colours;
float Clap;
static final int NUM_LINES = 20;
static final int NUM_LINES2 = 20;
float s = 2 * 3.1416f / (3*60);
float xoff = 0;
float yoff = 0;
int kickCounter = 0;
float clapCounter = 0;
float panX = width/2;
float cameraCount = width/2;
int defBackground = color (0, 15, 13);
float sceneChangeFreq = 1;
int sceneIntervalCounter = 0;

PanTiltMover ptm = new PanTiltMover();
public void count() {

  if (cntr <=2 ) {
    delta = 0.01f;
  }
  if (cntr >= 2.8f) {
    delta = -0.01f;
  }
  cntr += delta ;
}
float sq = 1.5f;
boolean countUp = true;
int rectRot = 0;
float cntr = 2;
float delta = 0;


public void drawCircle(float x, float y, float d) {



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

public void drawCircleBG(float x, float y, float d) {

  rectRot+= 4;
  float fractal = map(mouseX, 0, width, 0.001f, 0.1f);

  pushMatrix();

  translate(width/2, height/2);
  rotate((rectRot*fractal)*TWO_PI/360);
  stroke(149, UD, LR, 60);
  strokeWeight(1);
  noFill();
  ellipse(x, y, d, d);

  popMatrix();

  if (d>20) {

    drawCircleBG(x+d /cntr, y, d/cntr);
    drawCircleBG(x-d /cntr, y, d/cntr);

    if (key == 'p') {
      drawCircleBG(x, y+d/2, d/2);
      drawCircleBG(x, y-d/2, d/2);
    }
  }
}

float gamma = 1;

public void incrementLR() {
  if (LR <= 1 || Clap > 0) {
    gamma = 1;
  }
  if (LR >= 150 || Clap > 0) {
    gamma = -1;
  }
  LR += gamma;
}

float charlie = 1;
public void incrementUD() {

  if (UD <= 1) {
    UD = 1;
    charlie = 1;
  }
  if (UD >= 170) {
    UD = 170;
    charlie = -1;
  }
  //float conColour = constrain(colourNudge,0,170 - colourNudge);
  if (charlie == 1) {
    UD += charlie  + colourNudge;
  }
  if (charlie == -1) {
    UD += charlie  - colourNudge;
  }
}
//Reads all incoming OSC data from Ableton and parses into global variables.

public void oscEvent(OscMessage inp) {
  if (inp.checkAddrPattern("/myKick")==true) { //Kick Data
    int Pulse = inp.get(0).intValue();
    if (Pulse > 0) {
      kickCounter++;
      if (kickCounter > 7) {
        kickCounter = 0;
      }
    }
    return;
  } else if (inp.checkAddrPattern("/Delay")==true) { // HiHat Data\
    int Delay = inp.get(0).intValue();
    delayTrigger = Delay;
    return;
  } else if (inp.checkAddrPattern("/Clap")==true) { // Clap Data
    int Clap = inp.get(0).intValue();
    if (Clap > 0) {

      colourNudge = 10;
      clapCounter += sceneChangeFreq;
      sceneIntervalCounter = PApplet.parseInt(clapCounter);

      if (sceneIntervalCounter > 7) {
        clapCounter = 0;
        sceneIntervalCounter = 0;
      }
    } else {
      colourNudge = 0;
    }
    return;
  } else if (inp.checkAddrPattern("/Cutoff")==true) {
    float Cutoff = inp.get(0).floatValue();
    freqCutoff = Cutoff;
  }
}
public void particleSystem() {


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
      PVector wind = new PVector(0, 0.2f);
      //  PVector wind = new PVector(random(-1,1),random(1,-1));
      wind.rotate(cntr);
      p.applyForce(wind);
      particleColour = 255;
      particleBG = 0;
    } else if (Pulse < 0.02f) {
      particleColour = 150;
      particleBG = 0;
    }
  }
}
public void randomCircles() {

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
public void triangleShape() {

  translate(width/2, height/2, 0);
  stroke(127, UD, LR);
  beginShape();
  int vertX = 200;
  vertex(-vertX, -vertX, -vertX);
  vertex( vertX, -vertX, -vertX);
  vertex(   0, 0, vertX);

  vertex( vertX, -vertX, -vertX);
  vertex( vertX, vertX, -vertX);
  vertex(   0, 0, vertX);

  vertex( vertX, vertX, -vertX);
  vertex(-vertX, vertX, -vertX);
  vertex(   0, 0, vertX);

  vertex(-vertX, vertX, -vertX);
  vertex(-vertX, -vertX, -vertX);
  vertex(   0, 0, vertX);
  endShape();
}
public float w1x1(float t) {
  return sin(t/10)*100 + sin(t/6)*30;
}

public float w1y1(float t) {

  return cos(t/10)*100;
}
public float w1x2(float t) {
  float size = map(freqCutoff, 0.36f, 1, 200, 400);
  return sin(t/10)*size + sin(t)*2;
}

public float w1y2(float t) {
  float size = map(freqCutoff, 0.36f, 1, 200, 400);
  return cos(t/20)*size + cos(t/12)*20;
}
public float w2x1(float t) {

  return sin(t/10) * 100 + sin(t/20)*100;
}

public float w2y1(float t) {


  return cos(t/10) * 100;
}
public float w2x2(float t) {
  
  float size = map(freqCutoff, 0.36f, 1, 200, 400);
  return sin(t/10)*size + sin(t)*4;
}

public float w2y2(float t) {

  float size = map(freqCutoff, 0.36f, 1, 200, 400);
  return cos(t/20) * size + cos(t/30)*20;
}
int a = 1;
int b = 100;
int c = 1;
int d = 50;

public float w3x1(float t) {

  return cos(a * t) * 10 - pow((cos(b * t)), 3) *100;
}

public float w3y1(float t) {

  return sin(c*t) * 10  - pow((sin(d * t)), 3) * 100;
}
public float w3x2(float t) {

  float size = map(panAmount, 0, width, 200, 400);

  return  cos(a * t) * 20 - pow((cos(b * t)), 3) * size ;
}

public float w3y2(float t) {

  float size = map(panAmount, 0, width, 200, 400);

  return sin(c*t) * 20  - pow((sin(d * t)), 3) * size ;
}
public void whitneyDraw1(){ //draws a variety of whitney functions

  float spc = 0.001f;
  float tc = 0.0005f;
  float r =200; //radius of rotation
  float a;
  int w = 80;

    if ((sceneIntervalCounter != 5) && (sceneIntervalCounter != 7)){
        background(defBackground);
        background (map(kickCounter,0,7,0,80),40,UD);
      }

     //draws lines
      strokeWeight(2);

      switch(sceneIntervalCounter){

      case 0: // Whitney1
      for (float c = 1; c < 50; c = c + 1){
        stroke(LR,UD,160);
        pushMatrix();
      //  blendMode(ADD);
        translate(width/2, height/2);
        line(w1x1(-t + c*2), w1y1(-t +c*2) , w1x2(-t + c*2),  w1y2(-t + c*2)) ;
        popMatrix();
      }
        break;

      case 1: //Whitney 2
      for (float c = 1; c < 50; c = c + 1){
        pushMatrix();
      //  blendMode(SUBTRACT);
      //  circleSystem();
        translate(width/2, height/2);
        stroke(168,UD,LR);
        line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;
        popMatrix();
      }
        break;
      

      case 2: //Whitney 2 points
      for (float c = 1; c < 50; c = c + 1){
        pushMatrix();
        //blendMode(DIFFERENCE);
        translate(width/2, height/2);
        strokeWeight(5);
        stroke(168,UD,LR);
        point(w2x1(t+c*2), w2y1(t+c*2));
        point((w2x1(t+c*2)) -10, (w2y1(t+c*2))-10);
        popMatrix();
      }
        break;



      case 3: //Whitney 3
      for (float c = 1; c < 50; c = c + 1){
        pushMatrix();
        translate(width/2, height/2);
        strokeWeight(2);
        stroke(120,UD,LR);
        line(w3x1((-t*tc)+(c *spc)), w3y1((-t*tc)+(c *spc)), w3x2((-t*tc)+(c *spc)),  w3y2((-t*tc)+(c *spc))) ;
        //point(w3x1((t+c)*50), w3y1((t+c)* 50)) ;
        popMatrix();
      }
        break;


      case 4: // Whitney harmonix
      for (float c = 1; c < 50; c = c + 1){
        pushMatrix();
      //  blendMode(MULTIPLY);
        translate(width/2, height/2);
        noFill();
        strokeWeight(2);
        stroke(149,-LR,LR);
        ellipse((200+l)*cos(c*s*l),(200+l)*sin(c*s*l), w +5 + (c*4), w + 5  +(c*4) );
        line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
        popMatrix();
      }
        break;


      case 5: // particleBloom
        particleSystem();
        break;


      case 6: // spinning fractal

        drawCircleBG(0,0,300);
        break;


      case 7:
        drawCircle(0,0,40);
        break;
      
    }

  if(Pulse > 0.02f){
    l = l + s;
    t = t  + 2;
  }
  else{
    l = l + s;
    t = t + 0.5f;
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ThisShouldWork" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
