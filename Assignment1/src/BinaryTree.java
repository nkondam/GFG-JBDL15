import java.util.*;


public class BinaryTree {

    Node root;
    static List<Person> arr = new ArrayList<>();
    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Person person) {
        root = new Node(person);
    }



    public void inOrderTraverseTree(Node root) {

        if(root != null) {
            inOrderTraverseTree(root.left);
            arr.add(root.getPerson());
            inOrderTraverseTree(root.right);
            
            // You need to insert in the map here itself, no need to add in the array and then traverse
        }
    }
    public HashMap<Person, Integer> findPersonMap(Node root) {
        HashMap<Person, Integer> result = new HashMap<>();
        if (root != null) {
            inOrderTraverseTree(root);

            for (int i = 0; i < arr.size(); i++) {  // why are you populating the map in this way, if you were populate like this then what's the point of taking binary tree.
                int count = 0;
                for (int j = 0; j < arr.size(); j++) {
                    if (arr.get(i).equals(arr.get(j))) {
                        count += 1;
                    }
                }
                result.put(arr.get(i), count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Person p1 = new Person(20, "tim", 175);
        Person p2 = new Person(16, "jim", 185);
        Person p3 = new Person(75, "tom", 167);
        Person p4 = new Person(16, "jim", 185);
        Person p5 = new Person(20, "tim", 175);
        Person p6 = new Person(16, "jim", 185);
        Person p7 = new Person(75, "tom", 167);

        BinaryTree tree = new BinaryTree();
        //create a tree
        tree.root = new Node(p1);
        //create left right branches
        tree.root.left = new Node(p2);
        tree.root.right = new Node(p3);
        // create left subbranch
        tree.root.left.left = new Node(p4);
        tree.root.left.right = new Node(p5);
        //create a right subbranch
        tree.root.right.left = new Node(p6);
        tree.root.right.right = new Node(p7);

        HashMap<Person, Integer> finalResult = new HashMap<>();
        finalResult = tree.findPersonMap(tree.root);
        System.out.println(finalResult.toString());


    }


}

