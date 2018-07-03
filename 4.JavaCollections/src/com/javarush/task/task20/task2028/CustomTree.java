package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    private int size;

    public CustomTree() {
        root = new Entry<>("Root");
    }

    static class Entry<T> implements Serializable {

        String elementName;

        int lineNumber;

        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;

        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;

            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;

            lineNumber = 0;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        void checkChildren() {
            availableToAddLeftChildren = leftChild == null;
            availableToAddRightChildren = rightChild == null;
        }
    }

    public String getParent(String elementName) {
        if (elementName == null) {
            return null;
        }

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Entry<String> thisEntry = queue.poll();

            if (thisEntry.elementName.equals(elementName)) {
                return thisEntry.parent.elementName;
            }

            if (!thisEntry.availableToAddLeftChildren) {
                queue.offer(thisEntry.leftChild);
            }

            if (!thisEntry.availableToAddRightChildren) {
                queue.offer(thisEntry.rightChild);
            }
        }

        return null;
    }

    @Override
    public boolean add(String elementName) {
        if (elementName == null) {
            return false;
        }

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Entry<String> thisEntry = queue.poll();

            if (thisEntry.isAvailableToAddChildren()) {
                if (thisEntry.availableToAddLeftChildren) {
                    thisEntry.leftChild = new Entry<>(elementName);
                    thisEntry.leftChild.parent = thisEntry;

                    thisEntry.leftChild.lineNumber = thisEntry.lineNumber + 1;
                    size++;

                    thisEntry.checkChildren();

                    return true;
                } else  if (thisEntry.availableToAddRightChildren) {
                    thisEntry.rightChild = new Entry<>(elementName);
                    thisEntry.rightChild.parent = thisEntry;

                    thisEntry.rightChild.lineNumber = thisEntry.lineNumber + 1;
                    size++;

                    thisEntry.checkChildren();

                    return true;
                }
            } else {
                queue.offer(thisEntry.leftChild);
                queue.offer(thisEntry.rightChild);
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new UnsupportedOperationException();
        }

        String elementName;

        try {
            elementName = (String) o;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }

        if (size == 0) {
            return false;
        }

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Entry<String> thisEntry = queue.poll();

            if (!thisEntry.availableToAddLeftChildren) {
                if (thisEntry.leftChild.elementName.equals(elementName)) {
                    thisEntry.leftChild = null;
                    thisEntry.checkChildren();
                    size--;
                    return true;
                } else {
                    queue.offer(thisEntry.leftChild);
                }
            }

            if (!thisEntry.availableToAddRightChildren) {
                if (thisEntry.rightChild.elementName.equals(elementName)) {
                    thisEntry.rightChild = null;
                    thisEntry.checkChildren();
                    size--;
                    return true;
                } else {
                    queue.offer(thisEntry.rightChild);
                }
            }
        }

        return false;
    }
//
//            if ((thisEntry.parent.rightChild != thisEntry) && (thisEntry.parent.leftChild != thisEntry)) {
//                continue;
//            }
//
//            if (thisEntry.leftChild != null) {
//                if (thisEntry.availableToAddLeftChildren && thisEntry.availableToAddRightChildren) {
//                    thisEntry.leftChild = null;
//                    size--;
//
//                } else {
//                    queue.offer(thisEntry.leftChild);
//                }
//            }
//
//            if (thisEntry.rightChild != null) {
//                if (thisEntry.availableToAddLeftChildren && thisEntry.availableToAddRightChildren) {
//                    thisEntry.rightChild = null;
//                    size--;
//                } else {
//                    queue.offer(thisEntry.rightChild);
//                }
//            }
//
//            if (thisEntry.leftChild == null && thisEntry.rightChild == null) {
//                if (thisEntry.parent.leftChild == thisEntry) {
//                    thisEntry.parent.leftChild = null;
//                    size--;
//                } else {
//                    thisEntry.parent.rightChild = null;
//                    size--;
//                }
//            } else {
//                queue.offer(thisEntry);
//            }
//        }
//
//        return true;
//    }

    @Override
    public int size() {
        int result = -1;

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Entry<String> thisEntry = queue.poll();
            result++;


            if (!thisEntry.availableToAddLeftChildren) {
                queue.offer(thisEntry.leftChild);
            }

            if (!thisEntry.availableToAddRightChildren) {
                queue.offer(thisEntry.rightChild);
            }
        }

        return result;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}
