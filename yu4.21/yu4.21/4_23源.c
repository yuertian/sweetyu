#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include <string.h>
int main()
{
	char arr1[] = "*************";
	char arr2[] = "             ";
	int left = strlen(arr1) / 2;
	int right = left;
	while(left <= right)
	{
		arr2[left] = arr1[left];
		arr2[right] = arr1[right];
		printf("%s", arr1);
		left--;
		right++;
		if (right > strlen(arr1) - 1)
		{
			left++;
			right--;
			arr2[left] = arr1[left];
			arr2[right] = arr1[right];
			printf("%s", arr1);
		}
	}


	system("pause");
	return 0;
}