import oscP5.*;
import netP5.*;
import controlP5.*;

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
float freqCutoff = 0.37;
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
float s = 2 * 3.1416 / (3*60);
float xoff = 0;
float yoff = 0;
int kickCounter = 0;
float clapCounter = 0;
float panX = width/2;
float cameraCount = width/2;
color defBackground = color (0, 15, 13);
float sceneChangeFreq = 1;
int sceneIntervalCounter = 0;

PanTiltMover ptm = new PanTiltMover();