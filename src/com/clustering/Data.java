package com.clustering;

import com.utils.Vector;

/** �������ݵ��ʾ���� */
public class Data implements Comparable<Data> {
	private final String title;
	private final long id;
	private boolean allocated;
	private  Vector vector;
	private int numFeatures;

	public Data(long id, String title) {
		this.id = id;
		this.title = title;
	}
	/** ���ݵ�������� */
	public void clearIsAllocated() {
		allocated = false;
	}

	/** �̳�,����id������� */
	@Override
	public int compareTo(Data data) {
		if (id > data.getId()) {
			return 1;
		} else if (id < data.getId()) {
			return -1;
		} else {
			return 0;
		}
	}

	/** ��ȡ����id */
	public long getId() {
		return id;
	}
	/**��ȡ���ݱ��� */
	public String getTitle() {
		return title;
	}
	/** ��ȡ����Ψ�� */
	public int getNumFeatures() {
		return numFeatures;
	}

	/**
	 * ��ȡ��������
	 */
	public Vector getVector() {
		return vector;
	}

	/** ȷ�������Ƿ񱻷��䵽�� */
	public boolean isAllocated() {
		return allocated;
	}


	/** ��Ǹ����ݵ��ѱ����� */
	public void setIsAllocated() {
		allocated = true;
	}
	/**
	 * ����������ά��
	 */
	public void setVector(Vector vector) {
		this.vector = vector;
		this.numFeatures = vector.size();
	}
	//Ĭ�����
	public String toString() {
		return "Data: " + id + ", Title: " + title;
	}
}
