# 5、マージソート（Merge Sort）

選択ソートと同様に、マージソートのパフォーマンスは入力データの影響を受けませんが、常にO（n log n）の時間計算量であるため、選択ソートよりもはるかに優れたパフォーマンスを発揮します。 価格は、追加のメモリスペースの必要性です。

マージソートは、マージ操作に基づく効果的なソートアルゴリズムです。 このアルゴリズムは、分割統治法の非常に典型的なアプリケーションです。 マージソートは安定したソート方法です。 既存の順序付けられたサブシーケンスを組み合わせて、完全に順序付けられたシーケンスを取得します。つまり、最初に各サブシーケンスを順番に作成し、次にサブシーケンスを順番に作成します。 2つの順序付きリストが1つの順序付きリストにマージされる場合、それは双方向マージと呼ばれます。

## 5.1 アルゴリズムの説明

* データ列を分割する（通常、二等分する）
* 分割された各データ列で、含まれるデータが1個ならそれを返し、2個以上ならステップ1から3を再帰的に適用してマージソートする
* 二つのソートされたデータ列（1個であればそれ自身）をマージする

## 5.2 可視化デモ

![](../../../resources/sort/MergeSort.gif)

## 5.3 代码实现

```java

　　/**
     * マージソート
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * マージソート-2つのソートされた配列を1つのソートされた配列に結合
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
```

## 5. 4 性能評価

マージソートは安定したソート方法です。 選択ソートと同様に、マージソートのパフォーマンスは入力データの影響を受けませんが、常にO（nlogn）時間計算量であるため、選択ソートよりもはるかに優れたパフォーマンスを発揮します。 価格は、追加のメモリスペースの必要性です。

* 最良時間計算量：T(n) = O(n)  
* 最悪時間計算量：T(n) = O(nlogn)  
* 平均時間計算量：T(n) = O(nlogn)

***