package org.du.dm.dao;

public interface DatabaseDao<M> {
	
	public M get(M i);
	public void modify(M m1, M m2);
	public void insert(M m);

}
