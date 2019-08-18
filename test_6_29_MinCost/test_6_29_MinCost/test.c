#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include <Windows.h>
#include <assert.h>
#include <string.h>

int types = 0; // 商品种类
int* price; // 商品价格
int rules = 0; // 优惠策略的种类数
int** R; // 规则表
int* goods;
int isEmpty(int* goods) { // 判断商品是否为空
	assert(goods != NULL);
	int i;
	for (i = 0; i < types; ++i) {
		if (goods[i] > 0) {
			return 0;
		}
	}
	return 1;
}
int nPrice(int* goods) { // 计算剩余商品的原价总价
	assert(goods != NULL);
	int sum = 0;
	int i;
	for (i = 0; i < types; ++i) {
		sum += goods[i] * price[i];
	}
	return sum;
}
int min1(int* arr)
{
	int minnum = 100;
	int i;
	for (i = 0; i < rules; ++i) {
		if (arr[i] != 0 && minnum > arr[i]) {
			minnum = arr[i];
		}
	}
	return minnum;
}
int minPrice(int* goods) {
	assert(goods != NULL);
	if (isEmpty(goods)) {
		return 0;
	}
	int arr_index = 0;
	int* arr = (int*)malloc(rules * sizeof(int));
	int sumprice = 0;
	int flag = 0;
	int i;
	for (i = 0; i < rules; ++i) {
		int j = 0;
		int* newgoods = (int*)malloc(types * sizeof(int));
		while (j < types) {
			newgoods[j] = goods[j];
			++j;
		}
		j = 0;
		while (j < types) { // 判断商品是否满足这个优惠政策
			if (newgoods[j] < R[i][j]) {
				break;
			}
			++j;
		}
		if (j == types) { // 满足
			j = 0;
			while (j < types) {
				newgoods[j] -= R[i][j];
				++j;
			}
			sumprice = R[i][j] + minPrice(newgoods);
			arr[arr_index++] = sumprice;
			free(newgoods);
		}
		else {
			++flag;
		}
	}
	if (flag == rules) {
		return nPrice(goods);
	}
	int minprice = min1(arr);
	free(arr);
	return minprice;
}
int main() {
	int i, j;
	printf("请输入商品种类:");
	scanf("%d", &types);//types = 2;
	price = (int*)malloc(types * sizeof(int));
	printf("请输入商品单价:");
	for (i = 0; i < types; ++i) {
		scanf("%d", &price[i]);
	}
	printf("请输入优惠规则个数:");
	scanf("%d", &rules);//rules = 2;
	R = (int**)malloc(rules * sizeof(int*));
	printf("请输入每个商品所需数量和优惠后的价格:\n");
	for (i = 0; i < rules; ++i) {
		R[i] = (int*)malloc((types + 1) * sizeof(int));
		for (j = 0; j < types + 1; ++j) {
			scanf("%d", &R[i][j]);
		}
	}
	goods = (int*)malloc(types * sizeof(int));
	printf("请输入每个商品购买的数量:");
	for (i = 0; i < types; ++i) {
		scanf("%d", &goods[i]);
	}
	printf("%d\n", minPrice(goods));
	free(price);
	for (i = 0; i < rules; ++i) {
		free(R[i]);
	}
	free(R);
	free(goods);
	system("pause");
	return 0;
}

