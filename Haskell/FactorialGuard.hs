factorial :: Int -> Int
factorial 0 = 1
factotial n
    | n < 0 = factotial(-n)
    | n > 0 = n * factotial(n-1)
