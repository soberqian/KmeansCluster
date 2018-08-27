package com.clustering;

import com.utils.Vector;
/** �����ز������� */
public class Cluster implements Comparable<Cluster> {
	private Vector centroid;
	private final DataList datas = new DataList();
	private final int numFeatures;

	/** ���ȡһ�����ݵ���Ϊ���� */
	public Cluster(Data data) {
		add(data);
		centroid = new Vector(data.getVector());
		numFeatures = data.getNumFeatures();
	}
	/** �����������,��������������Ϊ�ѷ��� */
	public void add(Data data) {
		data.setIsAllocated();
		datas.add(data);
	}
	/** �����е������Ƴ� */
	public void clear() {
		datas.clearIsAllocated();
		datas.clear();
	}
	/** �Դ��е����ݽ�������. */
	@Override
	public int compareTo(Cluster cluster) {
		if (datas.isEmpty() || cluster.datas.isEmpty()) {
			return 0;
		}
		return datas.get(0).compareTo(cluster.datas.get(0));
	}
	/** ��ȡ���� */
	public Vector getCentroid() {
		return centroid;
	}
	/** ��ȡ���� */
	public DataList getDatas() {
		return datas;
	}

	/** �������ݵ����� */
	public int size() {
		return datas.size();
	}

	/** �������ݵ��id������ */
	public void sort() {
		datas.sort();
	}
	/** ��Ҫչʾ�Ľ�� */
	@Override
	public String toString() {
		return datas.toString();
	}

	/** ���¸� �ص����� */
	public void updateCentroid() {
		centroid = new Vector(numFeatures);
		//�ô��е����ݽ���ѭ��
		for (Data data : datas) {
			centroid = centroid.add(data.getVector());
		}
		centroid = centroid.divide(size());
	}
}
