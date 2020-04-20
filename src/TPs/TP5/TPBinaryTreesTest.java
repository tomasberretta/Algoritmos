package TPs.TP5;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class TPBinaryTreesTest {


    @Test
    public void weight() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>( 5, binaryTree5,binaryTree);

        assertEquals(6, tp.weight(binaryTree6));
        assertEquals(5, tp.weight(binaryTree4));
        assertEquals(2, tp.weight(binaryTree7));
    }

    @Test
    public void numberOfLeaves() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>( 5, binaryTree5,binaryTree);

        assertEquals(3, tp.numberOfLeaves(binaryTree6));
        assertEquals(3, tp.numberOfLeaves(binaryTree4));
        assertEquals(1, tp.numberOfLeaves(binaryTree7));
    }

    @Test
    public void numberOfElementsAtLevel() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);

        assertEquals(1,tp.numberOfElementsAtLevel(binaryTree6, 0));
        assertEquals(1,tp.numberOfElementsAtLevel(binaryTree6, 1));
        assertEquals(2,tp.numberOfElementsAtLevel(binaryTree6, 2));
        assertEquals(2,tp.numberOfElementsAtLevel(binaryTree6, 3));

    }

    @Test
    public void appearencesOfElement() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);

        assertEquals(2,tp.appearencesOfElement(binaryTree6, 32));
        assertEquals(1,tp.appearencesOfElement(binaryTree6, 9));
        assertEquals(1,tp.appearencesOfElement(binaryTree6, 7));
        assertEquals(1,tp.appearencesOfElement(binaryTree6, 4));
        assertEquals(1,tp.appearencesOfElement(binaryTree6, 3));
    }

    @Test
    public void height() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(45, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(33);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 66, binaryTree4,binaryTree5);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>( 72, binaryTree6,binaryTree7);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>( 35, binaryTree3,binaryTree8);

        assertEquals(4, tp.height(binaryTree9));
        assertEquals(3, tp.height(binaryTree8));
        assertEquals(1, tp.height(binaryTree));
    }

    @Test
    public void sumOfElements() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);

        assertEquals(87,tp.sumOfElements(binaryTree6));
    }

    @Test
    public void sumOfElementsMult3() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);

        assertEquals(12,tp.sumOfElementsMult3(binaryTree6));
    }

    @Test
    public void areTreesEqual() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 4, binaryTree4,binaryTree5);

        assertTrue(tp.areTreesEqual(binaryTree3, binaryTree6));
        assertFalse(tp.areTreesEqual(binaryTree2, binaryTree6));
        assertFalse(tp.areTreesEqual(binaryTree, binaryTree3));
    }

    @Test
    public void areTreesIsomorphic() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(7);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>(3);
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 90, binaryTree4,binaryTree5);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>(7);
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>( 23, binaryTree7,binaryTree8);



        assertTrue(tp.areTreesIsomorphic(binaryTree3, binaryTree6));
        assertTrue(tp.areTreesIsomorphic(binaryTree, binaryTree4));
        assertFalse(tp.areTreesIsomorphic(binaryTree3, binaryTree9));
        assertFalse(tp.areTreesIsomorphic(binaryTree9, binaryTree6));
        assertFalse(tp.areTreesIsomorphic(binaryTree2, binaryTree6));
        assertFalse(tp.areTreesIsomorphic(binaryTree, binaryTree3));
    }

    @Test
    public void areTreesAlike() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(4);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 32, binaryTree4,binaryTree5);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>(7);
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>( 23, binaryTree7,binaryTree8);



        assertTrue(tp.areTreesAlike(binaryTree3, binaryTree6));
        assertFalse(tp.areTreesAlike(binaryTree3, binaryTree9));
        assertFalse(tp.areTreesAlike(binaryTree9, binaryTree6));
        assertFalse(tp.areTreesAlike(binaryTree, binaryTree3));
    }

    @Test
    public void showFrontier() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);

        tp.showFrontier(binaryTree6);
    }

    @Test
    public void frontier() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(32);
        arrayList.add(9);
        arrayList.add(32);
        assertEquals(arrayList, tp.frontier(binaryTree6, new ArrayList<>()) );
    }

    @Test
    public void isComplete() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);

        BinaryTree<Integer> binaryTree4 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>( 7, binaryTree3,binaryTree4);

        assertTrue(tp.isComplete(binaryTree3));
        assertFalse(tp.isComplete(binaryTree5));
    }

    @Test
    public void isFull() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);

        BinaryTree<Integer> binaryTree4 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>( 7, binaryTree3,binaryTree4);

        BinaryTree<Integer> binaryTree6 = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>(4, binaryTree6, binaryTree3);

        assertTrue(tp.isFull(binaryTree3));
        assertFalse(tp.isFull(binaryTree5));
        assertFalse(tp.isFull(binaryTree7));
    }

    @Test
    public void isStable() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Comparable<Integer>> binaryTree = new BinaryTree<>(9);
        BinaryTree<Comparable<Integer>> binaryTree2 = new BinaryTree<>(4);
        BinaryTree<Comparable<Integer>> binaryTree3 = new BinaryTree<>(32, binaryTree, binaryTree2);

        BinaryTree<Comparable<Integer>> binaryTree4 = new BinaryTree<>();
        BinaryTree<Comparable<Integer>> binaryTree5 = new BinaryTree<>( 7, binaryTree3,binaryTree4);

        BinaryTree<Comparable<Integer>> binaryTree6 = new BinaryTree<>(9);
        BinaryTree<Comparable<Integer>> binaryTree7 = new BinaryTree<>(4, binaryTree6, binaryTree3);

        assertTrue(tp.isStable(binaryTree3));
        assertFalse(tp.isStable(binaryTree5));
        assertFalse(tp.isStable(binaryTree7));
    }

    @Test
    public void isTreeInTree() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(32);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(4, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(3, binaryTree2, binaryTree3);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 7, binaryTree5,binaryTree4);

        assertTrue(tp.isTreeInTree(binaryTree6, binaryTree3));
        assertTrue(tp.isTreeInTree(binaryTree6, binaryTree2));
        assertFalse(tp.isTreeInTree(binaryTree2, binaryTree6));

    }

    @Test
    public void showPreOrden() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(45, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(33);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 66, binaryTree4,binaryTree5);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>( 72, binaryTree6,binaryTree7);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>( 35, binaryTree3,binaryTree8);

        tp.showPreOrden(binaryTree9);
    }

    @Test
    public void showInOrden() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(45, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(33);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 66, binaryTree4,binaryTree5);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>( 72, binaryTree6,binaryTree7);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>( 35, binaryTree3,binaryTree8);

        tp.showInOrden(binaryTree9);
    }

    @Test
    public void showPostOrden() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(45, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(33);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 66, binaryTree4,binaryTree5);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>( 72, binaryTree6,binaryTree7);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>( 35, binaryTree3,binaryTree8);

        tp.showPostOrden(binaryTree9);
    }

    @Test
    public void showByLevels() {
        TPBinaryTrees<Integer> tp = new TPBinaryTrees<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(8);
        BinaryTree<Integer> binaryTree2 = new BinaryTree<>(9);
        BinaryTree<Integer> binaryTree3 = new BinaryTree<>(45, binaryTree, binaryTree2);
        BinaryTree<Integer> binaryTree4 = new BinaryTree<>(33);
        BinaryTree<Integer> binaryTree5 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree6 = new BinaryTree<>( 66, binaryTree4,binaryTree5);
        BinaryTree<Integer> binaryTree7 = new BinaryTree<>();
        BinaryTree<Integer> binaryTree8 = new BinaryTree<>( 72, binaryTree6,binaryTree7);
        BinaryTree<Integer> binaryTree9 = new BinaryTree<>( 35, binaryTree3,binaryTree8);

        tp.showByLevels(binaryTree9);
    }

}