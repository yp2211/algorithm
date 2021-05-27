# 6、クイックソート （Quick Sort）

クイックソート (quicksort) は、1960年にアントニー・ホーアが開発したソートのアルゴリズム。分割統治法の一種。

n個のデータをソートする際の最良計算量および平均計算量はO(n log n)である。他のソート法と比べて、一般的に最も高速だといわれているが対象のデータの並びやデータの数によっては必ずしも速いわけではなく、最悪の計算量はO(n^2)である。また数々の変種がある。 安定ソートではない。

## 6.1 アルゴリズムの説明

クイックソートは分割統治法を使用して、リストを2つのサブリストに分割します。 具体的なアルゴリズムは次のとおりです。

* シーケンスから要素を選択し、それを「ピボット pivot」と呼びます。
* シーケンスを並べ替えると、ベンチマーク値よりも小さいすべての要素がベンチマークの前に配置され、ベンチマーク値よりも大きいすべての要素がベンチマークの後ろに配置されます（同じ番号をどちらの側にも配置できます）。 パーティションが終了した後、ベンチマークはシーケンスの途中にあります。 これは分割（partition）と呼ばれます。
* 二分割された各々のデータを、それぞれソートする

## 6.2 可視化デモ

![](../../../resources/sort/QuickSort.gif)

## 6.3 実装

```java
　　/**
     * クイックソート
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * クイックソートアルゴリズム-分割partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    /**
     * 配列内の2つの要素を交換する
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

```

## 6.4 性能評価
* 最良時間計算量：T(n) = O(nlogn)   
* 最悪時間計算量：T(n) = O(n^2)   
* 平均時間計算量：T(n) = O(nlogn)　
