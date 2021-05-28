package Tree;

public class BinaryTreeArrayImplementation {
    public static void main(String[] args) {
        array_imp.Root();
        //array_imp.set_left("B",0);
        array_imp.set_right("C", 0);
        array_imp.set_left("D",1);
        array_imp.set_right("E",1);
        array_imp.set_left("F",2);
        array_imp.printTree();
    }
}
class array_imp{
    static int root = 0;
    static String[] str = new String[10];

    static void Root(){
        str[0] = "A";
    }
    static void set_left(String key, int root){
        int t = (root * 2) + 1;
        if(str[root] == null){
            System.out.println("no parent found");
        }
        else {
            str[t] = key;
        }
    }
    static void set_right(String key, int root){
        int t = (root * 2) + 2;
        if(str[root] == null){
            System.out.println("no parent found");
        }
        else {
            str[t] = key;
        }
    }
    static void printTree(){
        for (int i = 0; i < 10; i++) {
            if(str[i] != null){
                System.out.print(str[i] + " ");
            }
            else {
                System.out.print("-");
            }
        }
    }
}
