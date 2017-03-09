SUM_TEST=../sum_array/sum_test
FIND_MAX=../find_max/find_max_test
FIB_REC=../fib_rec/fib_rec_test
FIB_ITER=../fib_iter/fib_iter_test

echo "START TESTING...\n"
echo "TEST sum_array"

echo "[16,2,6,123,43,12,-34,1,0,-4,-20]"
$SUM_TEST [16,2,6,123,43,12,-34,1,0,-4,-20] 11

echo "[-34,4,89,-28,-88,-12,-39,0,22,-32]"
$SUM_TEST [-34,4,89,-28,-88,-12,-39,0,22,-32] 10

echo "[-34,2,14,6,-6,13,5]"
$SUM_TEST [-34,2,14,6,-6,13,5] 7



echo "\nTEST find_max"
echo "[16,2,6,123,43,12,-34,1,0,-4,-20]"
$FIND_MAX [16,2,6,123,43,12,-34,1,0,-4,-20] 11

echo "[-34,4,89,-28,-88,-12,-39,0,22,-32]"
$FIND_MAX [-34,4,89,-28,-88,-12,-39,0,22,-32] 10

echo "[-34,2,14,6,-6,13,5]"
$FIND_MAX [-34,2,14,6,-6,13,5] 7



echo "\nTEST fib_iter"
i=0
while [ $i -lt 21 ]
do
	echo "input:\t$i"
	$FIB_ITER $i
	i=` expr $i + 1 `
done



echo "\nTEST fib_rec"
i=0
while [ $i -lt 21 ]
do
	echo "input:\t$i"
	$FIB_REC $i
	i=` expr $i + 1 `
done

