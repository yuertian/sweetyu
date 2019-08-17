#pragma once

#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

typedef struct Node
{
	int data;
	struct Node *next;
}Node, *pList;

void InitList(pList plist);
void InsertHead(pList plist, int val);
void InsertTail(pList plist, int val);
void Show(pList plist);
Node *LastKNode(pList plist, int k);
void InsertNode(pList plist, int n,int val);

void ReversionNode(pList plist);
