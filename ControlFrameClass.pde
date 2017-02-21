class ControlFrame extends PApplet {

  int w, h;
  PApplet parent;
  ControlP5 cp5;
  float sceneChangeFreq;

  public ControlFrame(PApplet _parent, int _w, int _h, String _name) {
    super();   
    parent = _parent;
    w=_w;
    h=_h;
    PApplet.runSketch(new String[]{this.getClass().getName()}, this);
  }
  public void settings() {

    size(w, h, P2D);
  }

  public void setup() {
    background(0);
    this.surface.setSize(w, h);
    cp5 = new ControlP5(this);
    cp5.addSlider("sceneChangeFreq")
         .setPosition(100,50)
         .setWidth(400)
         .setRange(0.125,1)
         .setValue(0.125)
         .setNumberOfTickMarks(5)
         .setSliderMode(Slider.FLEXIBLE)
         .plugTo(parent,"sceneChangeFreq");
         ;
      }


}