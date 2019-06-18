#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int init(int arr[], int n)
{
	int i = 0;
	for (i = 0; i < n; i++)
	{
		arr[i] = i;
		printf("%d\n", arr[i]);
	}
	return 0;
}
int empty(int arr[], int n)
{
	int i = 0;
	for (i = 0; i < n; i++)
	{
		arr[i] = 0;
		printf("%d\n", arr[i]);
	}
		return 0;
}

int reverse(int arr[], int n)
	{
		int left = 0;
		int right = n - 1;
		int temp = 0;
		int i = 0;
		for (i = 0; i < n; i++)
		{
			while (left < right)
			{
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
			printf("%d\n", arr[i]);
		}
	    return 0;
	}
	

int main()
{
	int arr[] = { 0 };
	int n = (sizeof(arr)/sizeof(arr[0]));
	int i = 0;
	printf("请输入一个一维数组长度:\n");
	scanf("%d", &n);
	printf("请输入一个一维数组:\n");
	for (i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}
	printf("初始化数组：\n");
	init(arr[i],n);
	printf("清空数组：\n");
	empty(arr[i], n);
	printf("逆置数组：\n");
	reverse(arr[i], n);
	system("pause");
	return 0;
}
