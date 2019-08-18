
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int* Maopao(int *arr)
{
	int tmp;
	int i = 0;
	int j = 0;
	int*p = arr;
	for (i = 0; i<sizeof(arr) / sizeof(arr[0]); i++)
	{
		for (j = 0; j<i; j++)
		{
			if (*arr > *(arr + 1))
			{
				tmp = *(arr + 1);
				*(arr + 1) = *arr;
				*arr = tmp;
				arr++;
			}
		}
	}
	return p;
}

int main()
{
	int arr[] = { 2, 3, 1,5, 9, 7, 4, 8, 6 };
	Maopao(arr);
	printf("%d\n", arr);
	system("pause");
	return 0;
}