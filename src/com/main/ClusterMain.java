package com.main;

import java.io.IOException;

import com.clustering.ClusterList;
import com.clustering.Clusterer;
import com.clustering.DistanceMetric;
import com.clustering.DataList;
import com.clustering.EuclideanDistance;
import com.clustering.KMeansClusterer;
import com.utils.OutPutFile;

public class ClusterMain {
	private static final int iter = 500; //�����ܵ�������
	private static final int feature_number = 2; //��������ά��
	private static final int k = 3;  //ȷ���ص���Ŀ
	public static void main(String[] args) throws IOException {
		//�ĵ�Ŀ¼
		String fileinput = "data/data.txt";
		//��ȡ�ļ�,����ת����������ʽ
		DataList documentList = new DataList(fileinput,feature_number);
		//������빫ʽ,����ʹ��ŷ����þ���
		DistanceMetric distance = new EuclideanDistance();
		Clusterer clusterer = new KMeansClusterer(distance, iter);
		//����
		ClusterList clusterList = clusterer.runKMeansClustering(documentList, k);
		System.out.println(clusterList);
		//������
		OutPutFile.outputClusterAndContent("result/cluster"+k,clusterList);
	}
}