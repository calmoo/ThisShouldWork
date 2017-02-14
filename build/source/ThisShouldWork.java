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





ArrayList<Particle> particles;
ArrayList<Circle> circles;
ControlP5 cp5;
OscP5 osc;
NetAddress remote;
Slider abc;

float test;
float myKick;
float myDelay;
float myVert=0;

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
int a = 1;
int b = 100;
int c = 1;
int d = 50;
float s = 2 * 3.1416f / (3*60);
float xoff = 0;
float yoff = 0;
int kickCounter = 0;
float clapCounter = 0;
float panX = width/2;
float cameraCount = width/2;
int defBackground = color (0,15,13);
float sceneChangeFreq = 1;
int sceneIntervalCounter = 0;

PanTiltMover ptm = new PanTiltMover();

public void setup() {

  cp5 = new ControlP5(this);
  cp5.addSlider("sceneChangeFreq")
     .setPosition(100,600)
     .setWidth(400)
     .setRange(0.25f,1)
     .setValue(0.5f)
     .setNumberOfTickMarks(4)
     .setSliderMode(Slider.FLEXIBLE)
     ;

  particles = new ArrayList<Particle>();
  

  
  frameRate(60);
  osc = new OscP5(this,8000);
  osc.properties().setRemoteAddress("127.0.0.1" , 8000 );
  remote = new NetAddress( "127.0.0.1" , 8000 );
}

public void draw(){
  pushMatrix();
  //beginCamera();
  camera(panAmount, tiltAmount, (height/2.0f) / tan(PI*30.0f / 180.0f), width/2.0f, height/2.0f, 0, 0, 1, 0);
  rectRot++;
  keyPressed();
  incrementLR();
  incrementUD();
  whitneyDraw1();
  triangleShape();
  ptm.run();
  popMatrix();

}

public void mousePressed() {
  clapCounter += sceneChangeFreq;
  sceneIntervalCounter = PApplet.parseInt(clapCounter);
  println(clapCounter);

//  println(clapCounter);

  if (sceneIntervalCounter > 7){
    clapCounter = 0;
    sceneIntervalCounter = 0;
  }
  }
class Circle {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float lifespan;

  Circle(PVector l) {
    location = l.get();
    acceleration = new PVector(0,0);
     //float theta = map(noise(xoff,yoff),0,1,0,TWO_PI);

    velocity = new PVector(random(-0.5f,0.5f),random(-0.5f,0.5f));
    //velocity = new PVector(cos(theta),sin(theta));
    lifespan = 255.0f;
  }

  public void run(){
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
    strokeWeight(5);
    stroke(126,LR,UD);
    ellipse(location.x,location.y,100,100);
    popMatrix();


  }

  public boolean isDead(){
    if (location.x > width || location.x < 0 || location.y > height || location.y < 0){
      return true;
    }else{
      return false;
    }
  }
}
float panAmount = 0;
float tiltAmount = 0;
float alpha = 4;
float beta = 4;


class PanTiltMover{

  public void run(){
    if (clapCounter <= 3){
      cameraPan();
    }

   else if (clapCounter >=4){
      cameraTilt();
    }
  }




  public void cameraPan(){
    if (panAmount < 0){
      alpha = 4;
    }
    else if (panAmount > width){
      alpha = -4;
    }
    panAmount += alpha;
    //println(panAmount);
  }

  public void cameraTilt(){
    if (tiltAmount < 0){
      beta = 4;
    }
    else if (tiltAmount > height){
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
    acceleration = new PVector(0,0);
     //float theta = map(noise(xoff,yoff),0,1,0,TWO_PI);

    velocity = new PVector(random(-0.5f,0.5f),random(-0.5f,0.5f));
    //velocity = new PVector(cos(theta),sin(theta));
    lifespan = 255.0f;
  }

  public void run(){
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
    strokeWeight(5);
    stroke(126,LR,UD);
    point(location.x,location.y);
    popMatrix();


  }

  public boolean isDead(){
    if (location.x > width || location.x < 0 || location.y > height || location.y < 0){
      return true;
    }else{
      return false;
    }
  }
}
public void cameraCounter(){
  for (int i = 0; i < 1000; i+= 0.1f){
    cameraCount = i;
  }
//  cameraCount = width/2;
}
public void circleSystem(){


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
    if (Pulse > 0.02f) {
      //PVector wind = new PVector(random(-0.1,0.1),random(-0.1,0.1));
      PVector wind = new PVector(0,0.2f);
      //  PVector wind = new PVector(random(-1,1),random(1,-1));
      wind.rotate(cntr);
      c.applyForce(wind);
      particleColour = 255;
      particleBG = 0;
    }
    else if (Pulse < 0.02f) {
      particleColour = 150;
      particleBG = 0;
    }
  }

}
public void count(){

  if (cntr <=2 ){
  delta = 0.01f;
  }
   if (cntr >= 2.8f){
    delta = -0.01f;
  }
  cntr += delta ;
}
float sq = 1.5f;
boolean countUp = true;
int rectRot = 0;
float cntr = 2;
float delta = 0;


public void drawCircle(float x,float y, float d){


  float col = map(cntr,1.7f,2.8f,0,255);

  pushMatrix();
  translate(width/2, height/2);
  rotate((rectRot*1)*TWO_PI/360);

  strokeWeight(1);
  noFill();
  stroke(128,LR,UD,40);
  strokeWeight(3);
  rect(x ,y ,200,200);
  popMatrix();

  if (d>20){

    drawCircle(x+d /cntr, y, d/cntr);
    drawCircle(x-d /cntr,y,d/cntr);
    if (key == 'p'){

      drawCircle(x,y+d/2,d/2);
      drawCircle(x,y-d/2,d/2);
    }

}
}

public void drawCircleBG(float x,float y, float d){
  
  rectRot+= 4;
  float col = map(cntr,1.7f,2.8f,0,255);
  float fractal = map(mouseX,0,width,0.001f,0.1f);

  pushMatrix();

  translate(width/2, height/2);
  rotate((rectRot*fractal)*TWO_PI/360);
  stroke(149,UD,LR,60);
  strokeWeight(1);
  noFill();
  ellipse(x,y,d,d);

  popMatrix();

  if (d>20){

    drawCircleBG(x+d /cntr, y, d/cntr);
    drawCircleBG(x-d /cntr,y,d/cntr);

    if (key == 'p'){
      drawCircleBG(x,y+d/2,d/2);
      drawCircleBG(x,y-d/2,d/2);
    }

}
}

float gamma = 1;

public void incrementLR(){
  if (LR <= 1){
    gamma = 1;
  }
  if (LR >= 150){
    gamma = -1;
  }
  LR += gamma;
}
public void incrementUD(){
  while (UD < 360){
    UD = UD + 1;
  //  UD = UD + myVert;
    //UD = UD + (myKick + 20);
    if (UD  > 80){
      UD = 1;
    }
   // println(UD);
   return;
 }
}
//Reads all incoming OSC data from Ableton and parses into global variables.

public void oscEvent(OscMessage inp) {
  if (inp.checkAddrPattern("/myKick")==true){ //Kick Data
  float Kick = inp.get(0).floatValue();
  Pulse = Kick;
  if (Pulse > 0){
  kickCounter++;
  if (kickCounter > 7){
    kickCounter = 0;
  }
  //println(kickCounter);
}
  return;
}

else if (inp.checkAddrPattern("/Delay")==true){ // HiHat Data
  float Delay = inp.get(0).floatValue();
  myVert =  map(Delay,0, 0.152f,1,40);
  myDelay = map(Delay,0, 0.152f,0,255);
  return;
}

else if (inp.checkAddrPattern("/Clap")==true){ // Clap Data
  float oscClap = inp.get(0).floatValue();
  float Clap = oscClap;
  if (Clap > 0){
    clapCounter += sceneChangeFreq;
    sceneIntervalCounter = PApplet.parseInt(clapCounter);
  //  println(clapCounter);

  //  println(clapCounter);

    if (sceneIntervalCounter > 7){
      clapCounter = 0;
      sceneIntervalCounter = 7;
    }
  }
  return;

}

}
public void particleSystem(){


  particles.add(new Particle(new PVector(width/2, height/2)));
    //particles.add(new Particle(new PVector(random(width/3, width), random(height/3,height))));
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
      PVector wind = new PVector(0,0.2f);
      //  PVector wind = new PVector(random(-1,1),random(1,-1));
      wind.rotate(cntr);
      p.applyForce(wind);
      particleColour = 255;
      particleBG = 0;
    }
    else if (Pulse < 0.02f) {
      particleColour = 150;
      particleBG = 0;
    }
  }

}

/*void counter(){


  if (cntr <= 0){
    delta = 0.1;
  }
  if (cntr >= TWO_PI){
    delta = -0.1;
  }
  cntr += delta ;
}*/
public void spherePulse(){
  if (myKick > 0.01f){ //&& //millis() - time >= wait){
    for (int i = 0; i < 60; i++){
    Pulse = i;
    }
      //time = millis();
    }
    else if (myKick < 0.01f){
      for (int i = 60; i > 0; i--){
      Pulse = i;
      }
    }
    return;

  }
  public void triangleShape(){
    translate(width/2, height/2, 0);
    stroke(127,UD,LR);
    //rotate(map(kickCounter,0,7,0,TWO_PI));
    //lerp(x, mouseX, 0.05);
    beginShape();
    int vertX = 200;
    vertex(-vertX, -vertX, -vertX);
    vertex( vertX, -vertX, -vertX);
    vertex(   0,    0,  vertX);

    vertex( vertX, -vertX, -vertX);
    vertex( vertX,  vertX, -vertX);
    vertex(   0,    0,  vertX);

    vertex( vertX, vertX, -vertX);
    vertex(-vertX, vertX, -vertX);
    vertex(   0,   0,  vertX);

    vertex(-vertX,  vertX, -vertX);
    vertex(-vertX, -vertX, -vertX);
    vertex(   0,    0,  vertX);
    endShape();
  }
public float w1x1(float t){
  return sin(t/10)*100 + sin(t/6)*30;

}

public float w1y1(float t) {

  return cos(t/10)*100;

}
public float w1x2(float t){
   return sin(t/10)*200 + sin(t)*2;

}

public float w1y2(float t) {

  return cos(t/20)*200 + cos(t/12)*20;

}
public float w2x1(float t){

  return sin(t/10) * 100 + sin(t/20)*100;

}

public float w2y1(float t) {


  return cos(t/10) * 100;

}
public float w2x2(float t){

   return sin(t/10)*200 + sin(t)*4;


}

public float w2y2(float t) {


return cos(t/20) * 200 + cos(t/30)*20;
}


public float w3x1(float t){

  //return cos(1 * t) - pow((cos(80 * t)), 3);
  //return cos(1 * t)- pow((cos(80 * t)), 3) * 20;
  return cos(a * t) * 10 - pow((cos(b * t)), 3) *100;
}

public float w3y1(float t) {


  //return sin(1*t) - pow((sin(80 * t)), 3);
  //return sin(1*t)  - pow((sin(80 * t)), 3) * 100;
  return sin(c*t) * 10  - pow((sin(d * t)), 3) * 100;

}
public float w3x2(float t){

   //return  cos(1 * t)*200 - pow((cos(80 * t)), 3);
   return  cos(a * t) * 20 - pow((cos(b * t)), 3) * 400 ;


}

public float w3y2(float t) {


//return sin(1*t)*200 - pow((sin(80 * t)), 3);
return sin(c*t) * 20  - pow((sin(d * t)) , 3) * 400 ;
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

    for (float c = 1; c < 20; c = c + 1){ //draws lines
      strokeWeight(2);

      switch(sceneIntervalCounter){

      case 0: // Whitney1

        stroke(LR,UD,160);
        pushMatrix();
        translate(width/2, height/2);
        line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
        popMatrix();
        break;

      case 1: //Whitney 2
        pushMatrix();
        translate(width/2, height/2);
        stroke(168,UD,LR);
        line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;
        popMatrix();
        break;

      case 2: //Whitney 2 points
        pushMatrix();
        translate(width/2, height/2);
        strokeWeight(5);
        stroke(168,UD,LR);
        point(w2x1(t+c*2), w2y1(t+c*2));
        point((w2x1(t+c*2)) -10, (w2y1(t+c*2))-10);
        popMatrix();
        break;



      case 3: //Whitney 3
        pushMatrix();
        translate(width/2, height/2);
        strokeWeight(2);
        stroke(120,UD,LR);
        line(w3x1((-t*tc)+(c *spc)), w3y1((-t*tc)+(c *spc)), w3x2((-t*tc)+(c *spc)),  w3y2((-t*tc)+(c *spc))) ;
        //point(w3x1((t+c)*50), w3y1((t+c)* 50)) ;
        popMatrix();
        break;


      case 4: // Whitney harmonix
        pushMatrix();
        translate(width/2, height/2);
        noFill();
        strokeWeight(2);
        stroke(149,-LR,LR);
        ellipse((200+l)*cos(c*s*l),(200+l)*sin(c*s*l), w +5 + (c*4), w + 5  +(c*4) );
        popMatrix();
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
  public void settings() {  size(1400,900, P3D);  smooth(4); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ThisShouldWork" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
