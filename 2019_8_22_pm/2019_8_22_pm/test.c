#include<stdio.h>
#include<stdlib.h>
#include<assert.h>


int removeDuplicates(int* nums, int numsSize)
{
	/*int *p = nums;
	int *q = nums;*/
	int i = 0;
	int j = 0;
	int count = numsSize;
	for (i = 0; i < numsSize; i++)
	{
		for (j = 1; j < numsSize; j++)
		{
			if (nums[j] == nums[i])
			{
				count--;
				while (j<count)
				{
					nums[j] = nums[j + 1];
					j++;
				}
			
			}
		}
	}
	return count;
	/*assert(nums != NULL);    { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	while (p != NULL)
	{
		while (q != NULL)
		{
			q++;
			if (*p == *q)
			{
				q = q++;
				numsSize--;
			}
		}
		q = p;
		p++;
	}*/
}


int main()
{
	int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
	int numsSize = sizeof(nums) / sizeof(nums[0]);
	int newSize = removeDuplicates(nums, numsSize);
	printf("%d\n", newSize);
	system("pause");
	return 0;
}