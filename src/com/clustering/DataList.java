package com.clustering;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.utils.Vector;

/** ���ݼ��ϱ�ʾ�Ͳ������� */
public class DataList implements Iterable<Data> {
	private final List<Data> datas = new ArrayList<Data>();
	/** ����յ�DataList */
	public DataList() {
	}
	public DataList(String input,int numFeatures) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( new FileInputStream( new File(input)),"gbk"));
		String s = null;
		int i = 0;
		while ((s=reader.readLine())!=null) {
			//����
			String arry[] =s.split("\t");
			//��������
			String[] vectorString = arry[1].split("\\s+");
			Vector vector = new Vector(numFeatures);
			for (int j = 0; j < vectorString.length; j++) {
				//�������ֵ
				vector.set(j, Double.parseDouble(vectorString[j]));
			}
			//�ĵ�������
			String title =arry[0];
			//������,��Ӧ������,��Ӧ������
			Data data = new Data(i, title);
			data.setVector(vector);
			datas.add(data);
			i++;
		}
		reader.close();

	}
	/** ���������DataList */
	public void add(Data data) {
		datas.add(data);
	}

	/** ���ݼ����Ƴ� */
	public void clear() {
		datas.clear();
	}

	/** ���������ݵ�����Ϊδ���� */
	public void clearIsAllocated() {
		for (Data data : datas) {
			data.clearIsAllocated();
		}
	}

	/** ��ȡidΪindex�����ݵ� */
	public Data get(int index) {
		return datas.get(index);
	}
	/** ȷ�������Ƿ�Ϊ�� */
	public boolean isEmpty() {
		return datas.isEmpty();
	}

	@Override
	public Iterator<Data> iterator() {
		return datas.iterator();
	}

	/** ���ݵ����� */
	public int size() {
		return datas.size();
	}

	/** �������� */
	public void sort() {
		Collections.sort(datas);
	}
	/** ��Ҫչʾ�Ľ�� */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Data data : datas) {
			sb.append("  ");
			//��ȡ����
			sb.append(data.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
