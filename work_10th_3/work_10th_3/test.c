#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int find_f(char arr[], const int len)  
{
	int i, j, k;
	int arr1[20] = { 0 };     
	for (i = 0; i < len; i++)   
	{
		k = 0;
		for (j = 0; j < len; j++)
		{
			if (arr[i] == arr[j])
				k++;
			arr1[i] = k;
		}
	}
	for (i = 0; i < len; i++)  
	{
		if (arr1[i] == 1)
		{
			return i;
		}
	}
	return len + 1;  //如果没有单独出现的字符，返回一个不是下标的数
}

int main()
{
	char arr[] = "abaccdeff";
	int len = sizeof(arr) / sizeof(arr[0]), c;
	c = find_f(arr, len);
	if (c > len)
		printf("这个字符串组数中没有只出现一次的字符\n");
	else
		printf("输入字符串中第一次出现的字符是：%c\n", arr[c]);
	system("pause");
	return 0;
}