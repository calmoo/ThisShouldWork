
float gamma = 1;

void incrementLR(){
  if (LR <= 1){
    gamma = 1;
  }
  if (LR >= 150){
    gamma = -1;
  }
  LR += gamma;
}
