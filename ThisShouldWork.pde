

void setup() {

  cp5 = new ControlP5(this);
  cp5.addSlider("sceneChangeFreq")
     .setPosition(100,600)
     .setWidth(400)
     .setRange(0.125,1)
     .setValue(0.5)
     .setNumberOfTickMarks(5)
     .setSliderMode(Slider.FLEXIBLE)
     ;



  particles = new ArrayList<Particle>();
  circles = new ArrayList<Circle>();
  size(1400,800, P3D);

  smooth(4);
  frameRate(60);
  osc = new OscP5(this,8000);
  osc.properties().setRemoteAddress("127.0.0.1" , 8000 );
  remote = new NetAddress( "127.0.0.1" , 8000 );
}

void draw(){
  //println(sceneChangeFreq);
//  blendMode(ADD);
  pushMatrix();
  //blendMode(DIFFERENCE);
  camera(panAmount, tiltAmount, (height/2.0) / tan(PI*30.0 / 180.0), width/2.0, height/2.0, 0, 0, 1, 0);
  //camera(width/2, height/2, (height/2.0) / tan(PI*30.0 / 180.0), width/2.0, height/2.0, 0, 0, 1, 0);
  rectRot++;
  keyPressed();
  incrementLR();
  incrementUD();
  whitneyDraw1();
//  triangleShape();
  ptm.run();
  popMatrix();

}

void mousePressed() {
  clapCounter += sceneChangeFreq;
  sceneIntervalCounter = int(clapCounter);
  //println(clapCounter);

  if (sceneIntervalCounter > 7){
    clapCounter = 0;
    sceneIntervalCounter = 0;
    }
  }
