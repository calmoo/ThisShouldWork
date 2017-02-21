float w2x1(float t){

  return sin(t/10) * 100 + sin(t/20)*100;

}

float w2y1(float t) {


  return cos(t/10) * 100;

}
float w2x2(float t){
	float size = map(freqCutoff,0.36,1,200,400);
   return sin(t/10)*size + sin(t)*4;


}

float w2y2(float t) {

float size = map(freqCutoff,0.36,1,200,400);
return cos(t/20) * size + cos(t/30)*20;
}
