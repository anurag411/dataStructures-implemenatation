package BurnTree;

public class BurnTreeRootToLeaf {

    static class Node {
        int val;
        Node left, right;
        Node (int val ){
            this.val = val;
            left = right= null;
        }
    }

    static class Data {
        int leftData;
        int rightData;
        int time;
        boolean contains;
        Data() {
            leftData = rightData =0;
            time = -1;
            contains = false;
        }
    }

    static int result = 0;
    private static void burnTree(Node root, Data data, int target) {
        if(root == null)
            return ;
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                data.time =0;
                data.contains = true;
            }
            return ;
        }


        Data leftData = new Data();
        burnTree(root.left, leftData, target);

        Data rightData = new Data();
        burnTree(root.right, rightData, target);

        data.time = (leftData.contains) ? leftData.time + 1 : -1;

        if(data.time == -1) {
            data.time = (rightData.contains) ? rightData.time + 1 : -1;
        }

        data.contains = (leftData.contains || rightData.contains);

        data.leftData = (root.left == null) ? 0 : (1 + Math.max(leftData.leftData, leftData.rightData));

        data.rightData = (root.right == null) ? 0 : (1 + Math.max(rightData.leftData, rightData.rightData));

        if (data.contains) {

            if (leftData.contains) {
                result = Math.max(result, data.time + data.rightData);
            }
            if (rightData.contains) {

                // calculate result
                result = Math.max(result, data.time + data.leftData);
            }
        }


    }
    public static void main(String args[]) {
        /*Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.right = new Node(9);*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);
        root.left.right.left.left = new Node(11);
        int target = 11;
        burnTree(root, new Data(), target);
        System.out.println("Number of steps = "+ result);

    }

  /*
  fire starting from leaf 5
  how many steps tree burns fully   output: 5
                      1
                   /     \
                  2        3
                /   \       \
               4     5        6
                               \
                                9

   */
}
