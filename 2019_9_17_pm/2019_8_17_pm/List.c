#define _CRT_SECURE_NO_WARNINGS 1
#include "list.h"

void InitList(pList plist)
{
	assert(plist != NULL);
	plist->data = -1;
	plist->next = NULL;
}


Node * GetNode( int val)
{
	Node *pGet = (Node *)malloc(sizeof(Node));
	pGet->data = val;
	pGet->next = NULL;
	return pGet;
}

void InsertHead(pList plist, int val)
{
	Node *pGet = GetNode(val);
	assert(plist != NULL);
	pGet->next = plist->next;
	plist->next = pGet;
}

void InsertTail(pList plist, int val)
{
	Node *pGet = GetNode(val);
	Node *p = plist;
	assert(plist != NULL);
	while (p->next != NULL)
	{
		p = p->next;
	}
	p->next = pGet;
}


void Show(pList plist)
{
	Node *p = plist->next;
	assert(plist != NULL);
	while (p != NULL)
	{
		printf("%d ", p->data);
		p = p->next;
	}
	printf("\n");
}

Node *LastKNode(pList plist, int k)
{
	Node *p = plist;
	Node *q = plist;
	assert(plist != NULL);
	if (k < 0)
	{
		return NULL;
	}
	while (--k)
	{
		if (p->next != NULL)
		{
			p = p->next;
			--k;
		}
		else
		{
			return NULL;
		}
	}
	while (p->next != NULL)
	{
		p = p->next;
		q = q->next;
	}
	return q;
}


void InsertNode(pList plist, int n,int val)//第n个结点后插入
{
	Node *pGet = GetNode(val);
	Node *p = plist;
	assert(plist != NULL);
	while(n)
	{
		p = p->next;
		--n;
	}
	pGet->next = p->next;
	p->next = pGet;
}







void ReversionNode(pList plist)
{
	Node *p = plist;
	
}