# 8、カウントソート（Counting Sort）
カウントソート（Counting Sort）の中核は、入力データ値をキーに変換し、それらを追加の配列スペースに格納することです。 一種の線形時間計算量として、カウントソートでは、入力データが特定の範囲の整数である必要があります。

カウントソートは、安定したソートアルゴリズムです。 カウントソートでは、追加の配列Cが使用されます。ここで、i番目の要素は、値がiに等しいソートされる配列A内の要素の数です。 次に、配列Cに従って、Aの要素を正しい位置に配置します。 整数のみをソートできます。

## 8.1 アルゴリズムの説明
* 並べ替える配列内の最大要素と最小要素を見つける。
* 配列内の値iを持つ各要素の出現回数をカウントし、配列Cのi番目の項目に格納する。
* すべてのカウントを累積する（Cの最初の要素から開始して、各アイテムが前のアイテムに追加される）。
* ターゲット配列を埋め戻す：各要素iを新しい配列のC（i）アイテムに配置し、要素を配置するたびにC（i）から1を減算する。

## 8.2 可視化デモ
![](../../../resources/sort/CountingSort.gif)

## 8.3 実装

```java
    /**
     * Counting Sort
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }

```

## 8.4 性能評価
入力要素は[0, k]のn個の整数の場合、その実行時間はO（n + k）です。 カウントソートは比較ソートではなく、ソートの速度はどの比較ソートアルゴリズムよりも高速です。 カウントに使用される配列Cの長さは、ソートされる配列内のデータの範囲（ソートされる配列の最大値と最小値の差に1を加えたものに等しい）に依存するため、これによりカウントソートが行われます。広範囲のデータを持つ配列には大量の時間とメモリが必要です。

* 最良時間計算量：T(n) = O(n+k)  
* 最悪時間計算量：T(n) = O(n+k)  
* 平均時間計算量：T(n) = O(n+k)

***