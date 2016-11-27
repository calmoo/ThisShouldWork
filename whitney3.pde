

float w3x1(float t){

  //return cos(1 * t) - pow((cos(80 * t)), 3);
  //return cos(1 * t)- pow((cos(80 * t)), 3) * 20;
  return cos(a * t) * 10 - pow((cos(b * t)), 3) *100;
}

float w3y1(float t) {


  //return sin(1*t) - pow((sin(80 * t)), 3);
  //return sin(1*t)  - pow((sin(80 * t)), 3) * 100;
  return sin(c*t) * 10  - pow((sin(d * t)), 3) * 100;

}
float w3x2(float t){

   //return  cos(1 * t)*200 - pow((cos(80 * t)), 3);
   return  cos(a * t) * 20 - pow((cos(b * t)), 3) * 400 ;


}

float w3y2(float t) {


//return sin(1*t)*200 - pow((sin(80 * t)), 3);
return sin(c*t) * 20  - pow((sin(d * t)) , 3) * 400 ;
}
