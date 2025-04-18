//11ms

/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *left;
 *     struct Node *right;
 *     struct Node *next;
 * };
 */

struct Node* connect(struct Node* root) {
    if (root == NULL)
        return NULL;

    struct Node* ll = root;
        struct Node* head = ll;
    while(ll->left!=NULL)
    {
        head = ll;
        while(head != NULL)
        {
            head ->left ->next = head ->right;
            if (head->next != NULL) {
                head->right->next = head->next->left;
            }
            head = head->next;
        }

        ll = ll->left;
    }
    return root;
}
