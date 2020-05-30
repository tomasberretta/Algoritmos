package TPs.TPComparacionArboles;

public class RBTree<T> {

    private RBNode<T> headNode;
    private static RBNode nullNode;

    static {
        nullNode = new RBNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }

    private RBNode<T> currentNode;
    private RBNode<T> parentNode;
    private RBNode<T> grandparentNode;
    private RBNode<T> greatgrandparentNode;

    public RBTree( ) {
        headNode = new RBNode<>( null );
        nullNode = new RBNode<>( null );
        nullNode.left = nullNode.right = nullNode;
        headNode.left = headNode.right = nullNode;
    }

    public RBTree(RBNode<T> aTreeNode){
        nullNode = new RBNode<>( null );
        nullNode.left = nullNode.right = nullNode;
        headNode = aTreeNode;
    }

    private int compare(Comparable<T> data, RBNode<T> rbNode ) {
        if( rbNode == headNode)
            return 1;
        else
            return data.compareTo((T) rbNode.element);
    }

    public RBTree<T> getRoot() {
        return new RBTree<>(headNode.right);
    }

    public RBTree<T> getLeft() {
        return new RBTree<>(headNode.right.left);
    }

    public RBTree<T> getRight() {
        return  new RBTree<>(headNode.right.right);
    }

    public void insert (Comparable<T> item ) {
        currentNode = parentNode = grandparentNode = headNode;
        nullNode.element = (T) item;

        while(compare( item, currentNode) != 0) {
            greatgrandparentNode = grandparentNode; grandparentNode = parentNode; parentNode = currentNode;
            currentNode = compare( item, currentNode) < 0 ?
                    currentNode.left : currentNode.right;

            // Check if two red children; fix if so
            if( currentNode.left.color == 0 && currentNode.right.color == 0 )
                rearrangeTreeOrder( item );
        }

        currentNode = new RBNode<T>((T) item, nullNode, nullNode );

        // Attach to parent
        if( compare( item, parentNode) < 0 )
            parentNode.left = currentNode;
        else
            parentNode.right = currentNode;
        rearrangeTreeOrder( item );
    }

    private RBNode<T> rotateTree(Comparable<T> item, RBNode<T> parent ) {
        if( compare( item, parent ) < 0 )
            return parent.left = compare( item, parent.left ) < 0 ?
                    rotateWithLeftChild( parent.left )  :  // LL
                    rotateWithRightChild( parent.left ) ;  // LR
        else
            return parent.right = compare( item, parent.right ) < 0 ?
                    rotateWithLeftChild( parent.right ) :  // RL
                    rotateWithRightChild( parent.right );  // RR
    }

    private RBNode<T> rotateWithLeftChild(RBNode<T> k2 ) {
        RBNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    private RBNode<T> rotateWithRightChild(RBNode<T> k1 ) {
        RBNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    private void rearrangeTreeOrder(Comparable<T> item) {
        // Do the color flip
        currentNode.color = 0;
        currentNode.left.color = 1;
        currentNode.right.color = 1;

        if( parentNode.color == 0 ){
            grandparentNode.color = 0;
            if( ( compare( item, grandparentNode) < 0 ) != ( compare( item, parentNode) < 0 ) )
                parentNode = rotateTree( item, grandparentNode);  // Start dbl rotate
                currentNode = rotateTree( item, greatgrandparentNode);
                currentNode.color = 1;
        }
        headNode.right.color = 1; // Make root black
    }

    public boolean isEmpty( ) {
        return headNode.right == nullNode;
    }

    public Comparable<T> search(Comparable<T> x ) {
        nullNode.element = (T) x;
        currentNode = headNode.right;

        for( ; ; ) {
            if( x.compareTo( currentNode.element ) < 0 )
                currentNode = currentNode.left;
            else if( x.compareTo( currentNode.element ) > 0 )
                currentNode = currentNode.right;
            else if( currentNode != nullNode )
                return (Comparable<T>) currentNode.element;
            else
                return null;
        }
    }

    //public method that calls private recursive method
    public int height() {
        return height(headNode.right, 0);
    }

    private int height(RBNode<T> r, int counter) {
        if (r == nullNode && counter == 0)
            return -1;
        else if(r == nullNode){
            return 0;
        }
        else {
            int hLeft = height(r.left,++counter);
            int hRight = height(r.right, ++counter);

            if(hLeft > hRight) return 1 + hLeft;
            else if (hLeft < hRight) return 1 + hRight;
            else return 1 + hLeft;  //both are the same height, so either one works
        }
    }
}
