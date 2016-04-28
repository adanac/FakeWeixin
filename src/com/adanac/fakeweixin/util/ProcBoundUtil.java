package com.adanac.fakeweixin.util;

import com.adanac.fakeweixin.constant.Constant;

public class ProcBoundUtil {

	public static int[] procBound(int width, int height) {
		int[] res = new int[2];
		double r0 = Constant.BOUND_WIDTH / width;

		res[0] = (int) (width < Constant.BOUND_WIDTH ? width * r0
				: Constant.BOUND_WIDTH);
		res[1] = (int) (height < Constant.BOUND_HEIGHT ? height * r0
				: Constant.BOUND_HEIGHT);
		return res;
	}
}
