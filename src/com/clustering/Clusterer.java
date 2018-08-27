package com.clustering;

/**
 * ¾ÛÀà½Ó¿Ú
 */
public interface Clusterer {
	public ClusterList runKMeansClustering(DataList documentList, int k);
}
