package com.clustering;

/**
 * ����ӿ�
 */
public interface Clusterer {
	public ClusterList runKMeansClustering(DataList documentList, int k);
}
