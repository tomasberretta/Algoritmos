package TPs.TPComparacionArboles;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class RBTree<T> {

    private RBNode<T> headNode;
    private static RBNode nullNode;

    static {
        nullNode = new RBNode(null);
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

    private int compare(Comparable<T> tComparable, RBNode<T> rbNode ) {
        if( rbNode == headNode)
            return 1;
        else
            return tComparable.compareTo((T) rbNode.data);
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

    public void insert (Comparable<T> toInsert) {
        currentNode = parentNode = grandparentNode = headNode;
        nullNode.data = (T) toInsert;

        while(compare( toInsert, currentNode) != 0) {
            greatgrandparentNode = grandparentNode;
            grandparentNode = parentNode;
            parentNode = currentNode;
            currentNode = compare( toInsert, currentNode) < 0 ?
                    currentNode.left : currentNode.right;
            if( currentNode.left.color == 0 && currentNode.right.color == 0 )
                rearrangeTreeOrder( toInsert );
        }
        currentNode = new RBNode<T>((T) toInsert, nullNode, nullNode );

        if( compare(toInsert, parentNode) < 0 )
            parentNode.left = currentNode;
        else
            parentNode.right = currentNode;
        rearrangeTreeOrder( toInsert );
    }

    private RBNode<T> rotateTree(Comparable<T> tComparable, RBNode<T> parentNode ) {
        if( compare( tComparable, parentNode ) < 0 )
            return parentNode.left = compare( tComparable, parentNode.left ) < 0 ?
                    rotateWithLeftChild( parentNode.left )  :
                    rotateWithRightChild( parentNode.left ) ;
        else
            return parentNode.right = compare( tComparable, parentNode.right ) < 0 ?
                    rotateWithLeftChild( parentNode.right ) :
                    rotateWithRightChild( parentNode.right );
    }

    private RBNode<T> rotateWithLeftChild(RBNode<T> y ) {
        RBNode<T> x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    private RBNode<T> rotateWithRightChild(RBNode<T> x ) {
        RBNode<T> y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private void rearrangeTreeOrder(Comparable<T> tComparable) {
        currentNode.color = 0;
        currentNode.left.color = 1;
        currentNode.right.color = 1;

        if( parentNode.color == 0 ){
            grandparentNode.color = 0;
            if( ( compare( tComparable, grandparentNode) < 0 ) != ( compare( tComparable, parentNode) < 0 ) )
                parentNode = rotateTree( tComparable, grandparentNode);
            currentNode = rotateTree( tComparable, greatgrandparentNode);
            currentNode.color = 1;
        }
        headNode.right.color = 1;
    }

    public boolean isEmpty( ) {
        return headNode.right == nullNode;
    }

    public Comparable<T> search(Comparable<T> toSearch ) {
        nullNode.data = (T) toSearch;
        currentNode = headNode.right;

        for( ; ; ) {//infinite for that only ends when the element is found
            if( toSearch.compareTo( currentNode.data) < 0 )
                currentNode = currentNode.left;
            else if( toSearch.compareTo( currentNode.data) > 0 )
                currentNode = currentNode.right;
            else if( currentNode != nullNode )
                return (Comparable<T>) currentNode.data;//condition to end for
            else
                return null;//condition to end for
        }
    }

    public int searchWithCounter(Comparable<T> toSearch ) {
        int counter = 0;
        nullNode.data = (T) toSearch;
        currentNode = headNode.right;

        for( ; ; ) { //infinite for that only ends when the element is found
            if( toSearch.compareTo( currentNode.data) < 0 ){
                currentNode = currentNode.left;
                counter++;
            }
            else if( toSearch.compareTo( currentNode.data) > 0 ){
                currentNode = currentNode.right;
                counter++;
            }
            else if( currentNode != nullNode ){
                return counter; //condition to end for
            }
            else
                return -1;
        }
    }


    //public method that calls private recursive method
    public int height() {
        return height(headNode.right, 0);
    }

    private int height(RBNode<T> rbNode, int counter) {
        if (rbNode == nullNode && counter == 0)
            return -1;
        else if(rbNode == nullNode){
            return 0;
        }
        else {
            int hLeft = height(rbNode.left,++counter);
            int hRight = height(rbNode.right, ++counter);

            if(hLeft > hRight) return 1 + hLeft;
            else if (hLeft < hRight) return 1 + hRight;
            else return 1 + hLeft;  //both are the same height, so either one works
        }
    }
}