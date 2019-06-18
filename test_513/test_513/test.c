#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int init(int arr[],int n)
{
	int i = 0;
	for (i = 0; i < n; i++)
	{
		arr[i] = i;
		printf("%d ", arr[i]);
	}
	return 0;
}

int empty(int arr[], int n)
{
	int i = 0;
	for (i = 0; i < n; i++)
	{
		arr[i] = 0;
		printf("%d ", arr[i]);
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
			printf("%d ", arr[i]);
		}
	}
	return 0;
}

int main()
{
	int arr[] = { 0 };
	int n = (sizeof(arr) / sizeof(arr[0]));
	int i = 0;
	printf("������һ��һά���鳤��:\n");
	scanf("%d", &n);
	printf("��ʼ�����飺\n");
	init(arr[i], n);
	printf("\n");
	printf("������飺\n");
	empty(arr[i], n);
	printf("\n");
	printf("�������飺\n");
	reverse(arr[i], n);
	printf("\n");
	system("pause");
	return 0;
}
