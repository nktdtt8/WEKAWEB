package org.du.dm.weka.classify;

public interface IExecuteClassifier<I,J> {

	public I classify(J j, I i) throws Exception;
	public J build(I i, J j) throws Exception;
}
