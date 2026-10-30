typedef struct {
    int *arr;
    int front, rear, size, cap;
} MyCircularDeque;

MyCircularDeque* myCircularDequeCreate(int k) {
    MyCircularDeque* obj = malloc(sizeof(MyCircularDeque));
    obj->arr = malloc(sizeof(int) * k);
    obj->front = 0;
    obj->rear = -1;
    obj->size = 0;
    obj->cap = k;
    return obj;
}

bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {
    if (obj->size == obj->cap) return false;
    obj->front = (obj->front - 1 + obj->cap) % obj->cap;
    obj->arr[obj->front] = value;
    if (obj->size == 0) obj->rear = obj->front;
    obj->size++;
    return true;
}

bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {
    if (obj->size == obj->cap) return false;
    obj->rear = (obj->rear + 1) % obj->cap;
    obj->arr[obj->rear] = value;
    obj->size++;
    return true;
}

bool myCircularDequeDeleteFront(MyCircularDeque* obj) {
    if (obj->size == 0) return false;
    obj->front = (obj->front + 1) % obj->cap;
    obj->size--;
    return true;
}

bool myCircularDequeDeleteLast(MyCircularDeque* obj) {
    if (obj->size == 0) return false;
    obj->rear = (obj->rear - 1 + obj->cap) % obj->cap;
    obj->size--;
    return true;
}

int myCircularDequeGetFront(MyCircularDeque* obj) {
    return obj->size ? obj->arr[obj->front] : -1;
}

int myCircularDequeGetRear(MyCircularDeque* obj) {
    return obj->size ? obj->arr[obj->rear] : -1;
}

bool myCircularDequeIsEmpty(MyCircularDeque* obj) {
    return obj->size == 0;
}

bool myCircularDequeIsFull(MyCircularDeque* obj) {
    return obj->size == obj->cap;
}

void myCircularDequeFree(MyCircularDeque* obj) {
    free(obj->arr);
    free(obj);
}