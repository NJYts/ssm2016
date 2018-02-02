package com.atguigu.p2p.util;

import java.util.TreeMap;

/**
 * Created by WISE on 2017/8/8.
 */
public class StaticValue {
	public static TreeMap<Integer, String> groupMap = new TreeMap<Integer, String>();

	public static TreeMap<Integer, String> getGroupMap() {
		return groupMap;
	}

	public static void setGroupMap(TreeMap<Integer, String> groupMap) {
		StaticValue.groupMap = groupMap;
	}

}
