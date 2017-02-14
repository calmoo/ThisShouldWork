float panAmount = 0;
float tiltAmount = 0;
float alpha = 4;
float beta = 4;


class PanTiltMover{

  void run(){
    if (clapCounter <= 3){
      cameraPan();
    }

    else if (clapCounter >=4){
      cameraTilt();
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
