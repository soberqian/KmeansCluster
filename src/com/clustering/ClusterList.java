package com.clustering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/** ����ز�������  */
public class ClusterList implements Iterable<Cluster> {
	private final ArrayList<Cluster> clusters = new ArrayList<Cluster>();
	/** ���һ���� */
	public void add(Cluster cluster) {
		clusters.add(cluster);
	}
	/**
	 * ��������Ҫ���ص�����ȫ���Ƴ�
	 */
	public void clear() {
		for (Cluster cluster : clusters) {
			cluster.clear();
		}
	}
	/**
	 * ����δ��������������ĵľ��룬ȷ��һ����������Զ��һ����,������õ���ŷ����þ��빫ʽ
	 * @param DistanceMetric,���� 
	 * @param DataList,���ݼ���
	 * @return Data,���ݵ�
	 */
	public Data findFurthestData(DistanceMetric distance, DataList dataList) {
		double furthestDistance = Double.MIN_VALUE;
		Data furthestData = null;
		for (Data data : dataList) {
			if (!data.isAllocated()) {
				//����Զ����
				double dataDistance = distance.calcDistance(data, this);
				if (dataDistance > furthestDistance) {
					furthestDistance = dataDistance;
					furthestData = data;
				}
			}
		}
		return furthestData;
	}
	/**
	 * Ѱ�����ݵ�data��������Ĵ� 
	 *
	 * @param DistanceMetric,���� 
	 * @param data,����
	 * @return Cluster,��
	 */
	public Cluster findNearestCluster(DistanceMetric distance, Data data) {
		Cluster nearestCluster = null;
		double nearestDistance = Double.MAX_VALUE;
		for (Cluster cluster : clusters) {
			//�������
			double clusterDistance = distance.calcDistance(data, cluster);
			if (clusterDistance < nearestDistance) {
				nearestDistance = clusterDistance;
				nearestCluster = cluster;
			}
		}
		return nearestCluster;
	}

	@Override
	public Iterator<Cluster> iterator() {
		return clusters.iterator();
	}

	/**���شص����� */
	public int size() {
		return clusters.size();
	}
	/**
	 *���ݵ��������,Ȼ������cluster
	 */
	private void sort() {
		for (Cluster cluster : this) {
			cluster.sort();
		}
		Collections.sort(clusters);
	}
	/**
	 * ��������չʾ���
	 */
	public String toString() {
		sort();
		StringBuilder sb = new StringBuilder();
		int clusterIndex = 0;
		for (Cluster cluster : clusters) {
			sb.append("Cluster ");
			sb.append(clusterIndex++);
			sb.append("\n");
			sb.append(cluster);
		}
		return sb.toString();
	}

	/**���ڸ�ά�ȵ�����ƽ��ֵ����ÿ�������� */
	public void updateCentroids() {
		for (Cluster cluster : clusters) {
			cluster.updateCentroid();
		}
	}

}
