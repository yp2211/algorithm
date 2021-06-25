# 9、桶排序（Bucket Sort）
バケットソートは、カウントソートのアップグレードバージョンです。 関数のマッピング関係を利用しており、高効率の秘訣はマッピング関数の決定にあります。 バケットソートの動作原理：入力データが均一に分散されていると仮定すると、データは限られた数のバケットに分割され、各バケットは個別にソートされます（別のソートアルゴリズムを使用することも、再帰的に使用し続けることもできます）。バケットソートが実行される方法）。

## 9.1 アルゴリズムの説明

* 定長の配列を空バケットとして用意する。
* 入力データをトラバースし、データを1つずつ対応するバケットに入れる。
* 空でないすべてのバケットを並べ替える。
* 空ではないバケットからソートされたデータを連結する。

**バケットソートを再帰的に使用して各バケットをソートする場合は、バケット数が1のときに手動でBucketSizeを減らし、次のサイクルでバケット数を増やす必要があります。そうしないと、無限ループに陥り、メモリオーバーフローが発生します。**

## 9.2 可視化デモ
![](../../../resources/sort/bucketSort.png)

## 9.3 実装

```java
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // Find the maximum and minimum values
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            // If there are duplicate numbers in the sorted array
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }
```

## 9.4 性能評価
バケットソートの最良の場合は線形時間O（n）です。バケットソートの時間計算量は、他の部分の時間計算量がO（n）であるため、各バケット間のデータのソートの時間計算量に依存します。 明らかに、分割されるバケットが小さいほど、各バケット間のデータが少なくなり、並べ替えにかかる時間が短くなります。 ただし、対応する空間（メモリ）消費量は増加します。

* 最良時間計算量：T(n) = O(n+k)   
* 最悪時間計算量：T(n) = O(n+k)   
* 平均時間計算量：T(n) = O(n2)　　

* * * 