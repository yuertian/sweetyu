#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int MoreThanHalf(int *arr, int n)
 {
	 int cur, count = 0;
	 for (int i = 0; i<n; i++)
	 {
		 if (count == 0)
		 {
			 cur = arr[i];
			 count =1;
		 }
		 else
		 {
			 if (cur == arr[i])
				 count++;
			 else
				 count--;
		 }
	 }
	   return cur;
 }

 int main()
 {
	 int arr[9] = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
	 int ret = MoreThanHalf(arr,9);
	 printf("%d\n", ret);
	 system("pause");
	 return 0;
 }