#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void *Mymemmove(void *dest, const void *src, int count)
{
	void *ret = dest;
	if (dest < src)
	{
		while (count--)
		{
			*(char *)dest = *(char *)src;
			((char *)dest)++;
			((char *)src)++;
		}
	}
	else
	{
		while (count--)
		{
			*(char *)dest = *(char *)src;
		}
	}
}

int mian()
{

}