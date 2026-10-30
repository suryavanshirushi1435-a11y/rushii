typedef struct N{
    int v;
    struct N *n;
}N;

typedef struct{
    N *h;
    int s;
}MyLinkedList;

MyLinkedList* myLinkedListCreate(){
    MyLinkedList *l=malloc(sizeof(MyLinkedList));
    l->h=NULL; l->s=0;
    return l;
}

int myLinkedListGet(MyLinkedList* o,int i){
    if(i<0||i>=o->s) return -1;
    N *c=o->h;
    while(i--) c=c->n;
    return c->v;
}

void myLinkedListAddAtHead(MyLinkedList* o,int v){
    N *t=malloc(sizeof(N));
    t->v=v; t->n=o->h;
    o->h=t; o->s++;
}

void myLinkedListAddAtTail(MyLinkedList* o,int v){
    N *t=malloc(sizeof(N)),*c=o->h;
    t->v=v; t->n=NULL;
    if(!c) o->h=t;
    else{
        while(c->n) c=c->n;
        c->n=t;
    }
    o->s++;
}

void myLinkedListAddAtIndex(MyLinkedList* o,int i,int v){
    if(i<0) i=0;
    if(i>o->s) return;
    if(i==0){ myLinkedListAddAtHead(o,v); return; }

    N *c=o->h,*t=malloc(sizeof(N));
    while(--i) c=c->n;
    t->v=v; t->n=c->n;
    c->n=t; o->s++;
}

void myLinkedListDeleteAtIndex(MyLinkedList* o,int i){
    if(i<0||i>=o->s) return;

    N *t,*c=o->h;
    if(i==0){
        o->h=c->n;
        free(c);
    }else{
        while(--i) c=c->n;
        t=c->n;
        c->n=t->n;
        free(t);
    }
    o->s--;
}

void myLinkedListFree(MyLinkedList* o){
    N *t;
    while(o->h){
        t=o->h;
        o->h=o->h->n;
        free(t);
    }
    free(o);
}