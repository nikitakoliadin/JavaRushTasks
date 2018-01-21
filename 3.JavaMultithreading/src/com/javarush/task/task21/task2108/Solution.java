package com.javarush.task.task21.task2108;

import java.util.Arrays;
import java.util.Objects;

/*
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Plant)) return false;
            Plant plant = (Plant) o;
            return Objects.equals(getName(), plant.getName());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getName());
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException {
//            String[] branches = new String[this.branches.length];
//            branches = this.branches;
            Tree tree = new Tree(super.name, getBranches().clone());
            return tree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tree)) return false;
            Tree tree = (Tree) o;
            return Arrays.equals(getBranches(), tree.getBranches());
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(getBranches());
        }
    }
}
