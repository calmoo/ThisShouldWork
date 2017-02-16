float panAmount = 0;
float tiltAmount = 0;
float alpha = 4;
float beta = 4;


class PanTiltMover{

  void run(){
    if (sceneIntervalCounter <= 3){
      cameraPan();
    }

    else if (sceneIntervalCounter >=4){
      cameraTilt();
      if (sceneIntervalCounter == 5){
        panAmount = width/2;
        tiltAmount = height/2;
      }
    }


  }


  void cameraPan(){
    if (panAmount < 0){
      alpha = 4;
    }
    else if (panAmount > width){
      alpha = -4;
    }
    panAmount += alpha;
    //println(panAmount);
  }

  void cameraTilt(){
    if (tiltAmount < 0){
      beta = 4;
    }
    else if (tiltAmount > height){
      beta = -4;
    }
    tiltAmount += beta;
  }
}
