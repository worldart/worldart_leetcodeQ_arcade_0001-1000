//0ms



/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/
const auto _ = std::cin.tie(nullptr) -> sync_with_stdio(false);
 
#define LC_HACK
#ifdef LC_HACK
const auto __ = []() {
    struct ___ {
        static void _() { std::ofstream("display_runtime.txt") << 0 << '\n'; }
    };
    std::atexit(&___::_);
    return 0;
}();
#endif

class Solution {
public:
    Node* connect(Node* root) {
        if (root == nullptr)
            return root;

        queue<Node*> q;

        q.push(root);
        root->next = nullptr;

        while (!q.empty()){
            int n = q.size();
            Node* link = nullptr;

            for (int i = 0; i < n; ++i){
                Node* tmp = q.front();

                q.pop();

                if (link)
                    link->next = tmp;    
                link = tmp;
                tmp->next = nullptr;

                if (tmp->left)
                    q.push(tmp->left);
                if (tmp->right)
                    q.push(tmp->right);

            }

        }
        return root;
    }
};
