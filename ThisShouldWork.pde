import oscP5.*;
import netP5.*;
import processing.video.*;

ArrayList<Particle> particles;
Movie myMovie;
OscP5 osc;
NetAddress remote;

float test;
float myKick;
float myDelay;
float myVert=0;

float UD = 1;
float LR = 1;
float Pulse = 2;
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


void setup() {

  //myMovie = new Movie(this, "35mm_G3_DIRTY_v1.mp4");
  //myMovie.loop();

  //time = millis();//store the current time
   particles = new ArrayList<Particle>();
  size(1400,900, P3D);
  smooth(8);
  frameRate(60);
  osc = new OscP5(this,8000);
  osc.properties().setRemoteAddress("127.0.0.1" , 8000 );
  remote = new NetAddress( "127.0.0.1" , 8000 );
}

void draw(){

  keyPressed();
  incrementLR();
  incrementUD();
  spherePulse();

  background(#000F0D);

  if(key != 'y'){
    translate(width/2, height/2);
 whitneyDraw1();
 }
 else if (key == 'y'){
   //translate(width*2,height*2);
   particleSystem();
 }
//particleSystem();
  //whitneyDraw2();

  //tint(255, 50);
  //image(myMovie, -width/2,-height/2 ,width,height);



}

void movieEvent(Movie m) {
  m.read();
}
