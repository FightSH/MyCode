package com.shen.carl.array

object BinarySearch {

  def main(args: Array[String]): Unit = {


    println(solution(Array(1, 2, 3, 4, 5, 6, 7), 5))
  }



  def solution(nums:Array[Int],target:Int): Int = {
    var left = 0
    var right = nums.length
    while (left < right) {


      val mid = left + (right-left)/2
      if(nums(mid)==target){
        return mid
      }

      if(nums(mid)<target){
        left = mid
      }
      if(nums(mid)>target){
        right = mid+1
      }

    }
    -1
  }


}
