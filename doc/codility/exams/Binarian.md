#[Rakuten CodilityTest](https://app.codility.com/test/79NYB7-EZZ/)

* 有长度为N的数组A[]，N范围[1...100000]

* A[]的所有元素值都为正整数，A[i]的值范围[1...10000];

* 设

    binarian(A) = ∑ pow2(A[i]); 

    即

    binarian(A) = pow2(A[0]) + pow2(A[1]) + ... + pow2(A[i]) + ... + pow2(A[N])

* pow2(i) = 2 ^ i;

* 则存在最短的数组B，与A的binarian值相同。

##求：B数组的长度。

##例1：
```$xslt
    A = {1,5,4}
    pow2(A[0]) = 2;
    pow2(A[1]) = 32;
    pow2(A[2]) = 16;
    binarian(A) = 50;

    B = {1, 4, 5}
    B.length -> 3
```

##例2：
```$xslt
    A = {1,0,2,0,0,2};
    pow2(A[0]) = 2;
    pow2(A[1]) = 1;
    pow2(A[2]) = 4;
    pow2(A[3]) = 1;
    pow2(A[4]) = 1;
    pow2(A[5]) = 4;
    binarian(A) = 13;
    
    B = {0, 2, 3}
    B.length -> 3
```

***
