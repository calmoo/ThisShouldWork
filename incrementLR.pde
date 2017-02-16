
float gamma = 1;

void incrementLR(){
  if (LR <= 1 || Clap > 0){
    gamma = 1;
  }
  if (LR >= 150 || Clap > 0){
    gamma = -1;
  }
  LR += gamma;
}
