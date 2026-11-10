package com.facebook.stetho.common;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes8.dex */
public final class ListUtil {

    private static final class FiveItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;
        private final E mItem4;

        public FiveItemImmutableList(E e12, E e13, E e14, E e15, E e16) {
            this.mItem0 = e12;
            this.mItem1 = e13;
            this.mItem2 = e14;
            this.mItem3 = e15;
            this.mItem4 = e16;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i12) {
            if (i12 == 0) {
                return this.mItem0;
            }
            if (i12 == 1) {
                return this.mItem1;
            }
            if (i12 == 2) {
                return this.mItem2;
            }
            if (i12 == 3) {
                return this.mItem3;
            }
            if (i12 == 4) {
                return this.mItem4;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 5;
        }
    }

    private static final class FourItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;

        public FourItemImmutableList(E e12, E e13, E e14, E e15) {
            this.mItem0 = e12;
            this.mItem1 = e13;
            this.mItem2 = e14;
            this.mItem3 = e15;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i12) {
            if (i12 == 0) {
                return this.mItem0;
            }
            if (i12 == 1) {
                return this.mItem1;
            }
            if (i12 == 2) {
                return this.mItem2;
            }
            if (i12 == 3) {
                return this.mItem3;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 4;
        }
    }

    private static final class ImmutableArrayList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final Object[] mArray;

        public ImmutableArrayList(Object[] objArr) {
            this.mArray = objArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i12) {
            return (E) this.mArray[i12];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.mArray.length;
        }
    }

    private interface ImmutableList<E> extends List<E>, RandomAccess {
    }

    private static final class OneItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem;

        public OneItemImmutableList(E e12) {
            this.mItem = e12;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i12) {
            if (i12 == 0) {
                return this.mItem;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }
    }

    private static final class ThreeItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;

        public ThreeItemImmutableList(E e12, E e13, E e14) {
            this.mItem0 = e12;
            this.mItem1 = e13;
            this.mItem2 = e14;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i12) {
            if (i12 == 0) {
                return this.mItem0;
            }
            if (i12 == 1) {
                return this.mItem1;
            }
            if (i12 == 2) {
                return this.mItem2;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 3;
        }
    }

    private static final class TwoItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;

        public TwoItemImmutableList(E e12, E e13) {
            this.mItem0 = e12;
            this.mItem1 = e13;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i12) {
            if (i12 == 0) {
                return this.mItem0;
            }
            if (i12 == 1) {
                return this.mItem1;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 2;
        }
    }

    private ListUtil() {
    }

    public static <T> List<T> copyToImmutableList(List<T> list) {
        if (list instanceof ImmutableList) {
            return list;
        }
        int size = list.size();
        return size != 0 ? size != 1 ? size != 2 ? size != 3 ? size != 4 ? size != 5 ? new ImmutableArrayList(list.toArray()) : new FiveItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)) : new FourItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3)) : new ThreeItemImmutableList(list.get(0), list.get(1), list.get(2)) : new TwoItemImmutableList(list.get(0), list.get(1)) : new OneItemImmutableList(list.get(0)) : Collections.emptyList();
    }

    public static <T> boolean identityEquals(List<? extends T> list, List<? extends T> list2) {
        if (list == list2) {
            return true;
        }
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        for (int i12 = 0; i12 < size; i12++) {
            if (list.get(i12) != list2.get(i12)) {
                return false;
            }
        }
        return true;
    }

    public static <T> List<T> newImmutableList(T t12) {
        return new OneItemImmutableList(t12);
    }

    public static <T> List<T> newImmutableList(T t12, T t13) {
        return new TwoItemImmutableList(t12, t13);
    }
}
