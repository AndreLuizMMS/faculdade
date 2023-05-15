#include <stdio.h>

void main() {
  float a, b, c, d;
  scanf("%f %f %f %f", &a, &b, &c, &d);
  if (a < b && c < b && d < b) {
    if (a > c && a > d) {
      if (c > d) {
        printf("%.2f, %.2f, %.2f, %.2f\n", d, c, a, b);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", c, d, a, b);
      }
    }
    else if (c > a && c > d) {
      if (a > d) {
        printf("%.2f, %.2f, %.2f, %.2f\n", d, a, c, b);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", a, d, c, b);
      }
    }
    else if (d > a && d > c) {
      if (a > c) {
        printf("%.2f, %.2f, %.2f, %.2f\n", c, a, d, b);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", a, c, d, b);
      }
    }
  }

  else if (b < a && c < a && d < a) {
    if (b > c && b > d) {
      if (c > d) {
        printf("%.2f, %.2f, %.2f, %.2f\n", d, c, b, a);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", c, d, b, a);
      }
    }
    else if (c > b && c > d) {
      if (b > d) {
        printf("%.2f, %.2f, %.2f, %2f\n", d, b, c, a);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", b, d, c, a);
      }
    }
    else if (d > b && d > c) {
      if (b > c) {
        printf("%.2f, %.2f, %.2f, %.2f\n", c, b, d, a);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", b, c, d, a);
      }
    }
  }

  else if (b < c && a < c && d < c) {
    if (b > a && b > d) {
      if (a > d) {
        printf("%.2f, %.2f, %.2f, %.2f\n", d, a, b, c);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", a, d, b, c);
      }
    }
    else if (a > b && a > d) {
      if (b > d) {
        printf("%.2f, %.2f, %.2f, %.2f\n", d, b, a, c);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", b, d, a, c);
      }
    }
    else if (d > b && d > a) {
      if (b > a) {
        printf("%.2f, %.2f, %.2f, %.2f\n", a, b, d, c);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", b, a, d, c);
      }
    }
  }

  else {
    if (b > a && b > c) {
      if (a > c) {
        printf("%.2f, %.2f, %.2f, %.2f\n", c, a, b, d);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", a, c, b, d);
      }
    }
    else if (a > b && a > c) {
      if (b > c) {
        printf("%.2f, %.2f, %.2f, %.2f\n", c, b, a, d);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", b, c, a, d);
      }
    }
    else if (c > b && c > a) {
      if (b > a) {
        printf("%.2f, %.2f, %.2f, %.2f\n", a, b, c, d);
      }
      else {
        printf("%.2f, %.2f, %.2f, %.2f\n", b, a, c, d);
      }
    }
  }
}