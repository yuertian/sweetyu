#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int Fun(int a[],int k)
{
	int i = 0;
	int j = sizeof(a)/sizeof(int);
	if (a[i] + a[j] == k)
	{
		for (i = 0; i < j / 2; i++)
		{
			printf("%d %d", i, j);
				j--;
		}
	}
	if (a[i] + a[j] < k)
	{
		
	}

}


int main()
{
	int arr[10] = { 1, 2, 3, 4, 5, 6 };
	/*int ret = 0;
	Fun(7);*/
	printf("%d", Fun(arr,9));
	system("pause");
	return 0;
}





