package com.clustering;

import com.utils.Vector;

/** ������������֮���ŷ����þ��� */
public class EuclideanDistance extends DistanceMetric {
	protected double calcDistance(Vector vector1, Vector vector2) {
		return vector1.getEuclideanDistance(vector2);
	}
}
