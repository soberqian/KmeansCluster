package com.clustering;

import com.utils.Vector;

/**
 * ������:�������,����Խ��Խ����
 */
public abstract class DistanceMetric {
	/** �������ݵ�data����cluster���ĵľ��� */
	public double calcDistance(Data data, Cluster cluster) {
		return calcDistance(data.getVector(), cluster.getCentroid());
	}

	/**
	 * ����ĳһ���ݵ�data�������д����ĵ���Сֵ
	 * @param Data,���ݵ�
	 * @param ClusterList,�ؼ���
	 * @return distance,��С����
	 */
	public double calcDistance(Data data, ClusterList clusterList) {
		double distance = Double.MAX_VALUE;
		for (Cluster cluster : clusterList) {
			distance = Math.min(distance, calcDistance(data, cluster));
		}
		return distance;
	}

	/** ��������֮��ľ��� */
	protected abstract double calcDistance(Vector vector1, Vector vector2);
}
