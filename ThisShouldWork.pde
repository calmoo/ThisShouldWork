ControlFrame cf;


void settings() {
  size(1400, 800, P3D);
}
void setup() {

  particles = new ArrayList<Particle>();
  smooth(4);
  frameRate(60);
  osc = new OscP5(this, 8000);
  osc.properties().setRemoteAddress("127.0.0.1", 8000 );
  remote = new NetAddress( "127.0.0.1", 8000 );
  cf = new ControlFrame(this, 600, 200, "Controls");
}

void draw() {


  pushMatrix();

  camera(panAmount, tiltAmount, (height/2.0) / tan(PI*30.0 / 180.0), width/2.0, height/2.0, 0, 0, 1, 0);
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

}



void mousePressed() {
  clapCounter += sceneChangeFreq;
  sceneIntervalCounter = int(clapCounter);

  if (sceneIntervalCounter > 7) {
    clapCounter = 0;
    sceneIntervalCounter = 0;
  }
}