package org.du.dm.weka.classify;

import weka.classifiers.Classifier;
import weka.core.Instances;

/**
 * Class to execute various classifiers
 * @author neha
 */

public class ExecuteClassifier implements IExecuteClassifier<Instances, Classifier> {

	@Override
	public Instances classify(Classifier j, Instances dataToTest) throws Exception {
		for (int i = 0; i < dataToTest.numInstances(); i++)
		{ 
			double pred = j.classifyInstance(dataToTest.instance(i)); 
			dataToTest.instance(i).setValue(dataToTest.numAttributes()-1, pred);
		}
		
		return dataToTest;
	}

	@Override
	public Classifier build(Instances i, Classifier j) throws Exception {
		j.buildClassifier(i);
		return j;
	}

}
