//#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include <string.h>
int main()
{
	char arr1[] = "*************";
	char arr2[] = "             ";
	int left = 0;
	int right = strlen(arr1) / 2;
	for (left = right ; left--; right++)
	{
		arr2[left] = arr1[left];
		arr2[right] = arr1[right];
		printf("%s\n", arr2);
	}
		//if (right > strlen(arr1) - 1)
		//{
			//for (right = left; left--; right++)
			//{
			//	arr2[left] = arr1[left];
			//	arr2[right] = arr1[right];
			//	printf("%s", arr1);
			//}
	


	system("pause");
	return 0;
}