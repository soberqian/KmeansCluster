package com.utils;

import java.util.Arrays;

/**
 * ��������
 */
public class Vector {
	private final double[] elements;

	/** �̶����ȵ��������� */
	public Vector(int size) {
		elements = new double[size];
	}

	/** �������� */
	public Vector(Vector vector) {
		elements = Arrays.copyOf(vector.elements, vector.elements.length);
	}

	/** �����ļӺͲ��� */
	public Vector add(Vector operAddition) {
		Vector result = new Vector(size());
		for (int i = 0; i < elements.length; i++) {
			result.set(i, get(i) + operAddition.get(i));
		}
		return result;
	}

	/** ��������һ������ */
	public Vector divide(double divisor) {
		Vector result = new Vector(size());
		for (int i = 0; i < elements.length; i++) {
			result.set(i, get(i) / divisor);
		}
		return result;
	}

	/** ��ȡ�����ĵ�i��ֵ */
	public double get(int i) {
		return elements[i];
	}
	/** ��������֮���ŷ����þ��� */
	public double getEuclideanDistance(Vector vector) {
		double euclideanDistance = 0;
		for (int i = 0; i < elements.length; i++) {
			euclideanDistance += Math.pow(get(i) - vector.get(i), 2);;
		}
		return Math.sqrt(euclideanDistance);
	}
	/** �������ֵ */
	public void set(int i, double value) {
		elements[i] = value;
	}

	/** ����elements�ĳ��� */
	public int size() {
		return elements.length;
	}
	@Override
	public String toString() {
		return Arrays.toString(elements);
	}
}