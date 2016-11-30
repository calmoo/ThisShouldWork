import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import oscP5.*; 
import netP5.*; 
import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ThisShouldWork extends PApplet {





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
float s = 2 * 3.1416f / (3*60);


public void setup() {

  //myMovie = new Movie(this, "35mm_G3_DIRTY_v1.mp4");
  //myMovie.loop();

  //time = millis();//store the current time
  
  
  frameRate(60);
  osc = new OscP5(this,8000);
  osc.properties().setRemoteAddress("127.0.0.1" , 8000 );
  remote = new NetAddress( "127.0.0.1" , 8000 );
}

public void draw(){

  keyPressed();
  incrementLR();
  incrementUD();
  spherePulse();

  background(0xff000F0D);
  translate(width/2, height/2);
  whitneyDraw1();
  //whitneyDraw2();

  //tint(255, 50);
  //image(myMovie, -width/2,-height/2 ,width,height);



}

public void movieEvent(Movie m) {
  m.read();
}
public void incrementLR(){

  while (LR < 150){
    LR = LR + 0.1f;
  //   LR = LR + int(myVert);

    if (LR >150){
      LR = 1;
    }
    //println(LR);
    return;

  }
}
public void incrementUD(){
  while (UD < 360){
    UD = UD + 1;
  //  UD = UD + myVert;
    //UD = UD + (myKick + 20);
    if (UD  > 124){
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
  myKick = Kick;
  //println(Kick);
  return;
}

else if (inp.checkAddrPattern("/Delay")==true){ // HiHat Data
  float Delay = inp.get(0).floatValue();
  myVert =  map(Delay,0, 0.152f,1,40);
  myDelay = map(Delay,0, 0.152f,0,255);
  return;
}

else if (inp.checkAddrPattern("/Clap")==true){ // Clap Data
  float Clap = inp.get(0).floatValue();
  return;

  }

}
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

   //speed of rotation
  int w = 80;
  //stroke(LR,UD,160);
  background(0xff000F0D);
  //translate(width/2, height/2);

  for (float c = 1; c < 20; c = c + 1){ //draws lines

    strokeWeight(2);
    if (key == 'a'){ // Whitney1
    stroke(LR,UD,160);
		line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
  }
    else if (key == 'b'){ //Whitney 2
    stroke(168,UD,LR);
    line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;
  }

  else if (key == 'p'){ //Whitney 2 points
    strokeWeight(5);
    stroke(168,UD,LR);
    point(w2x1(t+c*2), w2y1(t+c*2));
    point((w2x1(t+c*2)) -10, (w2y1(t+c*2))-10);

  }

  else if (key == 'y'){ //Whitney 3
    strokeWeight(2);
    stroke(120,UD,LR);
    line(w3x1((-t*tc)+(c *spc)), w3y1((-t*tc)+(c *spc)), w3x2((-t*tc)+(c *spc)),  w3y2((-t*tc)+(c *spc))) ;
    //point(w3x1((t+c)*50), w3y1((t+c)* 50)) ;
  }

  else if (key == 'u'){
    noFill();
    strokeWeight(2);
    stroke(149,UD,LR);
    //troke(184,124,82);
    ellipse(200*cos(c*s*l),200*sin(c*s*l), w +5 + (c*4), w + 5  +(c*4) );

  }

  else  {
    stroke(168,UD,LR);
    line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2));
    stroke(LR,UD,160);
		line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;


  }

}
//+ Pulse*0.01;
l = l + s;
t = t + 1;


}
private void whitneyDraw2(){

  stroke(168,UD,LR);
  //background(#000F0D);


  for (int c = 0; c < 10; c++){ //draws lines

    strokeWeight(2);
		line(w2x1(-t+c*2), w2y1(-t+c*2) , w2x2(-t+c*2),  w2y2(-t+c*2)) ;

}

t++; // 1 + Pulse*0.1;



}
  public void settings() {  size(1300,800, P3D);  smooth(8); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ThisShouldWork" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
