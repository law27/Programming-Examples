subSeq :: String -> String -> Bool
subSeq "" two = True
subSeq one "" = False
subSeq (one:ones) (two:twos)
    | (one == two) = subSeq ones twos
    | otherwise = subSeq (one:ones) twos


subWord :: String -> String -> Bool
subWord "" two = True
subWord one "" = False
subWord one two
    | (one == two) = True
    | ((length one) > (length two)) = False
    | ((take (length one) two) == one) = True
    | otherwise = subWord one (tail two)


isMatrix :: [[a]] -> Bool
isMatrix matrix
    | (length matrix == 0) = False
    | (length (head matrix) == 0) = False
    | otherwise = length matrix == length [x | x <- matrix, length x == length (head matrix)] 

isSquareMatrix :: [[a]] -> Bool
isSquareMatrix matrix
    | (length matrix == 0) = False
    | (length (head matrix) == 0) = False
    | otherwise = length matrix == length [x | x <- matrix, length x == length matrix] 

addable :: [[a]] -> [[a]] -> Bool
addable arrayOne arrayTwo
    | (length arrayOne /= length arrayTwo) = False
    | otherwise = (length arrayOne * length arrayTwo) == length [(x,y) | x <- arrayOne, y <- arrayTwo, length x == length y]

addMatrices :: [[Int]] -> [[Int]] -> [[Int]]
addMatrices one two = zipWith (zipWith (+)) one two

multiplyable :: [[a]] -> [[a]] -> Bool
multiplyable one two = length one == length [ x | x <- one, length x == length two]
