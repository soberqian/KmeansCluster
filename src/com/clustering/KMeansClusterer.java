package com.clustering;

import java.util.Random;

public class KMeansClusterer implements Clusterer {
	private static final Random RANDOM = new Random();
	private final int clusteringIterations;
	private final DistanceMetric distance;
	/**
	 * Construct a Clusterer.
	 * @param K-means������Ҫʹ�õ��ľ��빫ʽ
	 * @param k-means�ĵ�������
	 */
	public KMeansClusterer(DistanceMetric distance, int clusteringIterations) {
		this.distance = distance;
		this.clusteringIterations = clusteringIterations;
	}

	/** ��������δ��������ݵ㵽���ĵľ���,������Сԭ������ݷ���� */
	private void assignUnallocatedDataPoints(DataList dataList, ClusterList clusterList) {
		for (Data data : dataList) {
			if (!data.isAllocated()) {
				//Ѱ����data���ݵ�����Ĵ�
				Cluster nearestCluster = clusterList.findNearestCluster(distance, data);
				//������data��ӵ��ô���
				nearestCluster.add(data);
			}
		}
	}
	/** ������Զ���봴��һ���µĴ� */
	private Cluster createClusterBasedFurthestData(DataList dataList,ClusterList clusterList) {
		//��������ĵ���Զ�ĵ�
		Data furthestDocument = clusterList.findFurthestData(distance, dataList);
		//����һ���µĴ�
		Cluster nextCluster = new Cluster(furthestDocument);
		return nextCluster;
	}

	/** ���ѡ��һ�����ݵ���Ϊ���� */
	private Cluster createClusterWithRandomlySelectedDataPoint(DataList dataList) {
		int rndDataIndex = RANDOM.nextInt(dataList.size()); // ���ȡ���ݱ��
		//���ñ�Ŷ�Ӧ�����ݵ���з���,�������ݱ��Ϊ�ѷ���
		Cluster initialCluster = new Cluster(dataList.get(rndDataIndex));  
		return initialCluster;
	}

	/** kmeans���в���*/
	public ClusterList runKMeansClustering(DataList dataList, int k) {
		ClusterList clusterList = new ClusterList();
		dataList.clearIsAllocated();  //������ݷ���
		//���ѡ��һ���㣬����һ����ʼ�Ĵ�
		clusterList.add(createClusterWithRandomlySelectedDataPoint(dataList));
		//����ص�����С�ڶ���Ĵص�����,��������ʵ���Զ�ĵ�,�����µĴ�
		while (clusterList.size() < k) {
			clusterList.add(createClusterBasedFurthestData(dataList, clusterList));
		}
		//��ʼ����
		for (int iter = 0; iter < clusteringIterations; iter++) {
			//�������ĺ����ݵ�ľ���,����û�з��������
			assignUnallocatedDataPoints(dataList, clusterList);
			//��������,ȡÿ�����������ݵ�ĸ�ά�ȵľ�ֵ
			clusterList.updateCentroids();
			if (iter < clusteringIterations - 1) {
				//���е��������,�������µ�������
				clusterList.clear();
			}
		}
		return clusterList;
	}
}
