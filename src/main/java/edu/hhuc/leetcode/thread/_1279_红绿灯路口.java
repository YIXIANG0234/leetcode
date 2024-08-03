package edu.hhuc.leetcode.thread;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/29 16:20:12
 */
public class _1279_红绿灯路口 {

    class TrafficLight1 {

        /**
         * @param carId     为到达车辆的编号
         * @param roadId    为车辆所在道路的编号
         * @param direction 为车辆的行进方向
         * @param turnGreen 是一个函数，调用此函数会使当前道路上的绿灯亮起
         * @param crossCar  是一个函数，调用此函数会允许车辆通过路口
         */
        public synchronized void carArrived(int carId, int roadId, int direction, Runnable turnGreen, Runnable crossCar) {

        }
    }
}
