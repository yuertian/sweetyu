#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include <string.h>
int main()
{
	char arr1[] = "*************";
	char arr2[] = "             ";
	char arr3[] = "             ";
	int left = strlen(arr1) / 2;
	int right = strlen(arr1) / 2;
	while(left <= right )
	{
		arr2[left] = arr1[left];
		arr2[right] = arr1[right];
		printf("%s\n", arr2);
		left--; 
		right++;
		if (right == strlen(arr1))
			break;
	}
	while (left <= right)
	{
		arr2[left] = arr3[left];
		arr2[right] = arr3[right];
		printf("%s\n", arr2);
		left++;
		right--;
		if (right == strlen(arr1) / 2)
			break;
	}
	
	system("pause");
	return 0;
}
