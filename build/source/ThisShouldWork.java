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
// commit test
//another
public void aasd(){}
public void asd(){}
public void setup() {


  //myMovie = new Movie(this, "35mm_G3_DIRTY_v1.mp4");
  //myMovie.loop();

  time = millis();//store the current time
  
  
  frameRate(60);
  osc = new OscP5(this,8000);
  osc.properties().setRemoteAddress("127.0.0.1" , 8000 );
  remote = new NetAddress( "127.0.0.1" , 8000 );
}

public void draw(){

  incrementLR();
  incrementUD();
  //spherePulse();

  background(0xff000F0D);
    translate(width/2, height/2);
  whitneyDraw1();
  //whitneyDraw2();

  //lights();
  //noStroke()
  //stroke(myTriColour);
  //strokeWeight(5);
  //tint(255, 50);
  //image(myMovie, -width/2,-height/2 ,width,height);

  //rotateX(radians(UD));
  //rotateZ(radians(LR));
  ////fill(10,200,10);
  //noStroke();

  //stroke(myTriColour);
  //strokeWeight(5);
  //noFill();

  //triangleShape();


}

public void movieEvent(Movie m) {
  m.read();
}
/*void colourChange(){

	/*for (float i = 0; i < 119; i = i + 1){
		Colours = i;
		return;
		}
		

		for (float i = 119; i >0; i--){
			Colours =  i;
			return;

			

		}
	}

	while (true) {

    for(int i = 0; i < 100; i++) {

      Colours = i;
      return;

    }

    for(int i = 100; i > 0; i--) {

        Colours = i;
        return;

    }

}*/








public void incrementLR(){

  while (LR < 110){
    LR = LR + 0.1f;
    LR = LR + PApplet.parseInt(myVert);
    
    if (LR >110){
      LR = 1;
    }
    //println(LR);
    return;

  }
}
public void incrementUD(){
  while (UD < 360){
    UD = UD + 1;
    UD = UD + myVert;
    //UD = UD + (myKick + 20);
    if (UD  > 124){
      UD = 1;
    }
   // println(UD);
   return;
 }
}
public void oscEvent(OscMessage inp) {
  if(inp.checkAddrPattern("/myKick")==true){ //Kick Data
  float Kick = inp.get(0).floatValue();
  myKick = Kick;
  //println(Kick);
  return;
}

else if(inp.checkAddrPattern("/Delay")==true){ // HiHat Data
  float Delay = inp.get(0).floatValue();
  myVert =  map(Delay,0, 0.152f,1,40);
  myDelay = map(Delay,0, 0.152f,0,255);
  return;
}

else if(inp.checkAddrPattern("/Clap")==true ){ // Clap Data
  float Clap = inp.get(0).floatValue(); 
  if (Clap>0.1f){
    myBG = 2;
    myTriColour = 255;
  }
  else if (Clap < 0.1f){
    myBG = 0;
    myTriColour = 255;
    return;
  }

}
}
public void spherePulse(){
  if (myKick > 0.01f){ //&& //millis() - time >= wait){
    while (Pulse < 20){
      Pulse = Pulse + 0.1f;
    }
      //time = millis();
    }
    else if (myKick < 0.01f){
      while (Pulse > 1){
        Pulse = Pulse - 0.1f;
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
  //return sin(t/10)*100 + sin(t/6)*30;
  return sin(t/10) * 100 + sin(t/15)*100;

}

public float w1y1(float t) {

  //return cos(t/10)*100;
  return cos(t/10) * 100;

}
public float w1x2(float t){
   //return sin(t/10)*200 + sin(t)*2;
   return sin(t/10)*200 + sin(t)*4;

  
}

public float w1y2(float t) {

  //return cos(t/20)*200 + cos(t/12)*20;
return cos(t/20) * 200 + cos(t/23)*20;
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
private void whitneyDraw1(){

  //stroke(LR,UD,160);
  background(0xff000F0D);
  //translate(width/2, height/2);

  for (int c = 0; c < NUM_LINES; c++){ //draws lines

    strokeWeight(2);
    stroke(LR,UD,160);
		line(w1x1(-t+c*2), w1y1(-t+c*2) , w1x2(-t+c*2),  w1y2(-t+c*2)) ;
    stroke(168,UD,LR);
    line(w2x1(t+c*2), w2y1(t+c*2) , w2x2(t+c*2),  w2y2(t+c*2)) ;

}

t++;  //Pulse*0.1;



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
  public void settings() {  size(1300,800, P2D);  smooth(8); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ThisShouldWork" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
