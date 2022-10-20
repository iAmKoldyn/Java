#include <stdio.h>
int main() {
    int a[5] = {1,5,6,8,9};
    int n =5;
    int y = 1;
    for(int x = n - 1 ; x > 0 && y > 0; x--) {
  y = 0;
        for(int i = 0 ; i < x; i++) {
            if(a[i] > a[i+1]) {
                int mem = a[i];
                a[i] = a[i+1];
                a[i+1] = mem;
    y = y + 1;
            }
        }
    }
    for(int j = 0; j < n; ++j) {
        printf("%d ", a[j]);
     }
 }
