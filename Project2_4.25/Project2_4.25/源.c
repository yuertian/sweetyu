#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include <string.h>
int main()
{
	char arr1[] = "*************";
	char arr2[] = "             ";
	int left = strlen(arr1) / 2;
	int right = strlen(arr1) / 2;
	while (left <= right)
	{
		arr2[left] = arr1[left];
		arr2[right] = arr1[right];
		printf("%s\n", arr2);
		left--;
		right++;
	}
	while (left <= right)
	{
		arr1[left] = arr2[left];
		arr1[right] = arr2[right];
		printf("%s\n", arr1);
		left++;
		right--;
	}
	system("pause");
	return 0;
}