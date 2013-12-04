package org.du.dm.dao;

public interface DatabaseDaoInterface<M,C> {
	
	public M get(M i, C c);
	public void modify(M m1, M m2, C c);
	public void insert(M m, C c);

}
