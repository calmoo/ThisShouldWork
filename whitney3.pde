int a = 1;
int b = 100;
int c = 1;
int d = 50;

float w3x1(float t) {

  return cos(a * t) * 10 - pow((cos(b * t)), 3) *100;
}

float w3y1(float t) {

  return sin(c*t) * 10  - pow((sin(d * t)), 3) * 100;
}
float w3x2(float t) {

  float size = map(panAmount, 0, width, 200, 400);

  return  cos(a * t) * 20 - pow((cos(b * t)), 3) * size ;
}

float w3y2(float t) {

  float size = map(panAmount, 0, width, 200, 400);

  return sin(c*t) * 20  - pow((sin(d * t)), 3) * size ;
}