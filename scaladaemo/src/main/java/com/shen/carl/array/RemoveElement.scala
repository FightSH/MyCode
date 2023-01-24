package com.shen.carl.array

object RemoveElement {
  def main(args: Array[String]): Unit = {

    solution(Array(1, 2, 3), 2)
  }

  def solution(nums: Array[Int], value: Int): Int = {
    var slow = 0
    for (fast <- 0 until nums.length) {
      if (nums(fast) != value) {
        nums(slow) = nums(fast)
        slow += 1
      }
    }
    slow
  }

}
