package org.du.dm.dao;

public interface DatabaseDaoInterface<M> {
	
	public M get(M i);
	public void modify(M m1, M m2);
	public void insert(M m);

}
