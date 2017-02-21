float w1x1(float t){
  return sin(t/10)*100 + sin(t/6)*30;

}

float w1y1(float t) {

  return cos(t/10)*100;

}
float w1x2(float t){
	float size = map(freqCutoff,0.36,1,200,400);
   return sin(t/10)*size + sin(t)*2;

}

float w1y2(float t) {
	float size = map(freqCutoff,0.36,1,200,400);
  return cos(t/20)*size + cos(t/12)*20;

}
