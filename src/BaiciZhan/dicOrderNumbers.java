package BaiciZhan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuding on 3/24/18.
 */
public class dicOrderNumbers {

    /**
     * DFS
     */
    public List<Integer> dicOrder(int n){
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 1; i < 10; i++) {
            dfs(res, n, i);
        }
        return res;
    }
    private void dfs(List<Integer> res, int n, int startDig) {
        // base case
        if(startDig > n) {
            return;
        }
        res.add(startDig);
        for(int i = 0; i < 10; i++) {
            int nextNum = startDig * 10 + i;
            if(nextNum > n) {
                return;
            }
            dfs(res, n, nextNum);
        }
        return;
    }
    public static void main(String[] args) {
        dicOrderNumbers lo = new dicOrderNumbers();
        System.out.print(lo.dicOrder(99));
    }

    /**
     * c++ version
     * struct TreeNode {
     *     TreeNode * left;
     *     TreeNode * right;
     *     int value;
     *     TreeNode(int v) {
     *         value = v;
     *         left = right = NULL;
     *     }
     * };
     *
     * void printTreeLevel(TreeNode * root) {
     *     if(!root) return;
     *     queue<pair<TreeNode *, int> > q;
     *     int lvl;
     *     set<TreeNode* > s; // 用来去重
     *     int preLvl = 0;
     *
     *     TreeNode * temp;
     *     q.push(make_pair(root, 0));
     *     s.insert(root);
     *
     *     while(!q.empty()){
     *          pair<TreeNode*, int> p = q.front();
     *          q.pop();
     *          temp = p.first;
     *          lvl = p.second;
     *
     *          if(lvl == preLvl + 1){
     *              cout<<endl;
     *          }
     *          cout << temp->value << " ";
     *          preLvl = lvl;
     *
     *          if(temp->left != NULL && s.find(temp->left) == s.end()){
     *              q.push(make_pair(temp-left, lvl + 1);
     *              s.insert(temp->left);
     *          }
     *
     *          if(temp->right != NULL && s.find(temp->right) == s.end()){
     *              q.push(make_pair(temp->right, lvl + 1);
     *              s.insert(temp->right);
     *          }
     *     }
     * }
     */
}
