import oscP5.*;
import netP5.*;
import controlP5.*;

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
float s = 2 * 3.1416 / (3*60);
float xoff = 0;
float yoff = 0;
int kickCounter = 0;
float clapCounter = 0;
float panX = width/2;
float cameraCount = width/2;
color defBackground = color (0,15,13);
float sceneChangeFreq = 1;
int sceneIntervalCounter = 0;

PanTiltMover ptm = new PanTiltMover();

void setup() {

  cp5 = new ControlP5(this);
  cp5.addSlider("sceneChangeFreq")
     .setPosition(100,600)
     .setWidth(400)
     .setRange(0.25,1)
     .setValue(0.5)
     .setNumberOfTickMarks(4)
     .setSliderMode(Slider.FLEXIBLE)
     ;

  particles = new ArrayList<Particle>();
  size(1400,900, P3D);

  smooth(4);
  frameRate(60);
  osc = new OscP5(this,8000);
  osc.properties().setRemoteAddress("127.0.0.1" , 8000 );
  remote = new NetAddress( "127.0.0.1" , 8000 );
}

void draw(){
  pushMatrix();
  camera(panAmount, tiltAmount, (height/2.0) / tan(PI*30.0 / 180.0), width/2.0, height/2.0, 0, 0, 1, 0);
  rectRot++;
  keyPressed();
  incrementLR();
  incrementUD();
  whitneyDraw1();
  triangleShape();
  ptm.run();
  popMatrix();

}

void mousePressed() {
  clapCounter += sceneChangeFreq;
  sceneIntervalCounter = int(clapCounter);
  println(clapCounter);

  if (sceneIntervalCounter > 7){
    clapCounter = 0;
    sceneIntervalCounter = 0;
    }
  }
