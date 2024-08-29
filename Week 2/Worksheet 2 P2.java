public char generateColorRGBP ()
{
  Random r = new Random();
  double result = rand.nextDouble();

  if (result < .20)
  {
    return 'r';
  }
  else if (result < .35)
  {
    return 'g';
  }
  else if (result < .70)
  {
    return 'b';
  }
  else
  {
    return 'p';
  }
}
  
