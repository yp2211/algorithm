# 1、バブルソート（Bubble Sort）

バブルソートは単純なソートアルゴリズムです。 ソートするシーケンスに繰り返しアクセスし、一度に2つの要素を比較し、順序が間違っている場合はそれらを交換しました。 シーケンスにアクセスする作業は、交換が不要になるまで、つまりシーケンスがソートされるまで繰り返されます。 このアルゴリズムの名前の由来は、要素が小さいほど、交換によってシーケンスの先頭にゆっくりと「フロート」するためです。

## 1.1 アルゴリズムの説明

* 隣接する要素を比較します。 最初のものが2番目のものよりも大きい場合は、2つを交換します。

* 隣接する要素の各ペアに対して、最初の最初のペアから最後の最後のペアまで同じ作業を行い、最後の要素が最大数になるようにします。

* 最後の要素を除くすべての要素に対して上記の手順を繰り返します。

* ソートが完了するまで、手順1〜3を繰り返します。

## 1.2 可視化デモ

![bubbleSort.gif](https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/196344/ee67103b-c6e1-55c0-bcce-d84d8756fbd3.gif)

## 1.3 実装

```java
    /**
     * Bubble Sort
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }
```

## 1.4 性能評価

* 最良時間計算量 ：T(n) = O(n) 
* 最悪時間計算量 ：T(n) = O(n2) 
* 平均時間計算量 ：T(n) = O(n2)

* * *
