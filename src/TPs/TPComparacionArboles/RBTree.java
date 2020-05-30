package TPs.TPComparacionArboles;

public class RBTree<T> {

    private RBNode<T> header;
    private static RBNode nullNode;

    static
    {
        nullNode = new RBNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }

    private static final int BLACK = 1;
    private static final int RED   = 0;

    private RBNode<T> current;
    private RBNode<T> parent;
    private RBNode<T> grand;
    private RBNode<T> great;

    public RBTree( ) {
        header      = new RBNode<>( null );
        nullNode = new RBNode<>( null );
        nullNode.left = nullNode.right = nullNode;
        header.left = header.right = nullNode;
    }

    public RBTree ( RBNode<T> aTreeNode){
        nullNode = new RBNode<>( null );
        nullNode.left = nullNode.right = nullNode;
        header = aTreeNode;
    }

    private int compare(Comparable<T> item, RBNode<T> t ) {
        if( t == header )
            return 1;
        else
            return item.compareTo((T) t.element);
    }

    public RBTree<T> getRoot() {
        return new RBTree<>(header.right);
    }

    public RBTree<T> getLeft() {
        return new RBTree<>(header.right.left);
    }

    public RBTree<T> getRight() {
        return  new RBTree<>(header.right.right);
    }

    public void insert( Comparable<T> item ) {
        current = parent = grand = header;
        nullNode.element = (T) item;

        while(compare( item, current ) != 0) {
            great = grand; grand = parent; parent = current;
            current = compare( item, current ) < 0 ?
                    current.left : current.right;

            // Check if two red children; fix if so
            if( current.left.color == RED && current.right.color == RED )
                handleReorient( item );
        }

        current = new RBNode<T>((T) item, nullNode, nullNode );

        // Attach to parent
        if( compare( item, parent ) < 0 )
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }

    private RBNode<T> rotate(Comparable<T> item, RBNode<T> parent ) {
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

    private void handleReorient( Comparable<T> item ) {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if( parent.color == RED ){
            grand.color = RED;
            if( ( compare( item, grand ) < 0 ) !=
                    ( compare( item, parent ) < 0 ) )
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate( item, great );
            current.color = BLACK;
        }
        header.right.color = BLACK; // Make root black
    }


    public boolean isEmpty( ) {
        return header.right == nullNode;
    }

    public void printTree( ) {
        printTree( header.right );
    }

    private void printTree( RBNode<T> t ) {
        if( t != nullNode ) {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }

    public int height (RBTree<T> redBlackTree){
        if (redBlackTree.isEmpty()) return -1;
        else if(redBlackTree.getLeft().isEmpty() && redBlackTree.getRight().isEmpty()) return 1 ;
        else if(redBlackTree.getRight().isEmpty()) return 1 + height(redBlackTree.getLeft());
        else if(redBlackTree.getLeft().isEmpty()) return 1 + height(redBlackTree.getRight());
        else {
            int hLeft = height(redBlackTree.getLeft());
            int hRight = height(redBlackTree.getRight());

            if(hLeft > hRight) return 1 + hLeft;
            else if (hLeft < hRight) return 1 + hRight;
            else return 1 + hLeft; //both are the same height
        }
    }
    public Comparable<T> find( Comparable<T> x ) {
        nullNode.element = (T) x;
        current = header.right;

        for( ; ; ) {
            if( x.compareTo( current.element ) < 0 )
                current = current.left;
            else if( x.compareTo( current.element ) > 0 )
                current = current.right;
            else if( current != nullNode )
                return (Comparable<T>) current.element;
            else
                return null;
        }
    }

    public int countNodes() {
        return countNodes(header.right);

    }

    private int countNodes(RBNode<T> r) {
        if (r == nullNode)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    public int height() {
        return height(header.right);

    }

    private int height(RBNode<T> r) {
        if (r == nullNode)
            return 0;
        else {
            int hLeft = height(r.left);
            int hRight = height(r.right);

            if(hLeft > hRight) return 1 + hLeft;
            else if (hLeft < hRight) return 1 + hRight;
            else return 1 + hLeft;
        }
    }
}
