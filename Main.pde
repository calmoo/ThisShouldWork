import oscP5.*;
import netP5.*;
import processing.video.*;
Movie myMovie;
OscP5 osc;
NetAddress remote;

float test;
float myKick;
float myDelay=0;
int   myBG= 255;
float myVert=0;
int   myTriColour = 0;
float UD = 1;
float LR = 1;
float Pulse = 2;
float Pulse2 = 1;
int time;
int wait = 40;
float t;
float Colours;
static final int NUM_LINES = 20;
static final int NUM_LINES2 = 20;


void setup() {


  //myMovie = new Movie(this, "35mm_G3_DIRTY_v1.mp4");
  //myMovie.loop();

  time = millis();//store the current time
  size(1300,800, P2D);
  smooth(8);
  frameRate(60);
  osc = new OscP5(this,8000);
  osc.properties().setRemoteAddress("127.0.0.1" , 8000 );
  remote = new NetAddress( "127.0.0.1" , 8000 );
}

void draw(){


  println(Colours);
  //colourChange();
  incrementLR();
  incrementUD();
  spherePulse();

  //background(#000F0D);
  whitneyDraw();

  lights();
  //fill(255);
  noStroke();
  //translate(width/2, height/2, 0);
  //sphere(100);

  stroke(myTriColour);
  strokeWeight(5);
  //tint(255, 50);
  //image(myMovie, -width/2,-height/2 ,width,height);

  //rotateX(radians(UD));
  //rotateZ(radians(LR));
  ////fill(10,200,10);
  //noStroke();

  stroke(myTriColour);
  strokeWeight(5);
  noFill();

  triangleShape();


}

void movieEvent(Movie m) {
  m.read();
}
