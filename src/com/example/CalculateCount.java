package com.example;

public class CalculateCount {
	private static int[][] value;// 用于存储从n中选取k个元素的方法数

	public static int cal(int n, int k) {
		if (k > n) {
			return 0;
		}
		if (value[n][k] < 0) {
			if (k == n) {
				return 1;
			} else if (k == 1) {
				return n;
			} else {
				int result1 = cal(n - 1, k - 1);
				int result2 = cal(n - 1, k);
				value[n][k] = result1 + result2;
			}
		}
		return value[n][k];
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		value = new int[n + 1][k + 1];
		// 对value进行初始化
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				value[i][j] = -1;
			}
		}
		System.out.println("n=" + n + ",k=" + k + "时，结果为：" + cal(n, k));
	}
}
