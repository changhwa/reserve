package com.test.reserve.inform.learningtest.priorityqueue;

public class Element implements Comparable<Element> {
	private int num; // 정렬의 기준이 될 값

	public Element(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public int compareTo(Element o) {
		return num <= o.num ? 1 : -1;
	}
}