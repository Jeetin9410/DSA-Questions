package android_developer_practice_questions.leetcodeHard

import java.lang.StringBuilder


fun main(args: Array<String>) {
        val nums = intArrayOf(4,3,2,1)

       /*
       MY idea :
       I will take too pointers and first make a sorted array of given array
       then compare the given array with sorted array,

        and if the element at i=0 is same in both the array, it will be removed else it will be added at the end

       0,2,4,3,5,1
       0,1,4,3,5,2
       0,1,2,3,5,4
       0,1,2,3,4,5


       2,3,4,5,0,1
       3,4,5,0,1,2
       4,5,0,1,2,3
       5,0,1,2,3,4
       0,1,2,3,4,5
       1,2,3,4,5
       2,3,4,5
       3,4,5,
       4,5
       5
       []
        */


        /*var sortedNums = nums.sorted().toMutableList()

        val numList = nums.toMutableList()
        val i = 0
        var count = 0;
        while (numList.isNotEmpty()){
            val num = numList[i]
             if(num == sortedNums[i]){
                 numList.removeAt(i)
                 sortedNums.removeAt(i)
                 count++
             }else{
                 numList.remove(num)
                 numList.add(num)
                 count++
             }
        }

        println(count)*/

        /***********       Above solution is correct but requires optimisation in terms of implementation     **********/

        //step 1
        print("\n\nStep 1\n")
        nums.withIndex().forEach{
            println(it)
        }

        // step 2
        print("\n\nStep 2\n")
        nums.withIndex().sortedBy { it.value }.forEach{
            println(it)
        }

        // step 3
        print("\n\nStep 3\n")
        nums.withIndex().sortedBy { it.value }.map { it.index }.forEach {
            println(it)
        }

        print("\n\nStep 4\n")
        nums.withIndex().sortedBy { it.value }.map { it.index }.windowed(size = 2).forEach {
            println(it)
        }

        print("\n\nStep 5\n")
        nums.withIndex().sortedBy { it.value }.map { it.index }.windowed(size = 2).withIndex().forEach{
            println(it)
        }

        print("\n\nStep 6\n")
        nums.withIndex().sortedBy { it.value }.map { it.index }.windowed(size = 2).withIndex().filter {
            it.value[0] > it.value[1]
        }.forEach {
            println(it)
        }

        print("\n\nStep 7\n")
    var count = nums.size  +   nums.withIndex().sortedBy { it.value }.map { it.index }.windowed(size = 2)
            .withIndex()
            .filter {
            it.value[0] > it.value[1]
        }.map{ nums.size -  it.index - 1L}.sum()

        println(count)


      val list =  "I,am,Jeetin,kumar,anand".replace(",".toRegex(),"\n")
       println(list)

}




