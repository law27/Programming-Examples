xor :: Bool -> Bool -> Bool
xor b1 b2 = (b1 && (not b2)) || ((not b2) && b1)

