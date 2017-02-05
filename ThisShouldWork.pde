import oscP5.*;
import netP5.*;

ArrayList<Particle> particles;
OscP5 osc;
NetAddress remote;

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
int clapCounter = 0;
float panX = width/2;
float cameraCount = width/2;
color defBackground = color (0,15,13);

  PanTiltMover ptm = new PanTiltMover();

void setup() {
  //camera = new PeasyCam(this, width/2, height/2, 0, 5000);
//  camera.setMinimumDistance(50);
  //camera.setMaximumDistance(800);

  particles = new ArrayList<Particle>();



  size(1400,900, P3D);
  smooth(4);
  frameRate(60);
  osc = new OscP5(this,8000);
  osc.properties().setRemoteAddress("127.0.0.1" , 8000 );
  remote = new NetAddress( "127.0.0.1" , 8000 );
}

void draw(){
  //camera(width/2,height/2, mouseY, 0, 0, 0, 0, -1, 0);
  //camera(width/2, height/2.0, (height/2.0) / tan(PI*30.0 / 180.0), width/2.0, height/2.0, 0, 0, 1, 0);
  camera(panAmount, tiltAmount, (height/2.0) / tan(PI*30.0 / 180.0), width/2.0, height/2.0, 0, 0, 1, 0);
  //rectRot++;
  keyPressed();
  incrementLR();
  incrementUD();
  whitneyDraw1();
  triangleShape();
  ptm.run();
}

void mousePressed() {
  clapCounter++;
  println(clapCounter);

  if (clapCounter > 7){
    clapCounter = 0;
  }

}
