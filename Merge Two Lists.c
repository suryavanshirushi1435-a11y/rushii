struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode dummy = {0, NULL};
    struct ListNode *op = &dummy;

    while (list1 && list2) {
        if (list1->val <= list2->val) {
            op->next = list1;
            list1 = list1->next;
        } else {
            op->next = list2;
            list2 = list2->next;
        }
        op = op->next;
    }

    op->next = list1 ? list1 : list2;

    return dummy.next;
}